package org.skypro.skyshop.Search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthComparison = Integer.compare(o1.getName().length(), o2.getName().length());
        if (lengthComparison != 0) {
            return -lengthComparison;
        }
        return o1.getName().compareTo(o2.getName());
    }
}