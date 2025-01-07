import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

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


        SearchEngine searchEngine = new SearchEngine(10);

        Searchable obj1 = new Article("Какая модель iPhone вам подойдет", "Текст статьи " +
                " про модели iPhone");
        Searchable obj2 = new Article("Осенние пироги", "Рецепты пирогов, куда входят " +
                "яблоки и сливы");

        searchEngine.add(obj1);
        searchEngine.add(obj2);

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
