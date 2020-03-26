package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

public class DataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    public AsyncResponse asyncResponse = null;
    private ArrayList<MovieElements> movieElements;

    public DataProcessing(ArrayList<MovieElements> movieElements) {
        this.movieElements = movieElements;
    }

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        try {
            String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());

            JSONObject object = new JSONObject(jsonResponseString);

            JSONArray listOfDecorativeElementsInBreda = object.getJSONArray("features");

            for (int i = 0; i < listOfDecorativeElementsInBreda.length(); i++) {
                JSONObject decorativeElementObject = listOfDecorativeElementsInBreda.getJSONObject(i);
                JSONObject attributes = decorativeElementObject.getJSONObject("attributes");

                MovieElements element = new MovieElements();
                element.setFilmTitel(attributes.getString("title"));
                element.setDescription(attributes.getString("overview"));
                element.setRating(attributes.getInt("vote_average"));
                element.setImageUrl(attributes.getString("poster_path"));
                element.setDate(attributes.getString("release_date"));
                element.setId(attributes.getInt("id"));
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
    }

    public ArrayList<MovieElements> getElements() {
        return movieElements;
    }
}
