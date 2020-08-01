package norment.banebot.module.tmdb.data;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

public class MovieDataDeserializer implements JsonDeserializer<MovieData> {
    @Override
    public MovieData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        Double popularity = null;
        if (jsonObject.get("popularity") != null) popularity = jsonObject.get("popularity").getAsDouble();

        Integer id = null;
        if (jsonObject.get("id") != null) id = jsonObject.get("id").getAsInt();

        Boolean video = null;
        if (jsonObject.get("video") != null) video = jsonObject.get("video").getAsBoolean();

        Integer vote_count = null;
        if (jsonObject.get("vote_count") != null) vote_count = jsonObject.get("vote_count").getAsInt();

        Integer vote_average = null;
        if (jsonObject.get("vote_average") != null) vote_average = jsonObject.get("vote_average").getAsInt();

        String title = null;
        if (jsonObject.get("title") != null) title = jsonObject.get("title").getAsString();

        String release_date = null;
        if (jsonObject.get("release_date") != null) release_date = jsonObject.get("release_date").getAsString();

        String original_language = null;
        if (jsonObject.get("original_language") != null)
            original_language = jsonObject.get("original_language").getAsString();

        String original_title = null;
        if (jsonObject.get("original_title") != null) original_title = jsonObject.get("original_title").getAsString();

        JsonElement genres = null;
        if (jsonObject.get("genre_ids") != null) genres = jsonObject.get("genre_ids");
        List<Integer> genre_ids = null;
        if (genres != null && !(genres instanceof JsonPrimitive)) {
            genre_ids = context.deserialize(jsonObject.get("genre_ids"), Integer.class);
        }

        String backdrop_path = null;
        if (jsonObject.get("backdrop_path") != null) backdrop_path = jsonObject.get("backdrop_path").getAsString();

        Boolean adult = null;
        if (jsonObject.get("adult") != null) adult = jsonObject.get("adult").getAsBoolean();

        String overview = null;
        if (jsonObject.get("overview") != null) overview = jsonObject.get("overview").getAsString();

        String poster_path = null;
        if (jsonObject.get("poster_path") != null) poster_path = jsonObject.get("poster_path").getAsString();

        MovieData movieData = new MovieData();
        movieData.popularity = popularity;
        movieData.id = id;
        movieData.video = video;
        movieData.vote_count = vote_count;
        movieData.vote_average = vote_average;
        movieData.title = title;
        movieData.release_date = release_date;
        movieData.original_language = original_language;
        movieData.original_title = original_title;
        movieData.genre_ids = genre_ids;
        movieData.backdrop_path = backdrop_path;
        movieData.adult = adult;
        movieData.overview = overview;
        movieData.poster_path = poster_path;

        return movieData;
    }
}