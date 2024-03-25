package ru.job4j.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new LoggerFactory();
        logger.log("message");
    }
}
