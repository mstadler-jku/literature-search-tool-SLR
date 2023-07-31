package at.jku.scsl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

    public static final String FILE_PATH_SEP = System.getProperty("file.separator");
    private static final Logger logger = LogManager.getLogger(Util.class);

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> readKeywords(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> keywordList = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                keywordList.add(line);
                line = br.readLine();
            }
            return keywordList;
        } catch (IOException e) {
            logger.error("Could not parse keyowords for filepath: {}", filePath);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


}
