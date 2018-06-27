package ru.java.courses.sport.athletics;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.Coach;

public class Runner extends Athlete {

    private Coach coach;

    private double personalRecord;

    public Runner(String name) {
        super(name);
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
