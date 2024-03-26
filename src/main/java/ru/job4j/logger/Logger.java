package ru.job4j.logger;

public interface Logger {
    void log(String message, LogLevel level);
    void error(String message);
    void warning(String message);
    void trace(String message);
    void debug(String message);
    void info(String message);
}
