package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void matches() {

        Book book1 = new Book(1, "Война и мiръ", 1000, "Лев Толстой");
        boolean lev = book1.matches("лев");
//        совпал по автору
        assertTrue(lev);

        boolean ivanov = book1.matches("Иванов");
        // нет подстроки
        assertFalse(ivanov);

        boolean voy = book1.matches("и мiръ");
        // совпал по названию
        assertTrue(voy);
    }

}
