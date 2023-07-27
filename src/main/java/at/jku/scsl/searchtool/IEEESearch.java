package at.jku.scsl.searchtool;

import at.jku.scsl.searchtool.types.BooleanOperatorType;
import at.jku.scsl.searchtool.types.DatabaseType;
import at.jku.scsl.searchtool.types.MetaDataType;
import at.jku.scsl.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static at.jku.scsl.util.Util.FILE_PATH_SEP;

public class IEEESearch {

    private static final Logger logger = LogManager.getLogger(IEEESearch.class);


    private IEEESearch() {
        throw new IllegalStateException("Utility class");
    }

    public static void searchIEEE() {
        // #1
//        searchIEEE_ONE();
        // #2
//        searchIEEE_TWO();
        // #3
//        searchIEEE_THREE();
        // #4
//        searchIEEE_FOUR();
    }


    private static void searchIEEE_FOUR() {
        String keywordFilePathFirstHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathSecondHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> firstHalfKeywords = Util.readKeywords(keywordFilePathFirstHalf);
        List<String> secHalfKeywords = Util.readKeywords(keywordFilePathSecondHalf);

        logger.info("Found {} keywords in '{}' and {}", firstHalfKeywords.size() + secHalfKeywords.size(), keywordFilePathFirstHalf, keywordFilePathSecondHalf);

        BaseQuery keywordQueryFirstHalf = new BaseQuery();
        keywordQueryFirstHalf.setKeywordList(firstHalfKeywords);
        keywordQueryFirstHalf.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery keywordQuerySecondHalf = new BaseQuery();
        keywordQuerySecondHalf.setKeywordList(secHalfKeywords);
        keywordQuerySecondHalf.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("\"software\"");
        softwareQuery.addKeyword("\"system\"");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("\"security\"");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQueryFirstHalf, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String ieeeSearchStringFirstHalf = searchtool.generateSearchQuery(DatabaseType.IEEE_XPLORE);
        logger.info("Created search String for IEEE 1: {}", ieeeSearchStringFirstHalf);

        searchtool.reset();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQuerySecondHalf, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String ieeeSearchStringSecondHalf = searchtool.generateSearchQuery(DatabaseType.IEEE_XPLORE);
        logger.info("Created search String for IEEE 2: {}", ieeeSearchStringSecondHalf);
    }


    private static void searchIEEE_THREE() {
        String keywordFilePathFirstHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathSecondHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> firstHalfKeywords = Util.readKeywords(keywordFilePathFirstHalf);
        List<String> secHalfKeywords = Util.readKeywords(keywordFilePathSecondHalf);

        logger.info("Found {} keywords in '{}' and {}", firstHalfKeywords.size() + secHalfKeywords.size(), keywordFilePathFirstHalf, keywordFilePathSecondHalf);

        BaseQuery keywordQueryFirstHalf = new BaseQuery();
        keywordQueryFirstHalf.setKeywordList(firstHalfKeywords);
        keywordQueryFirstHalf.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery keywordQuerySecondHalf = new BaseQuery();
        keywordQuerySecondHalf.setKeywordList(secHalfKeywords);
        keywordQuerySecondHalf.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("\"software\"");
        softwareQuery.addKeyword("\"system\"");
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

    private static void searchIEEE_TWO() {

        String keywordFilePathFirstHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathSecondHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> firstHalfKeywords = Util.readKeywords(keywordFilePathFirstHalf);
        List<String> secHalfKeywords = Util.readKeywords(keywordFilePathSecondHalf);

        logger.info("Found {} keywords in '{}' and {}", firstHalfKeywords.size() + secHalfKeywords.size(), keywordFilePathFirstHalf, keywordFilePathSecondHalf);

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
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQueryFirstHalf, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String ieeeSearchStringFirstHalf = searchtool.generateSearchQuery(DatabaseType.IEEE_XPLORE);
        logger.info("Created search String for IEEE 1: {}", ieeeSearchStringFirstHalf);

        searchtool.reset();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQuerySecondHalf, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String ieeeSearchStringSecondHalf = searchtool.generateSearchQuery(DatabaseType.IEEE_XPLORE);
        logger.info("Created search String for IEEE 2: {}", ieeeSearchStringSecondHalf);
    }

    private static void searchIEEE_ONE() {

        String keywordFilePathFirstHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathSecondHalf = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> firstHalfKeywords = Util.readKeywords(keywordFilePathFirstHalf);
        List<String> secHalfKeywords = Util.readKeywords(keywordFilePathSecondHalf);

        logger.info("Found {} keywords in '{}' and {}", firstHalfKeywords.size() + secHalfKeywords.size(), keywordFilePathFirstHalf, keywordFilePathSecondHalf);

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
