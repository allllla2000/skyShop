package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total = total + product.getValue();
            }
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int totalCost = 0;
        int specialCount = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
                totalCost = totalCost + product.getValue();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void deleteBasket() {
        products.clear();
    }

    public List<Product> deleteNameBasket(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }


}
