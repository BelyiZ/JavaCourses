package ru.java.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * Если тут все красное и IEDA ругается:
 * 1. ставим курсор на красный текст
 * 2. жмем alt + enter
 * 3. выбираем из того, что предлагает
 * Если там есть выбор JUnit4 vs JUnit5 - выбираем 5-ю версию
 * Если там есть текст походжий на "add dependency at module main" - выбираем его
 */
public class Lesson2Test {

    @Test
    public void formula() {
        assertEquals(5, Lesson2.formula(1), "y(1) = 5");
        assertEquals(13, Lesson2.formula(15), "y(15) = 13");
        assertEquals(44, Lesson2.formula(155), "y(155) = 44");
    }

    @Test
    public void initials() {
        assertEquals("И.И.П.", Lesson2.initials("Иванов Иван Петрович"), "Иванов Иван Петрович → И.И.П.");
        assertEquals("И.И.П.", Lesson2.initials("иванов иван петрович"), "иванов иван петрович → И.И.П.");
        assertEquals("П.А.Н.", Lesson2.initials("Петров алексей Никифорович"), "Петров алексей Никифорович → П.А.Н.");
        assertEquals("К.Г.В.", Lesson2.initials("Козлова Галина Васильевна"), "Козлова Галина Васильевна → К.Г.В.");
        assertEquals("П.А.С.", Lesson2.initials("Пушкин А. С."), "Пушкин А. С. → П.А.С.");
    }
}