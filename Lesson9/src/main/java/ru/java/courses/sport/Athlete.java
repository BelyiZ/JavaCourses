package ru.java.courses.sport;

import java.util.Objects;

public class Athlete extends Person {
    private SportTitle title = SportTitle.NO_TITLE;
    private double salary = 0.0;

    public Athlete(String name, int age) {
        super(name, age);
    }

    public Athlete(String name, int age, SportTitle title, double salary) {
        super(name, age);
        this.title = title;
        this.salary = salary;
    }

    public SportTitle getTitle() {
        return title;
    }

    public void setTitle(SportTitle title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
