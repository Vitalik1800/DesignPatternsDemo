package com.vs18.designpatternsdemo.factory_method;

public class FileLogger implements Logger {

    @Override
    public String log(String message) {
        return "[Файл] Записано: " + message;
    }
}
