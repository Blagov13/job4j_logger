package ru.job4j.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream in = new FileInputStream("application.properties")) {
            properties.load(in);
            Logger logger = LoggerFactory.getLogger(properties);
            logger.log("message");
        } catch (IOException e) {
            System.out.println("Failed");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
