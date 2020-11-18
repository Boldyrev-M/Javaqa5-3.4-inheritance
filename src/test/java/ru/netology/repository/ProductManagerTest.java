package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager testManager = new ProductManager(repo);
    Product[] expected = new Product[0];

    @BeforeEach
    void setUp() {
        Book book1 = new Book(1, "Война и мiръ", 1000, "Лев Толстой");
        Book book2 = new Book(2, "Моя тайная война", 500, "noname");
        Book book3 = new Book(3, "Война миров", 700, "A. Dumas");
        Smartphone phone1 = new Smartphone(4, "iPhone", 12_399, "Apple");
        Smartphone phone2 = new Smartphone(5, "iPhone", 15_399, "noname");
        Smartphone phone3 = new Smartphone(6, "Xinqenq", 15_399, "China");
        testManager.add(book1);
        testManager.add(book3);
        testManager.add(phone1);
        testManager.add(book2);
        testManager.add(phone2);
        testManager.add(phone3);
        expected = new Product[]{book2, phone2};
//       массив из: {book1, book3, phone1, book2, phone2, phone3}
    }

    @Test
    void searchBy() {

        Product[] actual = testManager.searchBy("noName");
        assertArrayEquals(expected, actual);

    }

    @Test
    void matches() {
        Book book1 = new Book(1, "Война и мiръ", 1000, "Лев Толстой");
        boolean lev = testManager.matches(book1, "лев");
        assertFalse(lev);
        boolean levTolstoy = testManager.matches(book1, "лев толстой");
        assertTrue(levTolstoy);
        boolean voy = testManager.matches(book1, "Война и мiръ");
        assertTrue(voy);

        Smartphone phone1 = new Smartphone(4, "iPhone", 12_399, "Apple");
        boolean appl = testManager.matches(phone1, "Apple");
        assertTrue(appl);
        boolean namePhone = testManager.matches(phone1, "iPhone");
        assertTrue(namePhone);

        Product badProd = new Product();
        boolean noBookNoPhone = testManager.matches(badProd, "Война и мiръ");
        assertFalse(noBookNoPhone);

    }
}