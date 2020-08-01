package norment.banebot.module.tmdb.data;

import com.google.gson.annotations.Expose;
import norment.banebot.module.tmdb.TmdbItem;

public class Movie extends TmdbItem {
    @Expose
    public MovieData data;
}
