package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Article implements Searchable {
    private final String name;

    public Article(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return name.equals(article.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return getStringRepresentation();
    }
}