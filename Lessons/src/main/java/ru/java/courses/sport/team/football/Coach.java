package ru.java.courses.sport.team.football;

public class Coach {
    private String name;
    private int experience;

    public Coach(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public Coach(int experience) {
        this.experience = experience;
    }
}
