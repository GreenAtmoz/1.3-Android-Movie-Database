package com.example.movieapp.DataStorrage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String mString_url = "place json string here";

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
