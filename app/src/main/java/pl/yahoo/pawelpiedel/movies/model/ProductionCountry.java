package pl.yahoo.pawelpiedel.movies.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pawelpiedel on 22.09.16.
 */
public class ProductionCountry {

    @SerializedName("iso_3166_1")
    public String iso31661;

    @SerializedName("name")
    public String name;

    public String getIso31661() {
        return iso31661;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
