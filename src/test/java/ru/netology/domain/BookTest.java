package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void matches() {

        Book book1 = new Book(1, "Война и мiръ", 1000, "Лев Толстой");
        boolean lev = book1.matches("лев");
        assertFalse(lev);

        boolean levTolstoy = book1.matches("лев толстой");
        assertTrue(levTolstoy);
        boolean voy = book1.matches("Война и мiръ");
        assertTrue(voy);
    }
}