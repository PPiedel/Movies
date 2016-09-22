package pl.yahoo.pawelpiedel.movies.model.images;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pawelpiedel on 22.09.16.
 */
public class Poster {

    @SerializedName("aspect_ratio")
    public Double aspectRatio;

    @SerializedName("file_path")
    public String filePath;

    @SerializedName("height")
    public Integer height;

    @SerializedName("iso_639_1")
    public String iso6391;

    @SerializedName("vote_average")
    public Integer voteAverage;

    @SerializedName("vote_count")
    public Integer voteCount;

    @SerializedName("width")
    public Integer width;

}
