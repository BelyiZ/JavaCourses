package ru.java.courses.football;

public class Person {

    protected String name;
    char sex;
    int hight;
    int weigth;
    String nationality;
    private long salary;

    public Person(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String fullname) {
        if (fullname==""||fullname.isEmpty())
        {
            throw new IllegalArgumentException("Дайте нормальное имя игроку!");
        }
        else
        this.name = fullname;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
