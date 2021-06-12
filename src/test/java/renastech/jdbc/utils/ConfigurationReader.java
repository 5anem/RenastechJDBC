package renastech.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;
    static {
        try (FileInputStream fileInputStream = new FileInputStream("configuration.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to find configuration.properties file!");
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
