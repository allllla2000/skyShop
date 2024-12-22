package org.skypro.skyshop.product;

import java.sql.SQLOutput;

public class SimpleProduct extends Product {
    private int value;

    public SimpleProduct(String name, int value) {
        super(name);
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getName() + ": " + getValue();
    }
}
