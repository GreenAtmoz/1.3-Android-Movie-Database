package com.example.movieapp;

public class Movie {
    private String Title;
    private String year;
    private int Thumbnail;

    public Movie() {
    }

    public Movie(String title, String year, int thumbnail) {
        Title = title;
        this.year = year;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return year;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
