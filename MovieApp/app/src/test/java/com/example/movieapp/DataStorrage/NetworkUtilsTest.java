package com.example.movieapp.DataStorrage;

import com.example.movieapp.DataStorrage.NetworkConnection.NetworkUtils;
import com.example.movieapp.Domain.Language;
import org.junit.jupiter.api.Test;;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.*;

class NetworkUtilsTest {
    //HTTPURL Test
//    @Test
//    void testHTTPURL() throws IOException, JSONException {
//        final URL baseURL = new URL("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
//        String expected = "{\"args\":{\"foo1\":\"bar1\",\"foo2\":\"bar2\"},\"headers\":{\"x-forwarded-proto\":\"https\",\"host\":\"postman-echo.com\",\"accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\",\"accept-encoding\":\"gzip, deflate, br\",\"accept-language\":\"nl-NL,nl;q=0.9,en-US;q=0.8,en;q=0.7\",\"cache-control\":\"max-age=0\",\"cookie\":\"sails.sid=s%3AqspCpyNzE9aum8iHdMenlaVjIG56tn_p.RBKIea42dfD5kVVNkuJ1WZexzWdyckQUBIl8HheqaTU\",\"if-none-match\":\"W/\\\"2a9-7M22SFOqQMUAZM9rl1lGLjNixOQ\\\"\",\"sec-fetch-dest\":\"document\",\"sec-fetch-mode\":\"navigate\",\"sec-fetch-site\":\"none\",\"sec-fetch-user\":\"?1\",\"upgrade-insecure-requests\":\"1\",\"user-agent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36\",\"x-forwarded-port\":\"443\"},\"url\":\"https://postman-echo.com/get?foo1=bar1&foo2=bar2\"}";
//
//        String result = NetworkUtils.getResponseFromHttpUrl(baseURL);
//
//        JSONObject jsonObjectExpected = new JSONObject(expected);
//        JSONObject jsonObjectResult = new JSONObject(result);
//
//        //JSONObject object = new JSONObject(jsonResponseString);
//        //JSONArray results = object.getJSONArray("results");
//
//        System.out.println(result);
//
//        assertEquals(expected, result);
//    }
    
    //Images
    @Test
    void testBuildImageUrlW500() throws Exception {
        final URL baseURLEnglish = new URL("https://image.tmdb.org/t/p/w500poster_path");

        URL apiBuild = new URL(NetworkUtils.buildImageUrlW500("poster_path"));

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildImageUrlW200() throws Exception {
        final URL baseURLEnglish = new URL("https://image.tmdb.org/t/p/w200poster_path");

        URL apiBuild = new URL(NetworkUtils.buildImageUrlW200("poster_path"));

        assertEquals(baseURLEnglish, apiBuild);
    }

    //Popular
    @Test
    void testBuildPopularUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildPopularUrl(page);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildPopularUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/movie/popular?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildPopularUrl(page);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Date
    @Test
    void testBuildDateUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/discover/movie?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&sort_by=primary_release_date.dsc&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildDateUrl(page);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildDateUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/discover/movie?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&sort_by=primary_release_date.dsc&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildDateUrl(page);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Rating
    @Test
    void testBuildRatingUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildRatingUrl(page);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildRatingUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/movie/top_rated?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildRatingUrl(page);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Expected
    @Test
    void testBuildExpectedUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/movie/upcoming?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildExpectedUrl(page);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildExpectedUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/movie/upcoming?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildExpectedUrl(page);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Search
    @Test
    void testBuildSearchUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("https://api.themoviedb.org/3/search/movie?api_key=018bccaff77c7e87b7a1ba9af79aed2c&query=Frozen&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildSearchUrl("Frozen", page);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildSearchUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("https://api.themoviedb.org/3/search/movie?api_key=018bccaff77c7e87b7a1ba9af79aed2c&query=Frozen&language=nl&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildSearchUrl("Frozen", page);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Trailer
    @Test
    void testBuildTrailerUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("http://api.themoviedb.org/3/movie/550/videos?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US");
        int movieId = 550;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildTrailerURL(movieId);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildTrailerUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("http://api.themoviedb.org/3/movie/550/videos?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl");
        int movieId = 550;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildTrailerURL(movieId);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Youtube
    @Test
    void testBuildYoutubeUrl() throws Exception {
        final String baseURL = "https://www.youtube.com/embed/mLCr_ng-s7w?autoplay=1&vq=small";
        int page = 1;
        boolean result = false;

        String apiBuild = NetworkUtils.buildYoutubeUrlString("mLCr_ng-s7w");

        assertEquals(baseURL, apiBuild);
    }

    //Reviews
    @Test
    void testBuildReviewsUrlEnglish() throws Exception {
        final URL baseURLEnglish = new URL("http://api.themoviedb.org/3/movie/550/reviews?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=en-US&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.ENGLISH;

        URL apiBuild = NetworkUtils.buildReviewsUrl(550, page);

        assertEquals(baseURLEnglish, apiBuild);
    }

    @Test
    void testBuildReviewsUrlDutch() throws Exception {
        final URL baseURLDutch = new URL("http://api.themoviedb.org/3/movie/550/reviews?api_key=018bccaff77c7e87b7a1ba9af79aed2c&language=nl&page=1");
        int page = 1;
        boolean result = false;
        NetworkUtils.language = Language.NEDERLANDS;

        URL apiBuild = NetworkUtils.buildReviewsUrl(550, page);

        assertEquals(baseURLDutch, apiBuild);
    }

    //Language
    @Test
    void testLanguageEnglish() {
        NetworkUtils.language = Language.ENGLISH;

        NetworkUtils.checkLanguage();

        assertEquals(Language.ENGLISH, NetworkUtils.language);
    }

    @Test
    void testLanguageDutch() {
        NetworkUtils.language = Language.NEDERLANDS;

        NetworkUtils.checkLanguage();

        assertEquals(Language.NEDERLANDS, NetworkUtils.language);
    }
}