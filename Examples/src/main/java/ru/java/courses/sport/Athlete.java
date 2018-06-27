package ru.java.courses.sport;

public class Athlete {

    private String name;

    private int pesonalNumber;

    private boolean active;

    public Athlete(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("У спортсмена всегда должно быть имя!");
        }
        this.name = name;

        this.active = true;
    }

    public String getName() {
        return name;
    }

    public final void setName(String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("У спортсмена всегда должно быть имя!");
        }

        this.name = newName;
    }

    public int getPesonalNumber() {
        return pesonalNumber;
    }

    public void setPesonalNumber(int pesonalNumber) {
        this.pesonalNumber = pesonalNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
