package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository productRepository = new ProductRepository();

    @Test
    void shouldSaveAndGetAll() {
        Book firstBook = new Book(1,"First Book",1000,"L.Tolstoy");
        Book secondBook = new Book(2,"Second Book",1000,"L.Tolstoy");
        productRepository.save(firstBook);
        productRepository.save(secondBook);
        Product[] expected = new Product[] {firstBook, secondBook};
        Product[] actual = productRepository.getAllProducts();
        assertArrayEquals(expected, actual);
    }
}
