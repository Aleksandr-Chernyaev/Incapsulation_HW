package org.skypro.skyshop.Search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private Set<Searchable> searchableItems = new HashSet<>();

//    public void addItem(Searchable item) {
//        searchableItems.add(item);
//    }

    public Set<Searchable> search(String query) throws BestResultNotFound {
        Set<Searchable> resultSet = new TreeSet<>(new SearchableComparator());
        for (Searchable item : searchableItems) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                resultSet.add(item);
            }
        }

        if (resultSet.isEmpty()) {
            throw new BestResultNotFound("По данному запросу ничего не найдено: " + query);
        }
        return resultSet;
    }
}

