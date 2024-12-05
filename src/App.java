import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product("iPhone", 1000);
        Product product2 = new Product("macBook", 1500);
        Product product3 = new Product("watch", 800);
        Product product4 = new Product("tvScreen", 900);
        Product product5 = new Product("box", 10);
        Product product6 = new Product("glasses", 3500);


        ProductBasket basket = new ProductBasket();

        //Добавление продукта в корзину
//        basket.addProduct(product4);
//        basket.addProduct(product5);

//        //Добавление продукта в заполненную корзину, в которой нет свободного места
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
//
//        //Печать содержимого корзины с несколькими товарами
        basket.printBasket();
//
//        //Получение стоимости корзины с несколькими товарами
        System.out.println(basket.getTotalCost());
//
//        //Поиск товара, который есть в корзине
        System.out.println(basket.checkProduct("iPhone"));
//
//        //Поиск товара, которого нет в корзине
        System.out.println(basket.checkProduct("car"));
//
//        //Очистка корзины
        basket.deleteBasket();
//
//        //Печать содержимого пустой корзины
        basket.printBasket();
//
//        //Получение стоимости пустой корзины
        System.out.println(basket.getTotalCost());
//
//        //Поиск товара по имени в пустой корзине
        System.out.println(basket.checkProduct("box"));



    }
}
