package ru.job4j.logger;

import java.io.IOException;

public interface Logger {
    void log(String message) throws IOException;
}
