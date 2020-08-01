package norment.banebot.module.tmdb.data;

import com.google.gson.annotations.Expose;
import norment.banebot.module.tmdb.TmdbItem;

import java.util.List;

public class ResultData {
    @Expose
    public Integer page;
    @Expose
    public Integer total_results;
    @Expose
    public Integer total_pages;
    @Expose
    public List<? extends TmdbItem> results;
}
