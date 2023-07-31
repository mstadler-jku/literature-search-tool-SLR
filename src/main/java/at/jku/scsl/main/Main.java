package at.jku.scsl.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static at.jku.scsl.searchtool.ACMSearch.searchACM;
import static at.jku.scsl.searchtool.IEEESearch.searchIEEE;
import static at.jku.scsl.searchtool.ScopusSearch.searchScopus;
import static at.jku.scsl.searchtool.SpringerLinkSearch.searchSpringerLink;
import static at.jku.scsl.searchtool.WoSSearch.searchWoS;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Welcome to the literature search tool!");

        searchIEEE();
        searchACM();
        searchScopus();
        searchWoS();
        searchSpringerLink();
    }


}