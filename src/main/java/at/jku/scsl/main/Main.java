package at.jku.scsl.main;

import at.jku.scsl.searchtool.BaseQuery;
import at.jku.scsl.searchtool.SearchTool;
import at.jku.scsl.searchtool.types.BooleanOperatorType;
import at.jku.scsl.searchtool.types.DatabaseType;
import at.jku.scsl.searchtool.types.MetaDataType;
import at.jku.scsl.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static at.jku.scsl.util.Util.FILE_PATH_SEP;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Welcome to the literature search tool!");

        String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
        List<String> allKeywords = Util.readKeywords(keywordFilePath);

        logger.info("Found {} keywords in '{}'", allKeywords.size(), keywordFilePath);

        List<String> firstHalfKeywords = allKeywords.subList(0, allKeywords.size() / 2);
        List<String> secHalfKeywords = allKeywords.subList(allKeywords.size() / 2, allKeywords.size());

        BaseQuery keywordQueryFirstHalf = new BaseQuery();
        keywordQueryFirstHalf.setKeywordList(firstHalfKeywords);
        keywordQueryFirstHalf.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery keywordQuerySecondHalf = new BaseQuery();
        keywordQuerySecondHalf.setKeywordList(secHalfKeywords);
        keywordQuerySecondHalf.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("\"software\"");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("\"security\"");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT);
        searchtool.addBaseQueries(keywordQueryFirstHalf, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String ieeeSearchStringFirstHalf = searchtool.generateSearchQuery(DatabaseType.IEEE_XPLORE);
        logger.info("Created search String for IEEE 1: {}", ieeeSearchStringFirstHalf);

        searchtool.reset();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT);
        searchtool.addBaseQueries(keywordQuerySecondHalf, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String ieeeSearchStringSecondHalf = searchtool.generateSearchQuery(DatabaseType.IEEE_XPLORE);
        logger.info("Created search String for IEEE 2: {}", ieeeSearchStringSecondHalf);
    }


}