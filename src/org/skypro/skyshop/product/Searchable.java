package org.skypro.skyshop.product;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getObjName();

    // Метод преобразования Searchable-объекта в строку
    default String getStringRepresentation() {
        return getObjName() + " — " + getContentType();
    }
}
