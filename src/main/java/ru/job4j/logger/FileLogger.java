package ru.job4j.logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger implements Logger {
    private final String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(this.fileName, true)) {
            fileOutputStream.write(message.getBytes());
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
