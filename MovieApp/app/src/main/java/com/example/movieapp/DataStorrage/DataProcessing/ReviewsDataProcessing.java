package com.example.movieapp.DataStorrage.DataProcessing;//package com.example.movieapp.DataStorrage.DataProcessing;

import android.os.AsyncTask;
import com.example.movieapp.DataStorrage.NetworkConnection.NetworkUtils;
import com.example.movieapp.Domain.Review;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class ReviewsDataProcessing extends AsyncTask<String, Void, ArrayList<Review>> {
    public AsyncResponse asyncResponse = null;
    private int movieId;

    public ReviewsDataProcessing(int movieId) {
        this.movieId = movieId;
    }

    @Override
    protected ArrayList<Review> doInBackground(String... strings) {
        ArrayList<Review> output = new ArrayList<>();
        try {
            int page = 1;
            int aantalpaginas = 1;
            for (int i = 0; i <= aantalpaginas; i++) {
                String jsonResponseString = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildReviewsUrl(movieId, page));
                JSONObject object = new JSONObject(jsonResponseString);
                aantalpaginas = object.getInt("total_pages");
                JSONArray results = object.getJSONArray("results");
                for (int j = 0; j < results.length(); j++) {
                    JSONObject result;
                    String author;
                    String content;
                    String reviewId;
                    if (results.isNull(j)) {
                        continue;
                    } else {
                        result = results.getJSONObject(j);
                        if (result.isNull("author")) {
                            author = "null";
                        } else {
                            author = result.getString("author");
                        }
                        if (result.isNull("content")) {
                            content = "null";
                        } else {
                            content = result.getString("content");
                        }
                        if (result.isNull("id")) {
                            reviewId = "null";
                        } else {
                            reviewId = result.getString("id");
                        }
                        Review review = new Review(author, content, movieId, reviewId);
                        output.add(review);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    protected void onPostExecute(ArrayList<Review> output) {
        asyncResponse.processArrayStringsFinish(output);
    }
}
