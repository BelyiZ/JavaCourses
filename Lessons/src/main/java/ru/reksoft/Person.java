package ru.reksoft;

public class Person {

    protected String FullName;
    char Sex;
    int hight;
    int weigth;
    public String nationality;
    private long Salary;

    public Person(String Name){
        setFullName(Name);
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }
}
