package ru.job4j.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getInstance();
        logger.info("info");
        logger.error("error");
    }
}
