package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager testManager = new ProductManager(repo);
    Product[]expected, expectedMess, expectedBook, expectedThreeBooks, expectedPhones,expectedOnePhone = new Product[0];

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
//       массив из: {book1, book3, phone1, book2, phone2, phone3}

        expectedMess = new Product[]{book2, phone2};
        expectedBook = new Product[]{book3};
        expectedThreeBooks = new Product[]{book1, book3, book2};
        expectedPhones = new Product[]{phone1, phone2};
        expectedOnePhone = new Product[] {phone3};
    }

    // для каждого типа продукта протестить когда находится 0, 1 или несколько ответов.
    @Test
    void nothingFound() {
        expected = new Product[0];
        Product[] actual = testManager.searchBy("java");
        assertArrayEquals(expected, actual);
    }

    @Test
    void oneBookFound() {
        Product[] actual = testManager.searchBy("Duma");
        assertArrayEquals(expectedBook, actual);

    }

    @Test
    void severalBooksFound() {
        Product[] actual = testManager.searchBy("война");
        assertArrayEquals(expectedThreeBooks, actual);
    }

    @Test
    void onePhoneFound() {
        Product[] actual = testManager.searchBy("xin");
        assertArrayEquals(expectedOnePhone, actual);
    }

    @Test
    void severalPhonesFound() {
        Product[] actual = testManager.searchBy("iphon");
        assertArrayEquals(expectedPhones, actual);
    }

    @Test
    void searchBy() {

        Product[] actual = testManager.searchBy("noName");
        assertArrayEquals(expectedMess, actual);

    }
}