package ru.job4j.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoggerFactory implements Logger {
    private List<Appender> appenders = new ArrayList<>();

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        for (Appender appender : appenders) {
            appender.append(message);
        }
    }
}
