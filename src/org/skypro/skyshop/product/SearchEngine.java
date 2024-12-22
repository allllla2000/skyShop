package org.skypro.skyshop.product;

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
}

