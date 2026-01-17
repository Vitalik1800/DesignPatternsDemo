package com.vs18.designpatternsdemo.observer;

public class NewsChannel implements Observer {

    private final String name;
    private String latestNews = "";

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        this.latestNews = news;
        System.out.println(name + " отримав: " + news);
    }

    public String getLatestNews() {
        return name + ": " + latestNews;
    }
}
