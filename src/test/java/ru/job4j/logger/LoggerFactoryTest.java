package ru.job4j.logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.*;

class LoggerFactoryTest {
    @Test
    void consoleLoggerTest(@TempDir Path tempDir) throws IOException {
        File properties = tempDir.resolve("application.properties").toFile();
        try (FileWriter writer = new FileWriter(properties)) {
            writer.write("appender=console\nminLevel=INFO");
        }

        Logger logger = LoggerFactory.getInstance();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        logger.info("message");

        String outString = out.toString(StandardCharsets.UTF_8);
        assertThat(outString).contains("message");
    }

    @Test
    void fileLoggerTest(@TempDir Path tempDir) throws IOException {
        File properties = tempDir.resolve("application.properties").toFile();
        try (FileWriter writer = new FileWriter(properties)) {
            writer.write("appender=file\nminLevel=INFO");
        }

        Logger logger = LoggerFactory.getInstance();
        logger.info("message");

        File file = Paths.get("log.txt").toFile();
        assertThat(Files.readString(file.toPath())).contains("message");
    }
}