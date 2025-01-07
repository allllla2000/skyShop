package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {

    private Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }

            if (searchable.getSearchTerm().contains(query)) {
                results[resultIndex] = searchable;
                resultIndex++;

                if (resultIndex == 5) {
                    break;
                }
            }
        }

        return results;
    }

    public boolean add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = searchable;
            currentIndex++;
            return true;
        } else {
            return false;
        }
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

