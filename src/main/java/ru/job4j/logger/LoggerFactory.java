package ru.job4j.logger;

import java.util.Properties;

public class LoggerFactory {
    public static Logger getLogger(Properties properties) {
        String logTarget = properties.getProperty("log.target");

        if ("CONSOLE".equals(logTarget)) {
            return new ConsoleLogger();
        } else if ("FILE".equals(logTarget)) {
            String fileName = properties.getProperty("log.file");
            return new FileLogger(fileName);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
