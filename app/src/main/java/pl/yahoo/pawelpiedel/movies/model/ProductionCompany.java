package pl.yahoo.pawelpiedel.movies.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pawelpiedel on 22.09.16.
 */
public class ProductionCompany {

    @SerializedName("name")
    public String name;

    @SerializedName("id")
    public Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
