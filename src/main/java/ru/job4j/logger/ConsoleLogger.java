package ru.job4j.logger;

public class ConsoleLogger implements Appender {
    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
