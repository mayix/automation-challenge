package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class TestProperties {

    public String getEndpoints(String environment, String endpoint){
        JSONParser parser = new JSONParser();
        String testEndpoint = new String();
        try {
            Object obj = parser.parse(new FileReader("D://GitHub//automation-challenge//src//test//resources//config//EndPoints.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject endpoints = (JSONObject) jsonObject.get(environment);
            testEndpoint = (String) endpoints.get(endpoint);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return testEndpoint;
    }

    public String getWebDriver(String webDriver){
        JSONParser parser = new JSONParser();
        String webDirverPath = new String();
        try {
            Object obj = parser.parse(new FileReader("D://GitHub//automation-challenge//src//test//resources//config//AppConfig.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject paths = (JSONObject) jsonObject.get("WEBDRIVERS");
            webDirverPath = (String) paths.get(webDriver);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return webDirverPath;
    }

    public String testData(String data){
        JSONParser parser = new JSONParser();
        String testingData = new String();
        try {
            Object obj = parser.parse(new FileReader("D://GitHub//automation-challenge//src//test//resources//config//AppConfig.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONObject paths = (JSONObject) jsonObject.get("TESTDATA");
            testingData = (String) paths.get(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return testingData;
    }
}
