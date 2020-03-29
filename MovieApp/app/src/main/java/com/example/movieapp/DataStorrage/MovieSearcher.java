package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import android.util.Log;
import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MovieSearcher extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;

    public MovieSearcher(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        Log.d("Dataprocessing", "doInBackground");
        try {
                int page = 0;
                int aantalPaginas = 1;
                for (int j = 0; j < aantalPaginas; j++) {
                    String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildPopularUrl(page));
                    JSONObject object = new JSONObject(jsonResponseString);
                    aantalPaginas = object.getInt("page");
                    JSONArray results = object.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        MovieElements element = new MovieElements();
                        element.setFilmTitel(result.getString("title"));
                        Log.d("MovieSearcher", "doInBackground: title: " + element.getFilmTitel());
                        element.setDescription(result.getString("overview"));
                        element.setRating(result.getInt("vote_average"));
                        element.setImageUrlW200(NetworkUtils.buildImageUrlW200(result.getString("poster_path")));
                        element.setImageUrlW500(NetworkUtils.buildImageUrlW500(result.getString("poster_path")));
                        element.setDate(result.getString("release_date"));
                        element.setId(result.getInt("id"));
                        movieElements.add(element);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieElements;
    }
}
