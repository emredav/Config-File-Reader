package Configs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertiesFilePath="src/main/resources/configs/config.properties";

    public  ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertiesFilePath));
            properties= new Properties();
            try {
                properties.load(reader); // or input stream
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String returnPropertyValue(String propertyKey) {
        String propertyValue=properties.getProperty(propertyKey);
        if(propertyValue != null) { return propertyValue;}
        else {throw new RuntimeException(propertyKey + "not found in the config.properties file"); }
    }

    //get methods
    public String getUrl(){
        String propertyKey="url";
        return returnPropertyValue(propertyKey);
    }
    public String getUsername(){
        String propertyKey= "username";
        return  returnPropertyValue(propertyKey);
    }

    public String getPassword() {
        String propertyKey="password";
        return returnPropertyValue(propertyKey);
    }
    public String getOperatorCode() {
        String propertyKey="operatorCode";
        return returnPropertyValue(propertyKey);
    }
    public String getOperatorNameSurname() {
        String propertyKey="operatorNameSurname";
        return returnPropertyValue(propertyKey);
    }
    public String getOperatorPassword() {
        String propertyKey="operatorPassword";
        return returnPropertyValue(propertyKey);
    }
    public String getLanguageForLogin() {
        String propertyKey="language";
        return returnPropertyValue(propertyKey);
    }



}
