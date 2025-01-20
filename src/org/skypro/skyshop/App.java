package org.skypro.skyshop;

import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Хурма", 574);
        Product product2 = new SimpleProduct("Куртка", 1870);
        Product product3 = new DiscountedProduct("Аспирин", 140, 27);
        Product product4 = new FixPriceProduct("Греча");

        List<Searchable> items = new ArrayList<>();

        items.add(product1);
        items.add(product2);
        items.add(product3);
        items.add(product4);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);

        basket.printContents();

        SearchEngine searchEngine = new SearchEngine(items);
        try {
            Map<String, Searchable> searchResults = searchEngine.search("Куртка");
            System.out.println("Найденные результаты: ");
            for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        List<Product> removedProducts = basket.removeProductsByName("Аспирин");
        System.out.println("Удалённые продукты:");
        for (Product product : removedProducts) {
            System.out.println(product.getName());
        }
        basket.printBasket();

        List<Product> emptyRemoval = basket.removeProductsByName("Холодильник");
        if (emptyRemoval.isEmpty()) {
            System.out.println("Список пуст.");
        }
        basket.printBasket();
    }
}