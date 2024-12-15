package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product("Хлеб", 35);
        Product product2 = new Product("Макароны", 90);
        Product product3 = new Product("Греча", 87);
        Product product4 = new Product("Пылесос", 12500);
        Product product5 = new Product("Раковина", 3700);
        Product product6 = new Product("Диван", 24000); // создал для добавления в полную корзину

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