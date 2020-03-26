package com.example.movieapp.Domain;

import java.io.Serializable;

public class MovieElements implements Serializable {

    private String filmTitel;
    private String description;
    private int rating;
    private String trailerLink;
    private String imageUrl;
    private String date;
    private int id;

    public MovieElements() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setRating(int rating) {
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public String getTrailerLink() {
        return trailerLink;
    }
}
