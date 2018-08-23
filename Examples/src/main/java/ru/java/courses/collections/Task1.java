package ru.java.courses.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task1 {

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        User ivan = new User("Ivan", 22);
        User david = new User("David", 34);
        User masha = new User("Masha", 18);
        User igor = new User("Igor", 25);

        // Для каждого пользователя нужно вести счетчик посещенных страниц.
        // Какую структуры будем использовать?

    }
}
