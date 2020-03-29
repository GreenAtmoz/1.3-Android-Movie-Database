package com.example.movieapp.DataStorrage;

import android.util.Log;

import com.example.movieapp.Language;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String mString_pictureUrlW500 = "https://image.tmdb.org/t/p/w500";
    private static final String mString_pictureUrlW200 = "https://image.tmdb.org/t/p/w200";
    private static final String English = "&language=en-US";
    private static final String Dutch = "&language=nl";
    public static Language language;
    public static final String apiKey = "018bccaff77c7e87b7a1ba9af79aed2c";
    private static String languageString;

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

    public static String buildImageUrlW500(String inputPath) {
//        Log.d("NetworkUtils", "buildImageUrlW500: ");
        String mUrl = null;
        try {
            mUrl = new String(mString_pictureUrlW500 + inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Log.d("NetworkUrl", "buildImageUrlW500: " + mUrl);
        return mUrl;
    }

    public static String buildImageUrlW200(String inputPath) {
//        Log.d("NetworkUtils", "buildImageUrlW200: ");
        String mUrl = null;
        try {
            mUrl = new String(mString_pictureUrlW200 + inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Log.d("NetworkUrl", "buildImageUrlW200: " + mUrl);
        return mUrl;
    }

    public static URL buildPopularUrl(int page) throws Exception{
        String base = "https://api.themoviedb.org/3/movie/popular?api_key=";
        String pageAddon = "&page=";
        URL output = new URL(base + apiKey + languageString + pageAddon + page);
        Log.d("NetworkUtils", "buildPopularUrlString: " + output);
        return output;
    }

    public static URL buildDateUrl(int page) throws Exception{
        String base = "https://api.themoviedb.org/3/discover/movie?api_key=";
        String pageAddon = "&page=";
        String sortBy = "&sort_by=primary_release_date.dsc";
        URL output = new URL(base + apiKey + languageString + sortBy + pageAddon + page);
        Log.d("NetworkUtils", "buildDaterUrlString: " + output);
        return output;
    }

    public static URL buildRatingUrl(int page) throws Exception{
        String base = "https://api.themoviedb.org/3/movie/popular?api_key=";
        String pageAddon = "&page=";
        URL output = new URL(base + apiKey + languageString + pageAddon + page);
        Log.d("NetworkUtils", "buildRatingUrlString: " + output);
        return output;
    }

    public static URL buildExpectedUrl(int page) throws Exception{
        String base = "https://api.themoviedb.org/3/movie/popular?api_key=";
        String pageAddon = "&page=";
        URL output = new URL(base + apiKey + languageString + pageAddon + page);
        Log.d("NetworkUtils", "buildExpectedUrlString: " + output);
        return output;
    }

    public static void checkLanguage(){
        if (Language.ENGLISH.equals(language)){
            languageString = English;
        }else if (Language.NEDERLANDS.equals(language)){
            languageString = Dutch;
        }
    }

}



