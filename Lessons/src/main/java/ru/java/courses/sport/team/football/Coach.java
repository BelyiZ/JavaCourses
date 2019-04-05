package ru.java.courses.sport.team.football;

import java.util.Objects;

public class Coach {
    private int experience;
    private String name;

    public Coach(String name, int experience){

        setExperience(experience);
    }
    public Coach(String name){
//
        setName(name);
    }

    public String getName(){return name;}

    public void setName(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Coach should have name");
        }
        this.name = name;}

    public int getExperience(){return experience;}

    public void setExperience(int experience){this.experience = experience;}


    public String toString() {
        return "name is " + this.name + " experience is " + this.experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return experience == coach.experience &&
                Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience, name);
    }
}

