package com.vs18.designpatternsdemo.mvc;

public class StudentView {

    private String displayText = "";

    public void printStudentDetails(String name, String grade) {
        displayText = "Студент: " + name + "\nОцінка: " + grade;
    }

    public String getDisplayText() {
        return displayText;
    }
}
