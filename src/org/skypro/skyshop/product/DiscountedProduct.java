package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    int basePrice;
    int discountPercents;

    public DiscountedProduct(String name, int basePrice, int discountPercents) {
        super(name);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        if (discountPercents < 0 || discountPercents > 100) {
            throw new IllegalArgumentException("Процент должен быть в диапазоне от 0 до 100");
        }
        this.basePrice = basePrice;
        this.discountPercents = discountPercents;
    }

    @Override
    public int getValue() {
        return basePrice - (basePrice * discountPercents / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getValue() + " (Скидка " + discountPercents + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
