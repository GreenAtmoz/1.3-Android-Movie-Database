package com.example.movieapp.DataStorrage;

import com.example.movieapp.Language;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class NetworkUtilsTest {

    @Test
    void testBuildPopularUrl() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&page=1");
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");

        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildPopularUrl(page);

        if ((baseURLEnglish).equals(apiBuild)) {
            result = true;
        }

        System.out.println(apiBuild);

        assertTrue(result);
    }
}