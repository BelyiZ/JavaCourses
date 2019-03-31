package ru.java.courses.sport.team.football;

import java.util.List;

public class FootballPlayer {
    private String name;
    private int goals;
    private PlayerRole role;
    private boolean active;
    private int age;

//    public FootballPlayer(String name, int goals, boolean active, int age) {
//        this.name = name;
//        this.goals = goals;
//        this.active = active;
//        this.age = (age < 18) ? 18 : age;
//
//    }

    public FootballPlayer(String name, PlayerRole role) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Sportsman should have name");
        }else if (role == null){
            throw new IllegalArgumentException("Sportsman should have role");
        } else
            this.name = name;
        this.role = role;
        this.active = true;
    }

    public FootballPlayer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Sportsman should have name");
        }else
            this.name = name;
        this.active = true;
    }

    public FootballPlayer() {

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (age < 18) ? 18 : age;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active) {

        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The player's name cannot be empty");
        }
        this.name = name;
    }

    public void score() {
        if (isActive()) {
            goals++;
        } else {
            throw new IllegalArgumentException("Only active player can score");
        }
    }

    int getScore(){
        return goals;
    }


    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {

        this.goals = goals;
    }


    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("The role cannot be empty");
        }
        this.role = role;
    }
}
