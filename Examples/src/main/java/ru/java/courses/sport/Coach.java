package ru.java.courses.sport;

public class Coach {

    private String name;

    /**
     * Стаж в годах
     */
    private int experience;

    public Coach(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("У спортсмена всегда должно быть имя!");
        }
        this.name = name;
    }

    public Coach(String name, int experience) {
        this(name);
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
