package ru.netology.repository;

import ru.netology.domain.Product;

import java.util.Arrays;

public class ProductRepository {
    private Product[] products = new Product[0];

    public ProductRepository() {
    }

    public void save(Product prodToAdd) {
        int length = products.length + 1;
        Product[] tempo = new Product[length];
        System.arraycopy(products,0,tempo,0, products.length);
        tempo[length-1] = prodToAdd;
        products = tempo;
    }

    public Product[] getAllProducts() {
        return products;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tempo = new Product[length];
        int i = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tempo[i] = item;
                i++;
            }
        }
        products = tempo;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}
