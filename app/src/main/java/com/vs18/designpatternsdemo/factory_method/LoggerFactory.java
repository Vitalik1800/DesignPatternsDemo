package com.vs18.designpatternsdemo.factory_method;

public class LoggerFactory {

    public static Logger createLogger(String type) {
        switch (type) {
            case "file":
                return new FileLogger();
            case "network":
                return new NetworkLogger();
            default:
                return new ConsoleLogger();
        }
    }

}
