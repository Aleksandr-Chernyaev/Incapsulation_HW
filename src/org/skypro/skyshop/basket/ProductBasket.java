package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.putIfAbsent(product.getName(), new ArrayList<>());
        products.get(product.getName()).add(product);
    }

    public List<Product> removeProductsByName(String productName) {
        List<Product> removedProducts = products.remove(productName);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }

    public void printContents() {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            System.out.println("Имя продукта: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product);
            }
        }
    }

    public void printBasket() {
    }
}