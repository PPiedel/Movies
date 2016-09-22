package pl.yahoo.pawelpiedel.movies.model.images;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawelpiedel on 22.09.16.
 */
public class MovieImageResponse {

    @SerializedName("id")
    public Integer id;

    @SerializedName("backdrops")
    public List<Backdrop> backdrops = new ArrayList<>();

    @SerializedName("posters")
    public List<Poster> posters = new ArrayList<>();

}