package com.example.movieapp.DataStorrage.DataProcessing;

import android.os.AsyncTask;
import android.util.Log;

import com.example.movieapp.DataStorrage.AsyncResponse;
import com.example.movieapp.DataStorrage.NetworkUtils;
import com.example.movieapp.Domain.MovieElements;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class DateDataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;
    private static final int aantalPaginas = 5; //het aantal pagina's met resultaten die worden weergegeven. Iedere pagina bevat 20 resultaten.

    public DateDataProcessing(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        NetworkUtils.checkLanguage();
        Log.d("DateDataprocessing", "doInBackground");
        try {
            int page = 0;
            for (int j = 0; j < aantalPaginas; j++) {
                page++;
                String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildDateUrl(page));
                JSONObject object = new JSONObject(jsonResponseString);
                JSONArray results = object.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject result = results.getJSONObject(i);
                    MovieElements element = new MovieElements();
                    element.setId(result.getInt("id"));
                    String title = result.getString("title");
                    if (title.isEmpty()){
                        title = "-";
                    }
                    element.setFilmTitel(title);
                    String description;
                    if (result.isNull("overview")){
                        description = "";
                    }else {
                        description = result.getString("overview");
                    }
                    element.setDescription(description);
                    Double rating = result.getDouble("vote_average");
                    element.setRating(rating);
                    element.setImageUrlW200(NetworkUtils.buildImageUrlW200(result.getString("poster_path")));
                    element.setImageUrlW500(NetworkUtils.buildImageUrlW500(result.getString("poster_path")));

                    String date;
                    if (result.isNull("release_date")){
                        date = "0000-00-00";
                    }else {
                        date = result.getString("release_date");
                    }
                    element.setDate(date);
                    movieElements.add(element);
                    Log.d(TAG, "doInBackground: Title:" + element.getFilmTitel());
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
