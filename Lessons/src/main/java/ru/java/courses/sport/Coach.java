package ru.java.courses.sport;

public class Coach extends Person{

    public int expirience;

    public Coach(int name, int age, int salary, int expirience) {
        super(name, age, salary);
        this.expirience = expirience;
    }

    public int getExpirience() {
        return expirience;
    }

    public void setExpirience(int expirience) {
        this.expirience = expirience;
    }
}
