package at.jku.scsl.searchtool;

import at.jku.scsl.searchtool.types.BooleanOperatorType;
import at.jku.scsl.searchtool.types.DatabaseType;
import at.jku.scsl.searchtool.types.MetaDataType;
import at.jku.scsl.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static at.jku.scsl.util.Util.FILE_PATH_SEP;

public class ScopusSearch {

    private static final Logger logger = LogManager.getLogger(ScopusSearch.class);


    private ScopusSearch() {
        throw new IllegalStateException("Utility class");
    }

    public static void searchScopus() {

        logger.info("########## Scopus ##########");

        // #1
        searchScopus_ONE();
        // #2
        searchScopus_TWO();
        // #3
        searchScopus_THREE();
        // #4
        searchScopus_FOUR();
    }


    private static void searchScopus_FOUR() {

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

        String searchString = searchtool.generateSearchQuery(DatabaseType.SCOPUS);
        logger.info("Created search String for Scopus: {}", searchString);
    }


    private static void searchScopus_THREE() {

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

        String searchString = searchtool.generateSearchQuery(DatabaseType.SCOPUS);
        logger.info("Created search String for Scopus: {}", searchString);
    }

    private static void searchScopus_TWO() {


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

        String searchString = searchtool.generateSearchQuery(DatabaseType.SCOPUS);
        logger.info("Created search String for Scopus: {}", searchString);
    }

    private static void searchScopus_ONE() {


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

        String searchString = searchtool.generateSearchQuery(DatabaseType.SCOPUS);
        logger.info("Created search String for Scopus: {}", searchString);
    }

}
