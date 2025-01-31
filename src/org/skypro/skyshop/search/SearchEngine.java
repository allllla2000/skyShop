package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchables = new HashSet<>();

    public SearchEngine() {
        searchables = new HashSet<>();
    }


    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }

        return results;
    }

    public boolean add(Searchable searchable) {
        return searchables.add(searchable);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }

            String searchTerm = searchable.getSearchTerm();
            int count = 0;

            int index = searchTerm.indexOf(search);
            while (index != -1) {
                count++;
                index = searchTerm.indexOf(search, index + search.length());
            }

            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Для поискового запроса " + search +
                    " не нашлось подходящей статьи");
        }

        return bestMatch;

    }
}

