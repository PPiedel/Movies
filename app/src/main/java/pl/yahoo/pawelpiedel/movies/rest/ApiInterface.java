package pl.yahoo.pawelpiedel.movies.rest;

import pl.yahoo.pawelpiedel.movies.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    String API_KEY_PARAM = "api_key";
    String MOVIE_ID_PARAM = "id";
    String PAGE_PARAM = "page";

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query(API_KEY_PARAM) String apiKey, @Query(PAGE_PARAM) int page);

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query(API_KEY_PARAM) String apiKey, @Query(PAGE_PARAM) int page);

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query(API_KEY_PARAM) String apiKey, @Query(PAGE_PARAM) int page);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path(MOVIE_ID_PARAM) int id, @Query(API_KEY_PARAM) String apiKey);

}