package pl.yahoo.pawelpiedel.movies.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pl.yahoo.pawelpiedel.movies.R;
import pl.yahoo.pawelpiedel.movies.activity.DividerItemDecoration;
import pl.yahoo.pawelpiedel.movies.activity.MainActivity;
import pl.yahoo.pawelpiedel.movies.activity.MovieDetails;
import pl.yahoo.pawelpiedel.movies.adapter.MoviesAdapter;
import pl.yahoo.pawelpiedel.movies.adapter.OnItemClickListener;
import pl.yahoo.pawelpiedel.movies.model.movies.Movie;
import pl.yahoo.pawelpiedel.movies.model.movies.MovieResponse;
import pl.yahoo.pawelpiedel.movies.rest.ApiClient;
import pl.yahoo.pawelpiedel.movies.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMoviesFragment extends Fragment {
    private static final String LOG_TAG = PopularMoviesFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<Movie> movies = new ArrayList<>(60);
    private MoviesAdapter moviesAdapter;
    private int currentPage = 1;


    public PopularMoviesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.popular_movies_fragment_layout,container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view_popular);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((GridLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                Log.d(LOG_TAG,"onLoadMore method reached");
                currentPage = page ;
                loadMovies(currentPage+1);

            }
        });

        loadMovies(currentPage);

        moviesAdapter = new MoviesAdapter(getContext(), movies );
        moviesAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent movieDetailsIntent = new Intent(getContext(),MovieDetails.class);
                movieDetailsIntent.putExtra("movie",movies.get(position));
                startActivity(movieDetailsIntent);
            }
        });

        recyclerView.setAdapter(moviesAdapter);
    }

    public void loadMovies(int page){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        final Call<MovieResponse> movieResponseCall = apiService.getPopularMovies(MainActivity.API_KEY,page);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d(LOG_TAG,""+response.code());
                Log.d(LOG_TAG,"Total pages : " + response.body().getTotalPages());
                Log.d(LOG_TAG,"Actual page : " + response.body().getPage());
                Log.d(LOG_TAG,"Total movies : " + response.body().getTotalMovies());

                movies.addAll(response.body().getMovies()) ;
                Log.d(LOG_TAG, "Total loaded movies: " + movies.size() );

                moviesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e(LOG_TAG,t.toString());
            }
        });

    }
}
