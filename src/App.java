import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Product product1 = new DiscountedProduct("Milk", 100, 10);
        Product product2 = new DiscountedProduct("Cheese", 300, 15);
        Product product3 = new FixPriceProduct("Bread");
        Product product4 = new FixPriceProduct("Water");
        Product product5 = new SimpleProduct("Apple", 100);
        Product product6 = new SimpleProduct("Flour", 200);


        ProductBasket basket = new ProductBasket();
        //Добавление продукта в корзину
        basket.addProduct(product5);
        basket.addProduct(product1);
        basket.addProduct(product3);

        //Считаем общую стоимость корзины
        //System.out.println(basket.getTotalCost());

        //Печатаем содержимое корзины в новом формате
        basket.printBasket();

        //Проверяем метод checkProduct
        System.out.println(basket.checkProduct("Milk"));
        System.out.println(basket.checkProduct("Doughnut"));

        basket.deleteBasket();
    }
}
