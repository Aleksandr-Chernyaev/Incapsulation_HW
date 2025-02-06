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

    public int getTotalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printContents() {
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(" - " + product));
    }

    public void printBasket() {
        System.out.println("Содержимое корзины:");
        printContents();
        System.out.println("Общее количество продуктов в корзине: " + getTotalCount());
        System.out.println("Количество специальных продуктов: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    private int getTotalCount() {
        return (int) products.values().stream()
                .flatMap(Collection::stream)
                .count();
    }
}