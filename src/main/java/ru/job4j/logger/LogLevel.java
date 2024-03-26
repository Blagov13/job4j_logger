package ru.job4j.logger;

public enum LogLevel {
    INFO("INFO"),
    ERROR("ERROR"),
    WARNING("WARNING"),
    TRACE("TRACE"),
    DEBUG("DEBUG");

    private final String value;

    LogLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
