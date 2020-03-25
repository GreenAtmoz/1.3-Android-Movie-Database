package com.example.movieapp.Domain;

import java.io.Serializable;

public class MovieElements implements Serializable {

    private String filmTitel;
    private String description;
    private String rating;
    private String review;
    private String trailerLink;
    private String imageUrl;
    private String date;

    public MovieElements() {
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setFilmTitel(String filmTitel) {
        this.filmTitel = filmTitel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getFilmTitel() {
        return filmTitel;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public String getTrailerLink() {
        return trailerLink;
    }
}
