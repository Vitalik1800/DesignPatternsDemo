package com.vs18.designpatternsdemo.singleton;

public class SettingsManager {

    private static SettingsManager instance;
    private String theme = "Light";
    String language = "Українська";

    private SettingsManager() {}

    public static SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager();
        }
        return instance;
    }

    public String getTheme() {
        return "Тема: " + theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return "Мова: " + language;
    }
}
