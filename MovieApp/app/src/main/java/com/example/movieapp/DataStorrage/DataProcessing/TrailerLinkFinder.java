package com.example.movieapp.DataStorrage.DataProcessing;

import android.os.AsyncTask;
import android.util.Log;
import com.example.movieapp.DataStorrage.NetworkConnection.NetworkUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrailerLinkFinder extends AsyncTask<String, Void, String>{
    public AsyncResponse asyncResponse = null;
    private int movieId;

    public TrailerLinkFinder(int movieId) {
        this.movieId = movieId;
    }
    @Override
    protected String doInBackground(String... strings) {
        String outputLink = "";
        String youtubeVideoKey = "";
        try {
            String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildTrailerURL(movieId));
            JSONObject object = new JSONObject(jsonResponseString);
            JSONArray results = object.getJSONArray("results");
            int i = 0;
            while (i < results.length()) {
                JSONObject result = results.getJSONObject(i);
                if ("Trailer".equals(result.getString("type"))) {
                    youtubeVideoKey = result.getString("key");
                    break;
                } else {
                    i++;
                }
            }
            outputLink = NetworkUtils.buildYoutubeUrlString(youtubeVideoKey);
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("TrailerLinkFinder", "doInBackground: " + outputLink);
        return outputLink;
    }

    @Override
    protected void onPostExecute(String s) {
        asyncResponse.processStringFinish(s);
    }
}
