package ru.job4j.logger;

import java.io.*;
import java.util.Properties;

public class LoggerImpl {
    public static void main(String[] args) {
        Properties properties = loadProperties();
        Logger logger = LoggerFactory.getLogger(properties);
        logger.log("message");
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = LoggerImpl.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("No");
            } else {
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
