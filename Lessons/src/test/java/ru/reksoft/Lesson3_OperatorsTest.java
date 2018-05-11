package ru.reksoft;

import org.junit.Assert;
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
        Assert.assertEquals("1, abcde → abcde1", "abcde1", Lesson3_Operators.task1(1, "abcde"));
        Assert.assertEquals("-1, abcde → -1abcde", "-1abcde", Lesson3_Operators.task1(-1, "abcde"));
        Assert.assertEquals("11223344, abcde → abcde11223", "abcde11223", Lesson3_Operators.task1(11223344, "abcde"));
        Assert.assertEquals("-12345, abcde → -12345abcd", "-12345abcd", Lesson3_Operators.task1(-12345, "abcde"));
        Assert.assertEquals("0, abcde → 0", "0", Lesson3_Operators.task1(0, "abcde"));
        Assert.assertEquals("4, 123 → 1234", "1234", Lesson3_Operators.task1(4, "123"));
    }

    @Test
    void task2() {
        Assert.assertEquals("45 → true", true, Lesson3_Operators.task2(45));
        Assert.assertTrue("75 → true", Lesson3_Operators.task2(75));
        Assert.assertTrue("99 → true", Lesson3_Operators.task2(99));
        Assert.assertTrue("31 → true", Lesson3_Operators.task2(31));
        Assert.assertTrue("11 → false", Lesson3_Operators.task2(11));
        Assert.assertTrue("-350 → false", Lesson3_Operators.task2(-350));
        Assert.assertTrue("1000 → false", Lesson3_Operators.task2(1000));
        Assert.assertTrue("1001 → false", Lesson3_Operators.task2(1001));
        Assert.assertTrue("-1000 → false", Lesson3_Operators.task2(1001));
        Assert.assertTrue("-1001 → false", Lesson3_Operators.task2(1001));

        Assert.assertFalse("100 → false", Lesson3_Operators.task2(100));
        Assert.assertFalse("30 → false", Lesson3_Operators.task2(30));
        Assert.assertFalse("38 → false", Lesson3_Operators.task2(38));
        Assert.assertFalse("44 → false", Lesson3_Operators.task2(44));
    }
}