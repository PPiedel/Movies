package pl.yahoo.pawelpiedel.movies.model.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

    @SerializedName("adult")
    public Boolean adult;

    @SerializedName("backdrop_path")
    public String backdropPath;

    @SerializedName("budget")
    public Integer budget;

    @SerializedName("genres")
    public List<Genre> genres = new ArrayList<Genre>();

    @SerializedName("homepage")
    public String homepage;

    @SerializedName("id")
    public Integer id;

    @SerializedName("imdb_id")
    public String imdbId;

    @SerializedName("original_language")
    public String originalLanguage;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("overview")
    public String overview;

    @SerializedName("popularity")
    public Double popularity;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("production_companies")
    public List<ProductionCompany> productionCompanies = new ArrayList<ProductionCompany>();

    @SerializedName("production_countries")
    public List<ProductionCountry> productionCountries = new ArrayList<ProductionCountry>();

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("revenue")
    public Integer revenue;

    @SerializedName("runtime")
    public Integer runtime;

    @SerializedName("spoken_languages")
    public List<SpokenLanguage> spokenLanguages = new ArrayList<SpokenLanguage>();

    @SerializedName("status")
    public String status;

    @SerializedName("tagline")
    public String tagline;

    @SerializedName("title")
    public String title;

    @SerializedName("video")
    public Boolean video;

    @SerializedName("vote_average")
    public Double voteAverage;

    @SerializedName("vote_count")
    public Integer voteCount;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }


    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    protected Movie(Parcel in) {
        byte adultVal = in.readByte();
        adult = adultVal == 0x02 ? null : adultVal != 0x00;
        backdropPath = in.readString();
        budget = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            genres = new ArrayList<Genre>();
            in.readList(genres, Genre.class.getClassLoader());
        } else {
            genres = null;
        }
        homepage = in.readString();
        id = in.readByte() == 0x00 ? null : in.readInt();
        imdbId = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        overview = in.readString();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        posterPath = in.readString();
        if (in.readByte() == 0x01) {
            productionCompanies = new ArrayList<ProductionCompany>();
            in.readList(productionCompanies, ProductionCompany.class.getClassLoader());
        } else {
            productionCompanies = null;
        }
        if (in.readByte() == 0x01) {
            productionCountries = new ArrayList<ProductionCountry>();
            in.readList(productionCountries, ProductionCountry.class.getClassLoader());
        } else {
            productionCountries = null;
        }
        releaseDate = in.readString();
        revenue = in.readByte() == 0x00 ? null : in.readInt();
        runtime = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            spokenLanguages = new ArrayList<SpokenLanguage>();
            in.readList(spokenLanguages, SpokenLanguage.class.getClassLoader());
        } else {
            spokenLanguages = null;
        }
        status = in.readString();
        tagline = in.readString();
        title = in.readString();
        byte videoVal = in.readByte();
        video = videoVal == 0x02 ? null : videoVal != 0x00;
        voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
        voteCount = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (adult == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (adult ? 0x01 : 0x00));
        }
        dest.writeString(backdropPath);
        if (budget == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(budget);
        }
        if (genres == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genres);
        }
        dest.writeString(homepage);
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(imdbId);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeString(overview);
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        dest.writeString(posterPath);
        if (productionCompanies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(productionCompanies);
        }
        if (productionCountries == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(productionCountries);
        }
        dest.writeString(releaseDate);
        if (revenue == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(revenue);
        }
        if (runtime == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(runtime);
        }
        if (spokenLanguages == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(spokenLanguages);
        }
        dest.writeString(status);
        dest.writeString(tagline);
        dest.writeString(title);
        if (video == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (video ? 0x01 : 0x00));
        }
        if (voteAverage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(voteAverage);
        }
        if (voteCount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(voteCount);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public String toString() {
        return "Movie{" +
                "adult=" + adult +
                ", backdropPath='" + backdropPath + '\'' +
                ", budget=" + budget +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", posterPath='" + posterPath + '\'' +
                ", productionCompanies=" + productionCompanies +
                ", productionCountries=" + productionCountries +
                ", releaseDate='" + releaseDate + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spokenLanguages=" + spokenLanguages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (!getAdult().equals(movie.getAdult())) return false;
        if (!getBackdropPath().equals(movie.getBackdropPath())) return false;
        if (!getBudget().equals(movie.getBudget())) return false;
        if (!getGenres().equals(movie.getGenres())) return false;
        if (!getHomepage().equals(movie.getHomepage())) return false;
        if (!getId().equals(movie.getId())) return false;
        if (!getImdbId().equals(movie.getImdbId())) return false;
        if (!getOriginalLanguage().equals(movie.getOriginalLanguage())) return false;
        if (!getOriginalTitle().equals(movie.getOriginalTitle())) return false;
        if (!getOverview().equals(movie.getOverview())) return false;
        if (!getPopularity().equals(movie.getPopularity())) return false;
        if (!getPosterPath().equals(movie.getPosterPath())) return false;
        if (!getProductionCompanies().equals(movie.getProductionCompanies())) return false;
        if (!getProductionCountries().equals(movie.getProductionCountries())) return false;
        if (!getReleaseDate().equals(movie.getReleaseDate())) return false;
        if (!getRevenue().equals(movie.getRevenue())) return false;
        if (!getRuntime().equals(movie.getRuntime())) return false;
        if (!getSpokenLanguages().equals(movie.getSpokenLanguages())) return false;
        if (!getStatus().equals(movie.getStatus())) return false;
        if (!getTagline().equals(movie.getTagline())) return false;
        if (!getTitle().equals(movie.getTitle())) return false;
        if (!getVideo().equals(movie.getVideo())) return false;
        if (!getVoteAverage().equals(movie.getVoteAverage())) return false;
        return getVoteCount().equals(movie.getVoteCount());

    }

    @Override
    public int hashCode() {
        int result = getAdult().hashCode();
        result = 31 * result + getBackdropPath().hashCode();
        result = 31 * result + getBudget().hashCode();
        result = 31 * result + getGenres().hashCode();
        result = 31 * result + getHomepage().hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getImdbId().hashCode();
        result = 31 * result + getOriginalLanguage().hashCode();
        result = 31 * result + getOriginalTitle().hashCode();
        result = 31 * result + getOverview().hashCode();
        result = 31 * result + getPopularity().hashCode();
        result = 31 * result + getPosterPath().hashCode();
        result = 31 * result + getProductionCompanies().hashCode();
        result = 31 * result + getProductionCountries().hashCode();
        result = 31 * result + getReleaseDate().hashCode();
        result = 31 * result + getRevenue().hashCode();
        result = 31 * result + getRuntime().hashCode();
        result = 31 * result + getSpokenLanguages().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getTagline().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getVideo().hashCode();
        result = 31 * result + getVoteAverage().hashCode();
        result = 31 * result + getVoteCount().hashCode();
        return result;
    }
}


