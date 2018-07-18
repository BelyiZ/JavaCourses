package ru.java.courses.sport.games;

import ru.java.courses.sport.Athlete;
import ru.java.courses.sport.SportTitle;

public abstract class Player extends Athlete {

    private int points;
    private int personalNumber;
    private boolean active = true;

    public Player(String name, int age) {
        super(name, age);
    }

    public Player(String name, int age, SportTitle title, double salary) {
        super(name, age, title, salary);
    }

    protected abstract void makeScore();

    public void score() {
        if (active) {
            makeScore();
        } else {
            throw new IllegalStateException("Inactive player cann't score");
        }
    }
    protected void addPoints(int points){
        this.points=this.points+points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
