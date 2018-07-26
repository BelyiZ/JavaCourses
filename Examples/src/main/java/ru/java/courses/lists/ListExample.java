package ru.java.courses.lists;

import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");

        list.get(2);
        System.out.println(list.get(2));

    }
}
