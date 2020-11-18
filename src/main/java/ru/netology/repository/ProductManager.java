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
            if( checkOneProd.matches(searching) )
                tempRepo.save(checkOneProd);
        }

        return tempRepo.getAllProducts();
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "repo=" + repo +
                '}';
    }
}
