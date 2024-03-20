package ru.job4j.logger;

abstract class AbstractLogger implements Logger {
    protected Logger logger;

    protected AbstractLogger(Logger logger) {
        this.logger = logger;
    }
    @Override
    public void log(String message) {
        logger.log(message);
    }
}
