package com.vs18.designpatternsdemo.mvc;

public class StudentController {

    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getGrade());
    }

}
