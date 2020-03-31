package com.example.movieapp.DataStorrage.DataProcessing;

import android.os.AsyncTask;
import android.util.Log;
import com.example.movieapp.DataStorrage.NetworkConnection.NetworkUtils;
import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class PopularDataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;
    private static final int aantalPaginas = 5; //het aantal pagina's met resultaten die worden weergegeven. Iedere pagina bevat 20 resultaten.

    public PopularDataProcessing(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        Log.d("PopularDataprocessing", "doInBackground");
        try {
            int page = 0;
            for (int j = 0; j < aantalPaginas; j++) {
                page++;
                String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildPopularUrl(page));
                JSONObject object = new JSONObject(jsonResponseString);
                JSONArray results = object.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject result = results.getJSONObject(i);
                    MovieElements element = new MovieElements();
                    element.setId(result.getInt("id"));
                    String title = result.getString("title");
                    if (title.isEmpty()){
                        title = "null";
                    }
                    element.setFilmTitel(title);
                    String description;
                    if (result.isNull("overview")){
                        description = "null";
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
                        date = "null";
                    }else{
                        date = result.getString("release_date");
                    }
                    if (date.isEmpty()){
                        date = "null";
                    }
                    element.setDate(date);
                    movieElements.add(element);
                    Log.d("PopularDataProcessing", "doInBackground: Title:" + element.getFilmTitel());
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
        Log.d("PopularDataProcessing", "onPostExecute: " + movieElements);
    }
}
