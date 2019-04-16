package ru.java.courses.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        List<User> collection = new ArrayList<>();
        collection.add(new User("Ivan", 22));
        collection.add(new User("Masha", 18));
        collection.add(new User("David", 34));
        collection.add(new User("Masha", 18));
        collection.add(new User("Ivan", 22));
        collection.add(new User("Igor", 25));

        // Убрать повторения пользователей

    }
}
