package com.example.movieapp.DataStorrage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String mString_url = "https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1";

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
        }finally {
            urlConnection.disconnect();
        }
    }

    public static URL buildUrl(){
        URL mUrl = null;
        try {
            mUrl = new URL(mString_url);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return mUrl;
    }
}
