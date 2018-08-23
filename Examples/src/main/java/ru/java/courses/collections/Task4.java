package ru.java.courses.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        Set<User> set = new TreeSet<>();
        set.add(new User("Ivan", 22)); // ivan
        set.add(new User("Masha", 18)); // masha
        set.add(new User("David", 34));
        set.add(new User("Masha", 19));
        set.add(new User("Ivan", 23));
        set.add(new User("Igor", 25));
        set.add(new User("Vasya", 18));


        // Убрать повторения пользователей, сортировать по имени

    }
}
