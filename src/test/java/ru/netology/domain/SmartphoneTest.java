package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void matches() {
        Smartphone phone1 = new Smartphone(4, "iPhone", 12_399, "Apple");
        boolean appl = phone1.matches("Apple");
        assertTrue(appl);
        boolean namePhone = phone1.matches("iPhone");
        assertTrue(namePhone);
    }

}