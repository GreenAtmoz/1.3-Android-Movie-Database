package com.example.movieapp.Domain;

public class ReviewElements {
    String name;
    String content;
    String rating;
    public ReviewElements(String name, String content, String rating) {
        this.name = name;
        this.content = content;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
