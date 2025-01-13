package org.skypro.skyshop;

import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        try {
            Product product1 = new SimpleProduct("", 57);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product2 = new SimpleProduct("Хурма", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product3 = new DiscountedProduct("Губная гармошка", 8965, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product4 = new SimpleProduct("Макароны", 70);
            Product product5 = new SimpleProduct("Диван", 17500);
            Product product6 = new DiscountedProduct("Книга", 825, 37);
            searchEngine.add(product4);
            searchEngine.add(product5);
            searchEngine.add(product6);

            Searchable result = searchEngine.search("Макароны");
            System.out.println("По Вашему запросу найдено: " + result.getStringRepresentation());

            result = searchEngine.search("Котлета");
            System.out.println("По Вашему запросу найдено: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}