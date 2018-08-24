package ru.java.courses.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task2 {

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Set<User> set = new HashSet<>();
        set.add(new User("Ivan", 22));
        set.add(new User("Masha", 18));
        set.add(new User("David", 34));
        set.add(new User("Masha", 18));
        set.add(new User("Ivan", 22));
        set.add(new User("Igor", 25));

        // Убрать повторения пользователей

    }
}
