package ru.java.courses.sport;

import java.util.Objects;

abstract public class Person {

    public  int name;

    public int age;

    public int salary;

    public Person(int name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return name == person.name &&
                age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

