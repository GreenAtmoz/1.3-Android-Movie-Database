package com.example.movieapp.DataStorrage.DataProcessing;

public class Review {
    private int movieId;
    private String reviewId;
    private String author;
    private String content;

    public Review(String author, String content, int movieId, String reviewId) {
        this.author = author;
        this.content = content;
        this.movieId = movieId;
        this.reviewId = reviewId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
