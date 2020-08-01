package norment.banebot.module.tmdb.data;

import com.google.gson.*;
import norment.banebot.module.tmdb.TmdbItem;

import java.lang.reflect.Type;
import java.util.List;

public class ResultDataDeserializer implements JsonDeserializer<ResultData> {
    @Override
    public ResultData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        Integer page = null;
        if (jsonObject.get("page") != null) page = jsonObject.get("page").getAsInt();

        Integer total_results = null;
        if (jsonObject.get("total_results") != null) total_results = jsonObject.get("total_results").getAsInt();

        Integer total_pages = null;
        if (jsonObject.get("total_pages") != null) total_pages = jsonObject.get("total_pages").getAsInt();

        JsonElement res = null;
        if (jsonObject.get("results") != null) res = jsonObject.get("results");
        List<? extends TmdbItem> results = null;
        if (res != null && !(res instanceof JsonPrimitive)) {
            results = context.deserialize(jsonObject.get("results"), TmdbItem.class);
        }

        ResultData resultData = new ResultData();
        resultData.page = page;
        resultData.total_results = total_results;
        resultData.total_pages = total_pages;
        resultData.results = results;

        return resultData;
    }
}
