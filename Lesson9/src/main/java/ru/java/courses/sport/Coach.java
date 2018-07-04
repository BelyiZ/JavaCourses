package ru.java.courses.sport;

import java.util.Objects;

public class Coach extends Person {
    private int experience = 0;

    public Coach(String name, int age) {
        super(name, age);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
