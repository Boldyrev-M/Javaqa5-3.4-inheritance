package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product prod) {
        repo.save(prod);
    }

    public Product[] searchBy(String searching) {

        Product[] allProducts = repo.getAllProducts();
        ProductRepository tempRepo = new ProductRepository();

        for (Product checkOneProd : allProducts) {
            if( matches(checkOneProd, searching))
                tempRepo.save(checkOneProd);
        }

        return tempRepo.getAllProducts();
    }

    public boolean matches(Product prod, String search) {

        if (prod instanceof Book) {
            // для книги по полям название и автор
            Book book = (Book) prod;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        if (prod instanceof Smartphone) {
            // для смартфона по полям название и производитель
            Smartphone smart = (Smartphone) prod;
            if (smart.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smart.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "repo=" + repo +
                '}';
    }
}
