package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Map<String, ArrayList<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (ArrayList<Product> productGroup : products.values()) {
            for (Product currentProduct : productGroup) {
                total += currentProduct.getValue();
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

        for (Map.Entry<String, ArrayList<Product>> entry : products.entrySet()) {
            String productName = entry.getKey();
            ArrayList<Product> productList = entry.getValue();

            System.out.println("Товар: " + productName + ", количество: " + productList.size());
            for (Product product : productList) {
                System.out.println("  " + product);
                totalCost += product.getValue();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + specialCount);
    }


    public boolean checkProduct(String name) {
        return products.containsKey(name);
    }

    public void deleteBasket() {
        products.clear();
    }

    public List<Product> deleteNameBasket(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }


}
