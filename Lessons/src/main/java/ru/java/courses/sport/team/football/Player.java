package ru.java.courses.sport.team.football;

public class Player {
    private String name;
    private int goalsCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
