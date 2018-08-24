package ru.java.courses.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task3 {

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Map<User, Integer> map = new HashMap<>();
        map.put(new User("Ivan", 22), 150); // 26
        map.put(new User("Masha", 18), 280);
        map.put(new User("David", 34), 340);
        map.put(new User("Masha", 20), 123);
        map.put(new User("Ivan", 23), 10); // 27
        map.put(new User("Igor", 23), 12); // 27

        // Исправить ошибки

    }
}
