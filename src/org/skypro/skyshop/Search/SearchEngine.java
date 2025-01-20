package org.skypro.skyshop.Search;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchableItems;

    public SearchEngine(List<Searchable> items) {
        this.searchableItems = items;
    }

    public Map<String, Searchable> search(String query) throws BestResultNotFound {
        Map<String, Searchable> resultMap = new TreeMap<>();
        for (Searchable item : searchableItems) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                resultMap.put(item.getName(), item);
            }
        }

        if (resultMap.isEmpty()) {
            throw new BestResultNotFound("По данному запросу ничего не найдено: " + query);
        }
        return resultMap;
    }
}