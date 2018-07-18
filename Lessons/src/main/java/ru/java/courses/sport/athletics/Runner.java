package ru.java.courses.sport.athletics;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.Coach;
import ru.java.courses.sport.SportTitle;

public class Runner extends Athlete implements Trainable {

    Coach perCoach;

    public Runner(int name, int age, int salary, int pesonalNumber, boolean active, SportTitle title) {
        super(name, age, salary, pesonalNumber, active, title);
    }

    public void train() {

    }

    @Override
    public Coach getCoach() {
        return perCoach;
    }

    @Override
    public void setCoach(Coach coach) {
        perCoach=new Coach(coach.getName(),coach.getAge(),coach.salary, coach.getExpirience());
    }
}
