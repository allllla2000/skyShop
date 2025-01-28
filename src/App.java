import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Product apple = new SimpleProduct("яблоко", 120);
        Product chocolate = new SimpleProduct("шоколад", 400);
        Product chocolate2 = new DiscountedProduct("шоколад", 290, 10);
        Product sugar = new FixPriceProduct("сахар");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(chocolate2);
        basket.addProduct(chocolate);
        basket.addProduct(sugar);

        List<Product> deleted = basket.deleteNameBasket(" ");

        if (deleted.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты: ");
            for (Product product : deleted) {
                System.out.println(product);
            }
        }


        System.out.println("Вывести содержимое корзины");
        basket.printBasket();


        List<Product> deletedNonEx = basket.deleteNameBasket("пирог");
        if (deletedNonEx.isEmpty()) {
            System.out.println("Такого продукта нет в корзине");
        }

        basket.printBasket();


        SearchEngine searchEngine = new SearchEngine();

        Searchable obj1 = new Article("Какая модель iPhone вам подойдет", "Текст статьи " +
                " про модели iPhone");
        Searchable obj2 = new Article("Осенние пироги", "Рецепты пирогов, куда входят " +
                "яблоки и сливы ");

        searchEngine.add(obj1);
        searchEngine.add(obj2);

        String query = "яблоки";
        Map<String, Searchable> results = searchEngine.search(query);

        if (results.isEmpty()) {
            System.out.println("По запросу ничего не нашлось");
        } else {
            System.out.println("Найденные результаты: ");
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                System.out.println("Название: " + entry.getKey() + ", Содержимое: " + entry.getValue().getSearchTerm());
            }
        }


        try {
            Product product1 = new SimpleProduct("iPhone", -1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product product2 = new SimpleProduct("sugar", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product product3 = new DiscountedProduct("dyson", 850, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product product4 = new DiscountedProduct("chocolate", -10, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




        try {
            Searchable bestMatch = searchEngine.findBestMatch("Рецепты");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("модель");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Samsung");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("шоколад");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


    }
}
