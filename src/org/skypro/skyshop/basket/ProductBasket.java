package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product == null) {
                continue;
            }
            total = total + products[i].getValue();
        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        int totalCost = 0;
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product == null) {
                continue;
            }
            System.out.println(product.getName() + ": " + product.getValue());
            totalCost = totalCost + product.getValue();
        }
        System.out.println("Итого: " + totalCost);
    }

    public boolean checkProduct(String name) {
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void deleteBasket() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
    }

}
