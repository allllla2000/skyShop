package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;

import java.util.stream.Collectors;

public class ProductBasket {

    private Map<String, ArrayList<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getValue)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        products.forEach((name, productList) -> {
            System.out.println("Товар: " + name + ", количество: " + productList.size());
            productList.forEach(System.out::println);
        });

        int totalCost = products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getValue)
                .sum();
        System.out.println("Итого: " + totalCost);
    }

    private void getSpecialCount() {
        long specialCount = products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        System.out.println("Специальных товаров " + specialCount);
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
