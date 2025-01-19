package org.skypro.skyshop;

import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        Product product1 = new SimpleProduct("Хурма", 574);
        Product product2 = new SimpleProduct("Куртка", 1870);
        Product product3 = new DiscountedProduct("Аспирин", 140, 27);
        Product product4 = new FixPriceProduct("Греча");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);

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

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);

        try {
            List<Searchable> searchResults = searchEngine.search("Хурма");

            if (!searchResults.isEmpty()) {
                System.out.println("Найденные результаты:");
                for (Searchable result : searchResults) {
                    System.out.println(result.getSearchTerm());
                }
            } else {
                System.out.println("Ничего не найдено.");
            }

        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}