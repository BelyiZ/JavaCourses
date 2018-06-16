package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.java.courses.Lesson4_FlowControl.task1;
import static ru.java.courses.Lesson4_FlowControl.task2;

import org.junit.jupiter.api.Test;
/**
 * Если тут все красное и IEDA ругается:
 * 1. ставим курсор на красный текст
 * 2. жмем alt + enter
 * 3. выбираем из того, что предлагает
 * Если там есть выбор JUnit4 vs JUnit5 - выбираем 5-ю версию
 * Если там есть текст походжий на "add dependency at module main" - выбираем его
 */
class Lesson4_FlowControlTest {

    @Test
    void task1test() {
        assertEquals(
                "Вишневый сад",
                task1(new String[]{"Тихий дон", "Вишневый сад", "Война и мир", "Мертвые души"}),
                "{\"Тихий дон\", \"Вишневый сад\", \"Война и мир\", \"Мертвые души\"} → \"Вишневый сад\""
        );
        assertEquals(
                "Кирпич",
                task1(new String[]{"Кирпич", "Блок", "Плита", "Кольцо"}),
                "{\"Кирпич\", \"Блок\", \"Плита\", \"Кольцо\"} → \"Кирпич\""
        );
        assertEquals(
                "Горб",
                task1(new String[]{"Горб", "Горн"}),
                "{\"Горб\", \"Горн\"} → \"Горб\""
        );
        assertEquals("", task1(new String[0]), "{} → \"\"");
        assertEquals("Я", task1(new String[]{"Я"}), "{\"Я\"} → \"Я\"");
    }

    @Test
    void task2test() {
        assertEquals(4, task2(2, 2, '*'), "2 * 2 = 4");
        assertEquals(17, task2(5, 12, '+'), "5 + 12 = 17");
        assertEquals(0, task2(0, 0, '*'), "0 * 0 = 0");
        assertEquals(-9, task2(1, 10, '-'), "1 - 10 = -9");
        assertEquals(4, task2(25, 6, '/'), "25 / 6 = 4");
        assertEquals(1, task2(121, 2, '%'), "121 % 2 = 1");
        assertEquals(0, task2(17, 0, '/'), "121 / 0 = 0");
        assertEquals(0, task2(21, 1, '>'), "121 > 1 = 0");
    }
}