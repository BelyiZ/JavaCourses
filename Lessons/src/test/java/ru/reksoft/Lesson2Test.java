package ru.reksoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

class Lesson2Test {

    @Test
    void formula() {
        assertEquals(5, Lesson2.formula(1), "y(1) = 5");
        assertEquals(13, Lesson2.formula(15), "y(15) = 13");
        assertEquals(44, Lesson2.formula(155), "y(155) = 44");
    }

    @Test
    void initials() {
        assertEquals("И.И.П.", Lesson2.initials("Иванов Иван Петрович"), "Иванов Иван Петрович → И.И.П.");
        assertEquals("П.А.Н.", Lesson2.initials("Петров алексей Никифорович"), "Петров алексей Никифорович → П.А.Н.");
        assertEquals("К.Г.В.", Lesson2.initials("Козлова Галина Васильевна"), "Козлова Галина Васильевна → К.Г.В.");
        assertEquals("П.А.С.", Lesson2.initials("Пушкин А. С."), "Пушкин А. С. → П.А.С.");
    }
}