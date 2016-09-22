package pl.yahoo.pawelpiedel.movies.model.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> movies;
    @SerializedName("total_results")
    private int totalMovies;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getTotalMovies() {
        return totalMovies;
    }

    public void setTotalMovies(int totalMovies) {
        this.totalMovies = totalMovies;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}