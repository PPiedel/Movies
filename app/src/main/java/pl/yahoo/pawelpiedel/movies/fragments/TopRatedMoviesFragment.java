package pl.yahoo.pawelpiedel.movies.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

/**
 * Created by pawelpiedel on 27.08.16.
 */
public class TopRatedMoviesFragment extends Fragment {
    private static final String LOG_TAG = TopRatedMoviesFragment.class.getSimpleName();

    private List<Movie> movies = new ArrayList<>(60);
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerView;
    private int currentPage = 1;


    public TopRatedMoviesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_rated_fragment_layout,container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_top_rated);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
        final Call<MovieResponse> movieResponseCall = apiService.getTopRatedMovies(MainActivity.API_KEY,page);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d(LOG_TAG,""+response.code());
                Log.d(LOG_TAG, movieResponseCall.request().toString());
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
                showAlertDialog();
            }
        });

    }

    public void showAlertDialog(){
        // Display message in dialog box if you have not internet connection
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(getString(R.string.no_internet_connection));
        alertDialogBuilder.setMessage(getString(R.string.please_check_your_internet_connection));

        Toast.makeText(getActivity(), getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show();
        alertDialogBuilder.setPositiveButton(getString(R.string.refresh), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
