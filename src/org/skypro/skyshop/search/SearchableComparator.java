package org.skypro.skyshop.search;
import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable a1, Searchable a2) {
        int lengthComparison = Integer.compare(a2.getSearchTerm().length(), a1.getSearchTerm().length());
        return (lengthComparison != 0) ? lengthComparison : a1.getSearchTerm().compareTo(a2.getSearchTerm());
    }
}
