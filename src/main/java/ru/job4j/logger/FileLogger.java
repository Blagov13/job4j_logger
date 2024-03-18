package ru.job4j.logger;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileLogger implements Logger {
    private final boolean append;

    public FileLogger(boolean append) {
        this.append = append;
    }

    @Override
    public void log(String message) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("log.txt", append)) {
            fileOutputStream.write(message.getBytes());
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
