package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import com.example.movieapp.Domain.MovieElements;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

public class DataProcessing extends AsyncTask<String, Void, ArrayList<MovieElements>> {
    private ArrayList<MovieElements> elements;
    public AsyncResponse asyncResponse = null;

    @Override
    protected ArrayList<MovieElements> doInBackground(String... strings) {
        elements = new ArrayList<>();
        try {
            String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());

            JSONObject object = new JSONObject(jsonResponseString);

            //creates an array with all the decorative elements in Breda (Features)
            JSONArray listOfDecorativeElementsInBreda = object.getJSONArray("features");

            for (int i = 0; i < listOfDecorativeElementsInBreda.length(); i++) {
                JSONObject decorativeElementObject = listOfDecorativeElementsInBreda.getJSONObject(i);
                JSONObject attributes = decorativeElementObject.getJSONObject("attributes");

                MovieElements element = new MovieElements();
                element.setFilmTitel(attributes.getString("FILMTITEL"));
                element.setDescription(attributes.getString("OMSCHRIJVING"));
                element.setRating(attributes.getString("BEOORDELING"));
                element.setReview(attributes.getString("RECENSIE"));
                element.setTrailerLink(attributes.getString("ONDERGROND"));
                element.setImageUrl(attributes.getString("PLAATJE"));
                element.setDate(attributes.getString("DATUM"));
                elements.add(element);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return elements;
    }

    @Override
    protected void onPostExecute(ArrayList<MovieElements> decorativeElements) {
        asyncResponse.processFinish(decorativeElements);
    }

    public ArrayList<MovieElements> getElements() {
        return elements;
    }
}
