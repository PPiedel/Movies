package pl.yahoo.pawelpiedel.movies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import pl.yahoo.pawelpiedel.movies.R;
import pl.yahoo.pawelpiedel.movies.model.Movie;

/**
 * Created by pawelpiedel on 21.08.16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    public static final String PARCELABLE_KEY = "movie";
    public static final String POSTER_BASE_URL = "http://image.tmdb.org/t/p/w500/";

    private static final String LOG_TAG = MoviesAdapter.class.getSimpleName();
    private List<Movie> movies;
    private Context context;
    private OnItemClickListener clickListener;



    public MoviesAdapter(Context context, List<Movie> moviesList )  {
        this.context = context;
        this.movies = moviesList;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Movie movie = movies.get(position);

        holder.movieTitle.setText(movie.getTitle());
        Log.d(LOG_TAG,"Poster url = " + POSTER_BASE_URL+movie.getBackdropPath());
        Glide.with(context).load(POSTER_BASE_URL+movie.getPosterPath())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .override(166,187)
                .into(holder.moviePoster);


    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView moviePoster;
        TextView movieTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);

            moviePoster.setOnClickListener(this);
            movieTitle.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(itemView,getAdapterPosition());
        }

    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


}
