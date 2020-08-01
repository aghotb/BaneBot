package norment.banebot.module.tmdb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import norment.banebot.config.ReadConfig;
import norment.banebot.module.tmdb.data.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class TmdbUtil {
    private static final String ENDPOINT = "https://api.themoviedb.org/3/";
    private static final String SEARCH_MOVIE = ENDPOINT + "search/movie";
    private static final String SEARCH_PERSON = ENDPOINT + "search/person";
    private static final String SEARCH_MULTI = ENDPOINT + "search/multi";

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(ResultData.class, new ResultDataDeserializer())
            .registerTypeAdapter(MovieData.class, new MovieDataDeserializer())
            .create();

    public static Result search(SearchType searchType, String query) {
        String type = switch (searchType) {
            case MOVIE -> SEARCH_MOVIE;
            case PERSON -> SEARCH_PERSON;
            case MULTI -> SEARCH_MULTI;
        };

        ReadConfig cfg = new ReadConfig();
        String tmdbKey = cfg.properties.getProperty("tmdbKey");

        //parse query into URL format
        query = query.replaceAll("\\s", "%20");

        String url = type + "?api_key=" + tmdbKey + "&query=" + query;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();


        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (response == null) return null;
        System.out.println(response);

        String data = response.body();

        return gson.fromJson(response.body(), Result.class);
    }
}
