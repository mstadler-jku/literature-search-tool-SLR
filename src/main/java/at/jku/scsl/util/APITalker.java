package at.jku.scsl.util;

import jdk.jshell.spi.ExecutionControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static at.jku.scsl.util.Util.FILE_PATH_SEP;

public class APITalker {

    private static final Logger logger = LogManager.getLogger(APITalker.class);

    private static final String SPRINGER_LINK_URL = "http://api.springernature.com/meta/v2/json";
    private static final String APP_CONFIG_PATH = "src" + FILE_PATH_SEP + "main" + FILE_PATH_SEP + "resources" + FILE_PATH_SEP + "configs" + FILE_PATH_SEP + "app.config";
    private final String springerLinkApiKey;


    public APITalker() throws ExecutionControl.NotImplementedException {
        this.springerLinkApiKey = getSLAPIKey();
        throw new ExecutionControl.NotImplementedException("This class is at the moment not completely implemented!");
    }


    private static String getSLAPIKey() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(APP_CONFIG_PATH)) {
            prop.load(fis);
        } catch (IOException ex) {
            logger.error("Could not load app config file!");
            return null;
        }
        return prop.getProperty("app.slapikey");
    }

    public static String getParamsString(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    /**
     * Makes an HTTP Get request to the SpringerLink API.
     *
     * @param searchQuery    The query to be searched.
     * @param maxPageResults The amount of results displayed at max for one request. API allows up to 100.
     */
    public void searchSpringerLink(String searchQuery, int maxPageResults) {
        if (maxPageResults > 100 || maxPageResults < 0) {
            maxPageResults = 10;
            logger.error("Got invalid pageResults parameter: {} -> changed it to 10!", maxPageResults);
        }
        try {
            // set URL
            URL url = new URL(SPRINGER_LINK_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);

            // set timeouts
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            // set params
            Map<String, String> parameters = new HashMap<>();
            parameters.put("q", searchQuery);
            parameters.put("api_key", this.springerLinkApiKey);
            parameters.put("p", String.valueOf(maxPageResults));
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(getParamsString(parameters));
            out.flush();
            out.close();

            handleSpringerLinkResponse(con);

        } catch (IOException e) {
            logger.error("Could not send HTTP request to SpringerLink, aborting.");
        }
    }

    private void handleSpringerLinkResponse(HttpURLConnection connection) {

        try {
            int statusCode = connection.getResponseCode();
            if (statusCode == 200) {
                // handle response...
                // TODO: finalize this if needed
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content);
                in.close();
            } else {
                logger.error("Got error code of SpringerLink API call: {}", statusCode);
            }
        } catch (IOException e) {
            logger.error("Could not connect to SpringerLink API!");
        }
        connection.disconnect();
    }
}
