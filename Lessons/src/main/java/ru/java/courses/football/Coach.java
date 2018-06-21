package ru.java.courses.football;

public class Coach extends Person {

    private int experience;

    public Coach(String name){
        super(name);
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}
