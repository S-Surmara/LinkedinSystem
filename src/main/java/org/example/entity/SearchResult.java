package org.example.entity;

import org.example.enums.SearchResultType;

public class SearchResult {
    private String id;
    private SearchResultType type;
    private Object entity;
    private double relevanceScore;

    public SearchResult(String id, SearchResultType type, Object entity, double relevanceScore) {
        this.id = id;
        this.type = type;
        this.entity = entity;
        this.relevanceScore = relevanceScore;
    }

    public String getId() {
        return id;
    }

    public SearchResultType getType() {
        return type;
    }

    public Object getEntity() {
        return entity;
    }

    public double getRelevanceScore() {
        return relevanceScore;
    }

    public void setRelevanceScore(double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", relevanceScore=" + relevanceScore +
                '}';
    }
}
