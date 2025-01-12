package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (products.size() >= 5) {
            System.out.println("Невозможно добавить продукт!");
            return;
        }
        products.add(product);
    }

    public void printBasket() {
        int totalPrice = 0;
        int specialCount = 0;

        for (Product product : products) {
            System.out.println(product);
            totalPrice += product.getPrice();

            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + totalPrice);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена.");
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}