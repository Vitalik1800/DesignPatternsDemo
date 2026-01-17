package com.vs18.designpatternsdemo.observer;

import java.util.*;

public class NewsAgency {

    private final List<Observer> observers = new ArrayList<>();
    String news;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setNews(String news) {
        this.news = news;
        for (Observer o : observers) {
            o.update(news);
        }
    }
}
