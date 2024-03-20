package ru.job4j.logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger implements Logger {
    private final BufferedWriter writer;

    public FileLogger(String filePath) throws IOException {
            writer = Files.newBufferedWriter(Paths.get(filePath));
    }

    @Override
    public void log(String message) {
        try {
            writer.write(message + "\n");
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
