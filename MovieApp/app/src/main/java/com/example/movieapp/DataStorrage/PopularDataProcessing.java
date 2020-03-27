package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import android.util.Log;

import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PopularDataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;
    private static final String mString_url = "https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1";
    private static final String apiKey = "018bccaff77c7e87b7a1ba9af79aed2c";

    public PopularDataProcessing(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        Log.d("Dataprocessing", "doInBackground");
        try {
            int page = 0;
            int counter = 0;
            for (int j = 0; j < 500; j++) {
                page++;
                String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildPopularUrlString(apiKey,page));
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
                    //element.setTrailerLink(attributes.getString(""));
                    movieElements.add(element);
//                    Log.e("PopularDataProcessing","doInBackground: " + i, new Exception() );
                    counter++;
                    Log.d(TAG, "doInBackground: " + counter);
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

    public ArrayList<MovieElements> getElements() {
        return movieElements;
    }
}
