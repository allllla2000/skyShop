import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.*;

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

        Searchable obj1 = new Article("iPhone или Samsung?", "Сравнение моделей");
        Searchable obj2 = new Article("Осенние пироги", "Рецепты с яблоками");
        Searchable obj3 = new Article("Топ-5 рецептов пирогов из яблок", "Длинный текст статьи");
        Searchable obj4 = new Article("iPhone 16: стоит ли покупать?", "Обзор новинки");
        Searchable obj5 = new Article("Яблоко — лучший фрукт?", "Еда и здоровье");
        Searchable obj6 = new Article("Летние десерты", "Рецепты летних десертов");


        searchEngine.add(obj1);
        searchEngine.add(obj2);
        searchEngine.add(obj3);
        searchEngine.add(obj4);
        searchEngine.add(obj5);
        searchEngine.add(obj6);


        String query = "";
        Set<Searchable> results = searchEngine.search(query);


        System.out.println("Результаты поиска (от самой длинной статьи к самой короткой):");
        for (Searchable searchable : results) {
            System.out.println("Название: " + searchable.getObjName());
        }

        if (results.isEmpty()) {
            System.out.println("По запросу ничего не нашлось");
        } else {
            System.out.println("Найденные результаты: ");
            for (Searchable searchable : results) {
                System.out.println("Название: " + searchable.getObjName() + ", Содержимое: " + searchable.getSearchTerm());
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
