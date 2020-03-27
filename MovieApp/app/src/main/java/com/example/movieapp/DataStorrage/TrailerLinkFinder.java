package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;

import com.example.movieapp.Domain.MovieElements;

import java.util.ArrayList;

public class TrailerLinkFinder extends AsyncTask<String, Void, String>{
    private int movieId;

    public TrailerLinkFinder(int movieId) {
        this.movieId = movieId;
    }

    @Override
    protected String doInBackground(String... strings) {

        return null;
    }
}
