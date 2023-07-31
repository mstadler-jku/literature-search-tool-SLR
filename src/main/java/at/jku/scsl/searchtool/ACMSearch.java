package at.jku.scsl.searchtool;

import at.jku.scsl.searchtool.types.BooleanOperatorType;
import at.jku.scsl.searchtool.types.DatabaseType;
import at.jku.scsl.searchtool.types.MetaDataType;
import at.jku.scsl.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static at.jku.scsl.util.Util.FILE_PATH_SEP;

public class ACMSearch {

    private static final Logger logger = LogManager.getLogger(ACMSearch.class);


    private ACMSearch() {
        throw new IllegalStateException("Utility class");
    }

    public static void searchACM() {
        // #
//        searchACM_ONE();
        // #2
//        searchACM_TWO();
        // #3
//        searchACM_THREE();
        // #4
//        searchACM_FOUR();
    }


    private static void searchACM_FOUR() {

        logger.info("---------- Fourth Query ----------");
        String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
        List<String> keywordList = Util.readKeywords(keywordFilePath);

        BaseQuery keywordQuery = new BaseQuery();
        keywordQuery.setKeywordList(keywordList);
        keywordQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("software");
        softwareQuery.addKeyword("system");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("security");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQuery, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String searchString = searchtool.generateSearchQuery(DatabaseType.ACM_DIGITIAL_LIBRARY);
        logger.info("Created search String for ACM: {}", searchString);
    }


    private static void searchACM_THREE() {

        logger.info("---------- Third Query ----------");
        String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
        List<String> keywordList = Util.readKeywords(keywordFilePath);


        BaseQuery keywordQuery = new BaseQuery();
        keywordQuery.setKeywordList(keywordList);
        keywordQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery softwareQuery = new BaseQuery();
        softwareQuery.addKeyword("software");
        softwareQuery.addKeyword("system");
        softwareQuery.setBooleanOperatorType(BooleanOperatorType.OR);

        BaseQuery securityQuery = new BaseQuery();
        securityQuery.addKeyword("security");
        securityQuery.setBooleanOperatorType(BooleanOperatorType.OR);


        SearchTool searchtool = new SearchTool();
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT);
        searchtool.addBaseQueries(keywordQuery, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String searchString = searchtool.generateSearchQuery(DatabaseType.ACM_DIGITIAL_LIBRARY);
        logger.info("Created search String for ACM: {}", searchString);
    }

    private static void searchACM_TWO() {


        logger.info("---------- Second Query ----------");
        String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
        List<String> keywordList = Util.readKeywords(keywordFilePath);


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
        searchtool.addMetaDataFields(MetaDataType.TITLE, MetaDataType.ABSTRACT, MetaDataType.KEYWORDS);
        searchtool.addBaseQueries(keywordQuery, softwareQuery, securityQuery);
        searchtool.setBooleanOperatorType(BooleanOperatorType.AND);

        String searchString = searchtool.generateSearchQuery(DatabaseType.ACM_DIGITIAL_LIBRARY);
        logger.info("Created search String for ACM: {}", searchString);
    }

    private static void searchACM_ONE() {

        logger.info("---------- First Query ----------");
        String keywordFilePath = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "keywords" + FILE_PATH_SEP + "keywords_v2.txt";
        List<String> keywordList = Util.readKeywords(keywordFilePath);


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

        String searchString = searchtool.generateSearchQuery(DatabaseType.ACM_DIGITIAL_LIBRARY);
        logger.info("Created search String for ACM: {}", searchString);
    }

}
