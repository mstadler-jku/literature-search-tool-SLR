package at.jku.scsl.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static at.jku.scsl.searchtool.SpringerLinkSearch.searchSpringerLink;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Welcome to the literature search tool!");

//        searchIEEE();
//        searchACM();
//        searchScopus();
//        searchWoS();
        searchSpringerLink();
    }


}