package ru.java.courses.stack;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("C#");
        stack.push("Pascal");
        stack.push("Swift");

        while(!stack.empty()) {
            System.out.println(stack.pop());
            System.out.println(stack.peek());
            int position = stack.search("Swift");
        }



    }
}
