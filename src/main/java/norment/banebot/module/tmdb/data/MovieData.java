package norment.banebot.module.tmdb.data;

import com.google.gson.annotations.Expose;
import norment.banebot.module.tmdb.TmdbItem;

import java.util.List;

public class MovieData extends TmdbItem {
    @Expose
    public Double popularity;
    @Expose
    public Integer id;
    @Expose
    public Boolean video;
    @Expose
    public Integer vote_count;
    @Expose
    public Integer vote_average;
    @Expose
    public String title;
    @Expose
    public String release_date;
    @Expose
    public String original_language;
    @Expose
    public String original_title;
    @Expose
    public List<Integer> genre_ids;
    @Expose
    public String backdrop_path;
    @Expose
    public Boolean adult;
    @Expose
    public String overview;
    @Expose
    public String poster_path;
}