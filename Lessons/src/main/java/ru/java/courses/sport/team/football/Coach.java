package ru.java.courses.sport.team.football;

public class Coach extends Person{
    private int experience;

    public Coach(String name, int experience) {
        super(name);
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
