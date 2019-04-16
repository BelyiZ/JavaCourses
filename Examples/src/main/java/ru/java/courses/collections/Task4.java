package ru.java.courses.collections;

import java.util.ArrayList;
import java.util.List;

public class Task4 {

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
        collection.add(new User("Ivan", 22)); // ivan
        collection.add(new User("Masha", 18)); // masha
        collection.add(new User("David", 34));
        collection.add(new User("Masha", 19));
        collection.add(new User("Ivan", 23));
        collection.add(new User("Igor", 25));
        collection.add(new User("Vasya", 18));


        // Убрать повторения пользователей, сортировать по имени

    }
}
