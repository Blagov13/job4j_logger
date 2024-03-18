package ru.job4j.logger;

import java.util.Properties;

public class LoggerFactory {
    public static Logger getLogger(Properties properties) {
        String outputTarget = properties.getProperty("output.target", "CONSOLE");
        if ("FILE".equals(outputTarget)) {
            boolean append = Boolean.parseBoolean(properties.getProperty("file.append", "true"));
            return new FileLogger(append);
        } else {
            return new ConsoleLogger();
        }
    }
}
