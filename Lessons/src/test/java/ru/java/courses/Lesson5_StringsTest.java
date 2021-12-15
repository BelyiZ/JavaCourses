package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.java.courses.Lesson5_Strings.task1;
import static ru.java.courses.Lesson5_Strings.task2;
import static ru.java.courses.Lesson5_Strings.task3;

import org.junit.jupiter.api.Test;

public class Lesson5_StringsTest {

    @Test
    void task1test() {
        assertEquals(
                task1(new String[]{"abc", "123", "ABC", "abc", "qwerty", "aBc", "123", "QwErTy"}),
                "abc123ABCqwertyaBcQwErTy"
        );
        assertEquals(
                task1(new String[]{}),
                ""
        );
        assertEquals(
                task1(new String[]{"abc", "123", "abc", "abc", "123", "abc", "123", "123"}),
                "abc123"
        );
    }

    @Test
    void task2test() {
        assertArrayEquals(
                task2(new String[][]{
                        new String[]{"Розы и шипы", "Андрей С. Долгов"},
                        new String[]{"Фантастика\"", "Ф. Н. Ковров"},
                        new String[]{"\"Считалочка", "С. Никифорович Тестов"},
                        new String[]{"\"Программист\"", "Андрей К. Иванов"},
                        new String[]{"Идиоты", "Петр Петрович Петров"}
                }),
                new String[]{
                        "\"Розы и шипы\" А. С. Долгов",
                        "\"Фантастика\" Ф. Н. Ковров",
                        "\"Считалочка\" С. Н. Тестов",
                        "\"Программист\" А. К. Иванов",
                        "\"Идиоты\" П. П. Петров",
                }
        );
    }

    @Test
    void task3test() {
        assertEquals(task3("Java 6 for all time", 'f', 'e'), "or all tim");
        assertEquals(task3("Java 6 for all time", '6', 't'), " for all ");
        assertEquals(task3("Java 6 for all time", 'y', 'e'), "");
        assertEquals(task3("Java 6 for all time", 'J', 'w'), "");
        assertEquals(task3("Java 6 for all time", 'i', 'v'), "a 6 for all t");
    }
}
