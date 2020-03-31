package com.example.movieapp.DataStorrage.DataProcessing;

import android.os.AsyncTask;
import android.util.Log;
import com.example.movieapp.DataStorrage.NetworkConnection.NetworkUtils;
import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class MovieSearcher extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;
    private String search;

    public MovieSearcher(ArrayList<MovieElements> movieElements, String search) {
        this.movieElements = movieElements;
        this.search = search;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        NetworkUtils.checkLanguage();
        Log.d("Dataprocessing", "doInBackground");
        try {
                int page = 0;
                int aantalPaginas = 1;
                for (int j = 0; j < aantalPaginas; j++) {
                    page++;
                    String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildSearchUrl(search, page));
                    assert jsonResponseString != null;
                    JSONObject object = new JSONObject(jsonResponseString);
                    aantalPaginas = object.getInt("page");
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
                        } else {
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
        Log.d("MovieSearcher", "onPostExecute: " + movieElements);
    }
}
