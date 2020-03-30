package com.example.movieapp.DataStorrage;

import com.example.movieapp.Language;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class NetworkUtilsTest {
    //Popular
    @Test
    void testBuildPopularUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildPopularUrl(page);

        if ((baseURLEnglish).equals(apiBuild)) {
            result = true;
        }

        assertTrue(result);
    }

    @Test
    void testBuildPopularUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildPopularUrl(page);

        if ((baseURLDutch).equals(apiBuild)) {
            result = true;
        }

        assertTrue(result);
    }

    //Date
    @Test
    void testBuildDateUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/discover/movie?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&sort_by=primary_release_date.dsc&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildDateUrl(page);

        if ((baseURLEnglish).equals(apiBuild)) {
            result = true;
        }

        assertTrue(result);
    }

    @Test
    void testBuildDateUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/discover/movie?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&sort_by=primary_release_date.dsc&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildDateUrl(page);

        if ((baseURLDutch).equals(apiBuild)) {
            result = true;
        }

        assertTrue(result);
    }

    //Rating
    @Test
    void testBuildRatingUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildRatingUrl(page);

        if ((baseURLEnglish).equals(apiBuild)) {
            result = true;
        }

        System.out.println(apiBuild);

        assertTrue(result);
    }

    @Test
    void testBuildRatingUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildRatingUrl(page);

        if ((baseURLDutch).equals(apiBuild)) {
            result = true;
        }

        System.out.println(apiBuild);

        assertTrue(result);
    }
}