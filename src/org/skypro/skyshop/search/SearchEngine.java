package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private ArrayList<Searchable> searchables = new ArrayList<>();

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results.put(searchable.getObjName(), searchable);
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

