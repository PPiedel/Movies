package pl.yahoo.pawelpiedel.movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import pl.yahoo.pawelpiedel.movies.R;
import pl.yahoo.pawelpiedel.movies.adapter.MoviesAdapter;
import pl.yahoo.pawelpiedel.movies.model.Movie;
import pl.yahoo.pawelpiedel.movies.utils.ScrollUtils;


public class MovieDetails extends AppCompatActivity{
    private Movie movie;
    private ScrollView mScrollView;
    private ActionMenuView amvMenu;
    private View imgContainer;
    private TextView reviewView;
    private ImageView movieImageView;
    private View mToolbarView;
    int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        Toolbar toolbar = setToolbar();

        movie = getMovieFromIntent();

        mScrollView = (ScrollView) findViewById(R.id.scroll);
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = mScrollView.getScrollY();

                int baseColor = getResources().getColor(R.color.colorPrimary);
                float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
                mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));

            }
        });

        imgContainer = findViewById(R.id.img_container);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        movieImageView = (ImageView) findViewById(R.id.movie_details_image);
        Glide.with(getApplicationContext()).load(MoviesAdapter.POSTER_BASE_URL+movie.getBackdropPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(movieImageView);


        setMovieTitle(toolbar);

        setToolbarBackgroundColor();

        amvMenu = (ActionMenuView) findViewById(R.id.amvDetailsMenu);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        setRatingBar(ratingBar);

        reviewView = (TextView) findViewById(R.id.review);
        setReviewText();


    }

    private void setRatingBar(RatingBar ratingBar) {
        int ratingStarsNumber = 5;
        ratingBar.setRating((Float.parseFloat(movie.getVoteAverage().toString()))/ ratingStarsNumber);
    }

    private void setMovieTitle(Toolbar toolbar) {
        TextView movieTitle = (TextView) toolbar.findViewById(R.id.details_movie_title);
        movieTitle.setText(movie.getTitle());
    }

    private Toolbar setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.movie_detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return toolbar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details,amvMenu.getMenu());
        return true;
    }

    private void setToolbarBackgroundColor() {
        mToolbarView = findViewById(R.id.movie_detail_toolbar);
        mToolbarView.setBackgroundColor(
                ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorPrimary)));
    }

    private void setReviewText() {
        reviewView.setText(movie.getOverview());
    }


    private Movie getMovieFromIntent() {
        Intent intent = getIntent();
        return intent.getExtras().getParcelable(MoviesAdapter.PARCELABLE_KEY);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}