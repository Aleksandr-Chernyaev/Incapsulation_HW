package org.skypro.skyshop.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new ArrayList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public List<Searchable> search(String term) throws BestResultNotFound {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(item);
            }
        }

        if (results.isEmpty()) {
            throw new BestResultNotFound("Не найдено подходящих результатов для: " + term);
        }

        return results;
    }
}