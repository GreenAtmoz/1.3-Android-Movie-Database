package com.example.movieapp.Domain;

import java.io.Serializable;

public class MovieElements implements Serializable {

    private String filmTitel;
    private String description;
    private int rating;
    private String trailerLink;
    private String imageUrlW200;
    private String imageUrlW500;
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

    public String getImageUrlW200() {
        return imageUrlW200;
    }

    public void setImageUrlW200(String imageUrlW200) {
        this.imageUrlW200 = imageUrlW200;
    }

    public String getImageUrlW500() {
        return imageUrlW500;
    }

    public void setImageUrlW500(String imageUrlW500) {
        this.imageUrlW500 = imageUrlW500;
    }
}
