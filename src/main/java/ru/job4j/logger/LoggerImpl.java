package ru.job4j.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerImpl implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            writer.println("Start");
            logger.log("message write in the log");
            writer.println("End");
        } catch (IOException e) {
            System.out.println("Error");
        }
        logger.log("message write in the console.");
    }
}
