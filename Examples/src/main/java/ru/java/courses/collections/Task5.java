package ru.java.courses.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Task5 {

    static class User {

        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 22));
        list.add(new User("David", 34));
        list.add(new User("Masha", 18));
        list.add(new User("Igor", 25));

        // отсортировать по имени
        // отсортировать по возрасту
    }
}
