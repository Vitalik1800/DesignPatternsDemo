package com.vs18.designpatternsdemo.factory_method;

public class ConsoleLogger implements Logger {

    @Override
    public String log(String message) {
        return "[Консоль] Виведено: " + message;
    }
}
