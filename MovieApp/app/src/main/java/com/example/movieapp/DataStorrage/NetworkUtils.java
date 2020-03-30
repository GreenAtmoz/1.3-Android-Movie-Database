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
        String mUrl = null;
        try {
            mUrl = new String(mString_pictureUrlW500 + inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mUrl;
    }

    public static String buildImageUrlW200(String inputPath) {
        String mUrl = null;
        try {
            mUrl = new String(mString_pictureUrlW200 + inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mUrl;
    }

    public static URL buildPopularUrl(int page) throws Exception{
        checkLanguage();
        String base = "https://api.themoviedb.org/3/movie/popular?api_key=";
        String pageAddon = "&page=";
        URL output = new URL(base + apiKey + languageString + pageAddon + page);
        Log.d("NetworkUtils", "buildPopularUrlString: " + output);
        return output;
    }

    public static URL buildDateUrl(int page) throws Exception{
        checkLanguage();
        String base = "https://api.themoviedb.org/3/discover/movie?api_key=";
        String pageAddon = "&page=";
        String sortBy = "&sort_by=primary_release_date.dsc";
        URL output = new URL(base + apiKey + languageString + sortBy + pageAddon + page);
        Log.d("NetworkUtils", "buildDaterUrlString: " + output);
        return output;
    }

    public static URL buildRatingUrl(int page) throws Exception{
        checkLanguage();
        String base = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
        String pageAddon = "&page=";
        String output = base + apiKey + pageAddon + languageString + page;
        Log.d("NetworkUtils", "buildSearchUrl: " + output);
        return new URL(output);
    }

    public static URL buildExpectedUrl(int page) throws Exception{
        checkLanguage();
        String base = "https://api.themoviedb.org/3/movie/upcoming?api_key=";
        String pageAddon = "&page=";
        URL output = new URL(base + apiKey + languageString + pageAddon + page);
        Log.d("NetworkUtils", "buildExpectedUrlString: " + output);
        return output;
    }

    public static URL buildSearchUrl(String search, int page) throws Exception{
        checkLanguage();
        String base = "https://api.themoviedb.org/3/search/movie?api_key=";
        String query = "&query=";
        String pageAddon = "&page=";
        String output = base + apiKey + query + search + languageString + pageAddon + page;
        Log.d("NetworkUtils", "buildSearchUrl: " + output);
        return new URL(output);
    }

    public static URL buildTrailerURL(int movieId) throws Exception{
        checkLanguage();
        String base = "http://api.themoviedb.org/3/movie/";
        String query = "/videos?api_key=";
        Log.d("TrailerLinkFinder", "getApiURLString: is called");
        return new URL(base + movieId + query + apiKey + languageString);
    }

    public static String buildYoutubeUrlString(String videoKey) throws Exception{
        String youtubeBaseUrl = "https://www.youtube.com/embed/";
        String youtubeEndUrl = "?autoplay=1&vq=small";
        Log.d("TrailerLinkFinder", "getYoutubeUrlString: is called");
        return youtubeBaseUrl + videoKey + youtubeEndUrl;
    }

    public static URL buildReviewsUrl(int movieId, int page) throws Exception{
        checkLanguage();
        String base = "http://api.themoviedb.org/3/movie/";
        String query = "/reviews?api_key=";
        String pageAddon = "&page=";
        Log.d("TrailerLinkFinder", "getReviewsUrl: is called");
        return new URL(base + movieId + query + apiKey + languageString + pageAddon + page);
    }

    public static void checkLanguage(){
        if (Language.ENGLISH.equals(language)){
            languageString = English;
        }else if (Language.NEDERLANDS.equals(language)){
            languageString = Dutch;
        }
    }
}



