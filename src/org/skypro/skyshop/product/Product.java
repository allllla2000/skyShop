package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    //В классе товаров нужно имплементировать интерфейс
    //Searchable
    //и в качестве
    //search term
    // — «возвращать имя товара», а в качестве типа — возвращать строку PRODUCT.

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getValue();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getObjName() {
        return name;
    }


}

