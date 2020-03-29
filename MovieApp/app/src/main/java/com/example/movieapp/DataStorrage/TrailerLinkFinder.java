package com.example.movieapp.DataStorrage;

import android.os.AsyncTask;
import android.util.Log;

import com.example.movieapp.Domain.MovieElements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class TrailerLinkFinder extends AsyncTask<String, Void, String>{
    public AsyncResponse asyncResponse = null;
    private int movieId;
    private static final String startUrl = "http://api.themoviedb.org/3/movie/";
    private static final String endUrl = "/videos?api_key=";
    private static final String youtubeBaseUrl = "https://www.youtube.com/watch?v=";

    public TrailerLinkFinder(int movieId) {
        this.movieId = movieId;
    }

    @Override
    protected String doInBackground(String... strings) {
        String outputLink = "";
        try {
            String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(getApiURL());
            JSONObject object = new JSONObject(jsonResponseString);
            JSONArray results = object.getJSONArray("results");

            String youtubeVideoKey;
            while (true){
                int i = 0;
                JSONObject result = results.getJSONObject(i);
                if ("trailer".equals(result.getString("type"))){
                    Log.d("TrailerLinkFinder", "doInBackground: " + result.getString("type"));
                    youtubeVideoKey = result.getString("key");
                    Log.d("TrailerLinkFinder", "doInBackground: " + youtubeVideoKey);
                    break;
                }else {
                    i++;
                }
            }
            outputLink = getYoutubeUrlString(youtubeVideoKey);

        }catch (Exception e){
            e.printStackTrace();
        }

        return outputLink;
    }

    public URL getApiURL() throws Exception{
        Log.d("TrailerLinkFinder", "getApiURLString: is called");
        return new URL(startUrl + movieId + endUrl + NetworkUtils.apiKey);
    }

    public String getYoutubeUrlString(String videoKey) throws Exception{
        Log.d("TrailerLinkFinder", "getYoutubeUrlString: is called");
        return youtubeBaseUrl + videoKey;
    }
}
