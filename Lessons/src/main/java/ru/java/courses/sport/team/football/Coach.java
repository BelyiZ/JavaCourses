package ru.java.courses.sport.team.football;

public class Coach {
    private int experience;
    private String name;

    public Coach(String name, int experience){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Coach should have name");
        }
        this.name = name;
        this.experience = experience;
    }
    public Coach(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Coach should have name");
        }
        this.name = name;
    }

    public String getName(){return name;}

    public void setName(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Coach should have name");
        }this.name = name;}

    public int getExperience(){return experience;}

    public void setExperience(int experience){this.experience = experience;}
}
