package com.ozzyjpa.demojpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String rating;

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }

    protected Review() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
