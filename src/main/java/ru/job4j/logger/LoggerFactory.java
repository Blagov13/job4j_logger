package ru.job4j.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoggerFactory implements Logger {
    private List<Appender> appenders = new ArrayList<>();

    private LogLevel minimumLogLevel;

    private static LoggerFactory instance = null;

    public static LoggerFactory getInstance() {
        if (instance == null) {
            instance = new LoggerFactory();
        }
        return instance;
    }

    public LoggerFactory() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("application.properties")) {
            properties.load(input);

            String appenderType = properties.getProperty("appender");
            if ("file".equals(appenderType)) {
                appenders.add(new FileLogger("/Users/aleksandrblagov/Desktop/projects/job4j_logger/src/main/resources/application.properties"));
            } else if ("console".equals(appenderType)) {
                appenders.add(new ConsoleLogger());
            }

            minimumLogLevel = LogLevel.valueOf(properties.getProperty("minLevel"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message, LogLevel level) {
        if (level.ordinal() >= minimumLogLevel.ordinal()) {
            for (Appender appender : appenders) {
                appender.append(message);
            }
        }
    }

    @Override
    public void error(String message) {
        log(message, LogLevel.ERROR);
    }

    @Override
    public void warning(String message) {
        log(message, LogLevel.WARNING);
    }

    @Override
    public void trace(String message) {
        log(message, LogLevel.TRACE);
    }

    @Override
    public void debug(String message) {
        log(message, LogLevel.DEBUG);
    }

    @Override
    public void info(String message) {
        log(message, LogLevel.INFO);
    }
}
