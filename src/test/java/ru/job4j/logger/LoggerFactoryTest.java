package ru.job4j.logger;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class LoggerFactoryTest {
    @Test
    void getInstance_returns_the_same_instance() {
        assertSame(LoggerFactory.getInstance(), LoggerFactory.getInstance());
    }

    @Test
    void log_message_with_ConsoleLogger() throws Exception {
        File appProperties = new File("application.properties");
        try (FileWriter writer = new FileWriter(appProperties)) {
            writer.write("appender=console\nminLevel=INFO");
        }

        Logger logger = LoggerFactory.getInstance();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        logger.info("message");

        String outContentString = outContent.toString("UTF-8");
        assertTrue(outContentString.contains("message"));
    }

    @Test
    void log_message_with_FileLogger() throws Exception {
        File appProperties = new File("application.properties");
        try (FileWriter writer = new FileWriter(appProperties)) {
            writer.write("appender=file\nminLevel=INFO");
        }

        Logger logger = LoggerFactory.getInstance();
        logger.info("message");

        assertTrue(Files.readString(Paths.get("log.txt")).contains("message"));
    }
}