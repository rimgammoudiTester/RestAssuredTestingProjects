package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManger {
    Properties properties;

    //method allow to read EnvironmentFile
    public void readPropertFile()
    {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\DummyApiSmallProject\\src\\main\\java\\Utilis\\enviromentFile.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }

    }

    public String getPropertyFile(String propertValueToRead)
    {
        readPropertFile();
        return properties.getProperty(propertValueToRead);
    }

}
