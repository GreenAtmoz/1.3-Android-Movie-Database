package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import android.util.Log;

import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class DataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;

    public DataProcessing(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        Log.d("Dataprocessing", "doInBackground");
        try {
            String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());
//            String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1"));
            JSONObject object = new JSONObject(jsonResponseString);
            JSONArray results = object.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
//                JSONObject attributes = decorativeElementObject.getJSONObject("attributes");

                MovieElements element = new MovieElements();
                element.setFilmTitel(result.getString("title"));
                Log.d(TAG, "doInBackground: title: " + element.getFilmTitel());
                element.setDescription(result.getString("overview"));
                element.setRating(result.getInt("vote_average"));
                element.setImageUrl(result.getString("poster_path"));
                element.setDate(result.getString("release_date"));
                element.setId(result.getInt("id"));
                //element.setTrailerLink(attributes.getString(""));
                movieElements.add(element);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieElements;
    }

    @Override
    protected void onPostExecute(ArrayList<MovieElements> decorativeElements) {
        asyncResponse.processFinish(decorativeElements);
        Log.d(TAG, "onPostExecute: " + movieElements);
    }

    public ArrayList<MovieElements> getElements() {
        return movieElements;
    }
}
