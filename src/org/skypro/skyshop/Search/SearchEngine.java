package org.skypro.skyshop.Search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchableItems = new HashSet<>();

    public Set<Searchable> search(String query) throws BestResultNotFound {
        Supplier<TreeSet<Searchable>> supplier = () -> new TreeSet<>(new SearchableComparator());

        Set<Searchable> resultSet = searchableItems.stream()
                .filter(item -> item.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(supplier));

        if (resultSet.isEmpty()) {
            throw new BestResultNotFound("По данному запросу ничего не найдено: " + query);
        }
        return resultSet;
    }
}