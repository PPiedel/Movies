package pl.yahoo.pawelpiedel.movies.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pawelpiedel on 22.09.16.
 */
public class SpokenLanguage {

    @SerializedName("iso_639_1")
    public String iso6391;

    @SerializedName("name")
    public String name;

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
