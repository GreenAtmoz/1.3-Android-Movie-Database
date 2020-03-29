package com.example.movieapp.DataStorrage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String mString_pictureUrlW500 = "https://image.tmdb.org/t/p/w500";
    private static final String mString_pictureUrlW200 = "https://image.tmdb.org/t/p/w200";
    private static final String language = "&language=en-US";
    public static final String apiKey = "018bccaff77c7e87b7a1ba9af79aed2c";

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream inputStream = urlConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            String input = null;
            if (hasInput) {
                input = scanner.next();
                return input;
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static URL buildUrl(String mString_url) {
        Log.d("NetworkUtils", "buildUrl: ");
        URL mUrl = null;
        try {
            mUrl = new URL(mString_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.d("NetworkUrl", "buildUrl: " + mUrl);
        return mUrl;
    }

    public static String buildImageUrlW500(String inputPath) {
        Log.d("NetworkUtils", "buildImageUrlW500: ");
        String mUrl = null;
        try {
            mUrl = new String(mString_pictureUrlW500 + inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("NetworkUrl", "buildImageUrlW500: " + mUrl);
        return mUrl;
    }

    public static String buildImageUrlW200(String inputPath) {
        Log.d("NetworkUtils", "buildImageUrlW200: ");
        String mUrl = null;
        try {
            mUrl = new String(mString_pictureUrlW200 + inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("NetworkUrl", "buildImageUrlW200: " + mUrl);
        return mUrl;
    }

    public static URL buildPopularUrl(int page) throws Exception{
        String base = "https://api.themoviedb.org/3/movie/popular?api_key=";
        String pageAddon = "&page=";
        URL output = new URL(base + apiKey + language + pageAddon + page);
        Log.d("NetworkUtils", "buildPopularUrlString: " + output);
        return output;
    }

}



