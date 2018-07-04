package ru.java.courses.sport.athletics;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.Coach;

import java.util.Objects;

public class Runner extends Athlete {
    private Coach coach;
    private double personalRecord = 0.0;

    public Runner(String name, int age) {
        super(name, age);
    }

    public Runner(String name, int age, Coach coach, double personalRecord) {
        super(name, age);
        this.coach = coach;
        this.personalRecord = personalRecord;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public double getPersonalRecord() {
        return personalRecord;
    }

    public void setPersonalRecord(double personalRecord) {
        this.personalRecord = personalRecord;
    }

}
