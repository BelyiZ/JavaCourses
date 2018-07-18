package ru.java.courses.sport;

import java.util.Objects;

public class Athlete extends Person{

    private int pesonalNumber;

    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Athlete athlete = (Athlete) o;
        return pesonalNumber == athlete.pesonalNumber &&
                active == athlete.active &&
                title == athlete.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pesonalNumber, active, title);
    }

    private SportTitle title ;


    public Athlete(int name, int age, int salary, int pesonalNumber, boolean active, SportTitle title) {
        super(name, age, salary);
        this.pesonalNumber = pesonalNumber;
        this.active = active;
        this.title = title;
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

    public SportTitle getTitle() {
        return title;
    }

    public void setTitle(SportTitle title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "pesonalNumber=" + pesonalNumber +
                ", active=" + active +
                ", title=" + title +
                "} " + super.toString();
    }
}
