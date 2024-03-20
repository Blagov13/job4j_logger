package ru.job4j.logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LoggerImpl extends AbstractLogger {
    public LoggerImpl(Logger logger) {
        super(logger);
    }

    public static void main(String[] args) throws IOException {
        Properties properties = loadProperties();
        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.getLogger(properties);
        LoggerImpl loggerImpl = new LoggerImpl(logger);
        loggerImpl.log("message");
    }
    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("application.properties"))) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return properties;
    }
}
