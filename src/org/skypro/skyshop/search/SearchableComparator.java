package org.skypro.skyshop.search;
import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable a1, Searchable a2) {
        int lengthComparison = Integer.compare(a2.getObjName().length(), a1.getObjName().length());
        return (lengthComparison != 0) ? lengthComparison : a1.getObjName().compareTo(a2.getObjName());
    }
}
