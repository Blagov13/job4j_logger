package ru.job4j.logger;

import java.io.IOException;
import java.util.Properties;

public class LoggerFactory {
    private static final String LOGGER_STRATEGY_KEY = "logger.strategy";

    public Logger getLogger(Properties properties) throws IOException {
        String strategy = properties.getProperty(LOGGER_STRATEGY_KEY);
        switch (strategy) {
            case "console":
                return new ConsoleLogger();
            case "file":
                String filePath = properties.getProperty("logger.filePath");
                if (filePath == null) {
                    throw new IllegalArgumentException();
                }
                return new FileLogger(filePath);
            default:
                throw new IllegalArgumentException();
        }
    }
}
