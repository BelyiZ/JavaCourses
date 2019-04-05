package ru.java.courses.sport.team.football;

import java.util.List;
import java.util.Objects;

public class FootballPlayer {
    private String name;
    private int goals;
    private PlayerRole role;
    private boolean active;
    private int age;

    public String toString() {     // возвращает данные объекта в строке
        return "name is " + this.name + "number of goals is" + this.goals + "age is" + this.age + "role is" + this.role + this.active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer that = (FootballPlayer) o;
        return goals == that.goals &&
                active == that.active &&
                age == that.age &&
                Objects.equals(name, that.name) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goals, role, active, age);
    }

    public FootballPlayer(String name, PlayerRole role) {

        setName(name);
        setRole(role);
        setActive(true);
    }

    public FootballPlayer(String name) {

        setName(name);
        setActive(true);
    }

    public FootballPlayer() {}


    public int getAge() {
        return age;
    }

    public void setAge(int age) {this.age = (age < 18) ? 18 : age;}

    private boolean isActive(){return active;}

    public void setActive(boolean active) {this.active = active;}

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

    public void setGoals(int goals) {this.goals = goals;}

    public PlayerRole getRole() {return role;}

    public void setRole(PlayerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("The role cannot be empty");
        }
        this.role = role;
    }
}
