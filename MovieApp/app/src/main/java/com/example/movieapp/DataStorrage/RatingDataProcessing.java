package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import android.util.Log;

import com.example.movieapp.Domain.MovieElements;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class RatingDataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;
    private static final int aantalPaginas = 5; //het aantal pagina's met resultaten die worden weergegeven. Iedere pagina bevat 20 resultaten.

    public RatingDataProcessing(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        Log.d("Dataprocessing", "doInBackground");
        try {
            int page = 0;
            for (int j = 0; j < aantalPaginas; j++) {
                page++;
                String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildRatingUrl(page));
                JSONObject object = new JSONObject(jsonResponseString);
                JSONArray results = object.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject result = results.getJSONObject(i);
                    MovieElements element = new MovieElements();
                    element.setFilmTitel(result.getString("title"));
                    Log.d(TAG, "doInBackground: title: " + element.getFilmTitel());
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

    @Override
    protected void onPostExecute(ArrayList<MovieElements> decorativeElements) {
        asyncResponse.processFinish(decorativeElements);
        Log.d(TAG, "onPostExecute: " + movieElements);
    }
}
