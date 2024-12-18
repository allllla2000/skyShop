package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    int basePrice;
    int discountPercents;

    public DiscountedProduct(String name, int basePrice, int discountPercents) {
        super(name);
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
