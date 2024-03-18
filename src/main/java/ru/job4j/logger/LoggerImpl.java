package ru.job4j.logger;

import java.io.*;
import java.util.Properties;

public class LoggerImpl implements Logger {

    @Override
    public void log(String message) {
        if ("FILE".equals(properties.getProperty("output.target"))) {
            try (FileOutputStream fileOutputStream = new FileOutputStream("log.txt",
                    Boolean.parseBoolean(properties.getProperty("file.append")))) {
                fileOutputStream.write(message.getBytes());
                fileOutputStream.write("\n".getBytes());
            } catch (IOException e) {
                System.out.println("Error");
            }
        } else if ("CONSOLE".equals(properties.getProperty("output.target"))) {
            System.out.println(message);
        } else {
            System.out.println("No");
        }
    }

    private static void loadProperties() {
        try (InputStream input = LoggerImpl.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Not found");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static Properties properties = new Properties();

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        loadProperties();
        logger.log("message");
    }
}
