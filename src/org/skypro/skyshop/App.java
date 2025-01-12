package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        SimpleProduct product1 = new SimpleProduct("Хлеб", 35);
        SimpleProduct product2 = new SimpleProduct("Макароны", 90);
        FixPriceProduct product3 = new FixPriceProduct("Греча");
        DiscountedProduct product4 = new DiscountedProduct("Пылесос", 12500, 50);
        DiscountedProduct product5 = new DiscountedProduct("Раковина", 3700, 25);
        SimpleProduct product6 = new SimpleProduct("Диван", 24000); // создал для добавления в полную корзину

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);

        Article article1 = new Article("Как выбрать пылесос", "Различные советы по выбору пылесоса.");
        Article article2 = new Article("Лучшие макароны за 2024 год", "Лучшие рецепты с макаронами.");
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("Результаты поиска для 'пылесос':");
        System.out.println(Arrays.toString(searchEngine.search("пылесос")));

        System.out.println("Результаты поиска для 'макароны':");
        System.out.println(Arrays.toString(searchEngine.search("макароны")));

        System.out.println("Результаты поиска для 'лучшие':");
        System.out.println(Arrays.toString(searchEngine.search("лучшие")));

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        // Пробую добавить продукт в заполненную корзину
        basket.addProduct(product6);

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        int totalPrice = basket.getTotalPrice();
        System.out.println("Общая стоимость корзины: " + totalPrice);

        boolean containsProduct1 = basket.containsProduct("Макароны");
        System.out.println("Содержится ли в корзине товар: 'Макароны'? - " + containsProduct1);

        boolean containsProduct7 = basket.containsProduct("Утюг");
        System.out.println("Содержится ли в корзине товар: 'Утюг'? - " + containsProduct7);

        basket.clearBasket();
        System.out.println("Корзина очищена.");

        System.out.println("Содержимое пустой корзины:");
        basket.printBasket();

        int emptyBasketPrice = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + emptyBasketPrice);

        boolean containsProductInEmptyBasket = basket.containsProduct("Греча");
        System.out.println("Содержит ли пустая корзина товар: 'Греча'? - " + containsProductInEmptyBasket);
    }
}