package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Если тут все красное и IEDA ругается:
 * 1. ставим курсор на красный текст
 * 2. жмем alt + enter
 * 3. выбираем из того, что предлагает
 * Если там есть выбор JUnit4 vs JUnit5 - выбираем 5-ю версию
 * Если там есть текст походжий на "add dependency at module main" - выбираем его
 */
class Lesson3_OperatorsTest {

    @Test
    void task1() {
        assertEquals("abcde1", Lesson3_Operators.task1(1, "abcde"), "1, abcde → abcde1");
        assertEquals("-1abcde", Lesson3_Operators.task1(-1, "abcde"), "-1, abcde → -1abcde");
        assertEquals("abcde11223", Lesson3_Operators.task1(11223344, "abcde"), "11223344, abcde → abcde11223");
        assertEquals("-12345abcd", Lesson3_Operators.task1(-12345, "abcde"), "-12345, abcde → -12345abcd");
        assertEquals("0", Lesson3_Operators.task1(0, "abcde"), "0, abcde → 0");
        assertEquals("1234", Lesson3_Operators.task1(4, "123"), "4, 123 → 1234");
    }

    @Test
    void task2() {
        assertFalse(Lesson3_Operators.task2(45), "45 → false");
        assertFalse(Lesson3_Operators.task2(75), "75 → false");
        assertFalse(Lesson3_Operators.task2(99), "99 → false");
        assertFalse(Lesson3_Operators.task2(31), "31 → false");
        assertFalse(Lesson3_Operators.task2(-1000), "-1000 → false");
        assertFalse(Lesson3_Operators.task2(-1001), "-1001 → false");

        assertTrue(Lesson3_Operators.task2(-350), "-350 → true");
        assertTrue(Lesson3_Operators.task2(1000), "1000 → true");
        assertTrue(Lesson3_Operators.task2(1001), "1001 → true");
        assertTrue(Lesson3_Operators.task2(11), "11 → true");
        assertTrue(Lesson3_Operators.task2(100), "100 → true");
        assertTrue(Lesson3_Operators.task2(30), "30 → true");
        assertTrue(Lesson3_Operators.task2(38), "38 → true");
        assertTrue(Lesson3_Operators.task2(44), "44 → true");

    }
}