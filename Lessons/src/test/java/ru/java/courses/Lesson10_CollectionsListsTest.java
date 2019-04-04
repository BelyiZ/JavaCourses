package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Array;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Если тут все красное и IEDA ругается:
 * 1. ставим курсор на красный текст
 * 2. жмем alt + enter
 * 3. выбираем из того, что предлагает
 * Если там есть выбор JUnit4 vs JUnit5 - выбираем 5-ю версию
 * Если там есть текст походжий на "add dependency at module main" - выбираем его
 */
class Lesson10_CollectionsListsTest {

    @Test
    void task1() {
        assertIterableEquals(
                Arrays.asList("1", "9", "13", "15", "22", "23", "42", "56", "95"),
                Lesson10_CollectionsLists.task1(Arrays.asList(23, 15, 1, 56, 22, 42, 95, 13, 9))
        );
        assertIterableEquals(
                Arrays.asList("4", "7"),
                Lesson10_CollectionsLists.task1(Arrays.asList(7, 4, 7, 4, 7, 4, 7, 4, 7))
        );
        assertIterableEquals(
                Arrays.asList("-27", "-7", "-4", "0", "4", "7", "14", "27"),
                Lesson10_CollectionsLists.task1(Arrays.asList(0, -4, 7, 4, -7, 14, 27, 4, -27))
        );
        assertIterableEquals(
                Arrays.asList("0", "4", "7", "14", "27"),
                Lesson10_CollectionsLists.task1(Arrays.asList(0, 7, 4, 14, 27, 4))
        );

    }

    @Test
    void task2() {
        assertIterableEquals(
                Arrays.asList(57, 23, 43, 95, 13),
                Lesson10_CollectionsLists.task2(23, 15, 1, 56, 22, 42, 95, 13, 9)
        );
        assertIterableEquals(
                Arrays.asList(5, 7, 5, 7, 5),
                Lesson10_CollectionsLists.task2(7, 4, 7, 4, 7, 4, 7, 4, 7)
        );
        assertIterableEquals(
                Arrays.asList(5, -7, 15, 27, 5),
                Lesson10_CollectionsLists.task2(0, -4, 7, 4, -7, 14, 27, 4, -27)
        );
        assertIterableEquals(
                Arrays.asList(15, 27, 5),
                Lesson10_CollectionsLists.task2(0, 7, 4, 14, 27, 4)
        );
    }
}