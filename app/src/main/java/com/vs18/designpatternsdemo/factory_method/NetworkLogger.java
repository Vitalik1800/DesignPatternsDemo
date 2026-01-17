package com.vs18.designpatternsdemo.factory_method;

public class NetworkLogger implements Logger {

    @Override
    public String log(String message) {
        return "[Мережа] Надіслано: " + message;
    }
}
