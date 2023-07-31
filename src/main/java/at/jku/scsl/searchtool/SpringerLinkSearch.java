package at.jku.scsl.searchtool;

import at.jku.scsl.searchtool.types.BooleanOperatorType;
import at.jku.scsl.searchtool.types.DatabaseType;
import at.jku.scsl.searchtool.types.MetaDataType;
import at.jku.scsl.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static at.jku.scsl.util.Util.FILE_PATH_SEP;

public class SpringerLinkSearch {

    private static final Logger logger = LogManager.getLogger(SpringerLinkSearch.class);


    private SpringerLinkSearch() {
        throw new IllegalStateException("Utility class");
    }

    public static void searchSpringerLink() {
        // #1
        searchSL_ONE();
        // #2
        searchSL_TWO();
        // #3
        searchSL_THREE();
        // #4
        searchSL_FOUR();
    }


    private static void searchSL_FOUR() {

        logger.info("---------- Fourth Query ----------");

        String keywordFilePathOne = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathTwo = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> keywordListOne = Util.readKeywords(keywordFilePathOne);
        List<String> keywordListTwo = Util.readKeywords(keywordFilePathTwo);

        BaseQuery keywordQueryOne = new BaseQuery();
        keywordQueryOne.setKeywordList(keywordListOne);
        keywordQueryOne.setBooleanOperatorType(BooleanOperatorType.OR);
        BaseQuery keywordQueryTwo = new BaseQuery();
        keywordQueryTwo.setKeywordList(keywordListTwo);
        keywordQueryTwo.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("software");
        softwareQuery.addKeyword("system");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("security");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQueryOne, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String firstQueryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query First half: {}", firstQueryString);


        searchtool.reset();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQueryTwo, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String secQueryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query Second half: {}", secQueryString);
    }


    private static void searchSL_THREE() {

        logger.info("---------- Third Query ----------");


        String keywordFilePathOne = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathTwo = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> keywordListOne = Util.readKeywords(keywordFilePathOne);
        List<String> keywordListTwo = Util.readKeywords(keywordFilePathTwo);

        BaseQuery keywordQueryOne = new BaseQuery();
        keywordQueryOne.setKeywordList(keywordListOne);
        keywordQueryOne.setBooleanOperatorType(BooleanOperatorType.OR);
        BaseQuery keywordQueryTwo = new BaseQuery();
        keywordQueryTwo.setKeywordList(keywordListTwo);
        keywordQueryTwo.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("software");
        softwareQuery.addKeyword("system");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("security");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT);
        searchtool.addBaseQueries(keywordQueryOne, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String firstQueryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query First half: {}", firstQueryString);


        searchtool.reset();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT);
        searchtool.addBaseQueries(keywordQueryTwo, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String secQueryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query Second half: {}", secQueryString);


    }

    private static void searchSL_TWO() {

        logger.info("---------- Second Query ----------");

        String keywordFilePathOne = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_01.txt";
        String keywordFilePathTwo = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2_02.txt";
        List<String> keywordListOne = Util.readKeywords(keywordFilePathOne);
        List<String> keywordListTwo = Util.readKeywords(keywordFilePathTwo);

        BaseQuery keywordQueryOne = new BaseQuery();
        keywordQueryOne.setKeywordList(keywordListOne);
        keywordQueryOne.setBooleanOperatorType(BooleanOperatorType.OR);
        BaseQuery keywordQueryTwo = new BaseQuery();
        keywordQueryTwo.setKeywordList(keywordListTwo);
        keywordQueryTwo.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("software");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("security");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQueryOne, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String firstQueryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query First half: {}", firstQueryString);


        searchtool.reset();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQueryTwo, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String secQueryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query Second half: {}", secQueryString);
    }

    private static void searchSL_ONE() {

        logger.info("---------- First Query ----------");

        String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
        List<String> keywordList = Util.readKeywords(keywordFilePath);

        logger.info("Found {} keywords in '{}'", keywordList.size(), keywordFilePath);

        BaseQuery keywordQuery = new BaseQuery();
        keywordQuery.setKeywordList(keywordList);
        keywordQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("software");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("security");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT);
        searchtool.addBaseQueries(keywordQuery, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String queryString = searchtool.generateSearchQuery(DatabaseType.SPRINGER_LINK);
        logger.info("Created SpringerLink Query: {}", queryString);

//        APITalker apiTalker = new APITalker();
//        apiTalker.searchSpringerLink(queryString, 10);
    }

}
