package com.example.movieapp.Domain;

public class Review {
    private String author;
    private String content;

    public Review(String author, String content, int movieId, String reviewId) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
}
