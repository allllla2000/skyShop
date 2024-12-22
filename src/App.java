import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(new DiscountedProduct("Яблоки", 200, 10));
        searchEngine.add(new FixPriceProduct("Мука"));
        searchEngine.add(new SimpleProduct("Сахар", 150));

        searchEngine.add(new Article("Что приготовить из яблок", "Шарлотка "
                + "Яблоки в карамели и другая выпечка - рецепты тут"));
        searchEngine.add(new Article("Мука и глютен, вред и польза", "Исследования  "
                + " ученых по поводу вреда и пользы глютена, или это миф"));
        searchEngine.add(new Article("Сахар: как правильно выбрать", "Статья с советами "
                + " экспертов, как выбрать сахар"));


        //ищем по строке "Яблоки"
        Searchable[] results1 = searchEngine.search("Яблоки");
        System.out.println(Arrays.toString(results1));

        //ищем по строке "Мука"
        Searchable[] results2 = searchEngine.search("Мука");
        System.out.println(Arrays.toString(results2));

        //ищем по строке "Сахар"
        Searchable[] results3 = searchEngine.search("Сахар");
        System.out.println(Arrays.toString(results3));


    }
}
