package pl.yahoo.pawelpiedel.movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import butterknife.BindView;
import butterknife.ButterKnife;
import pl.yahoo.pawelpiedel.movies.R;
import pl.yahoo.pawelpiedel.movies.adapter.MoviesAdapter;
import pl.yahoo.pawelpiedel.movies.model.Movie;
import pl.yahoo.pawelpiedel.movies.utils.ScrollUtils;


public class MovieDetails extends AppCompatActivity{
    private Movie movie;
    private int mParallaxImageHeight;

    @BindView(R.id.scroll) ScrollView mScrollView;
    @BindView(R.id.movie_detail_toolbar) Toolbar toolbar;
    @BindView(R.id.amvDetailsMenu) ActionMenuView amvMenu;
    @BindView(R.id.review) TextView reviewView;
    @BindView(R.id.movie_details_image) ImageView movieImageView;
    @BindView(R.id.ratingBar) RatingBar ratingBar;
    @BindView(R.id.details_movie_title) TextView movieTitle;
    @BindView(R.id.release_date) TextView releaseDateTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        ButterKnife.bind(this);

        setToolbar();

        movie = getMovieFromIntentExtras();

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = mScrollView.getScrollY();

                int baseColor = getResources().getColor(R.color.colorPrimary);
                float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
                toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));

            }
        });


        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        Glide.with(getApplicationContext()).load(MoviesAdapter.POSTER_BASE_URL+movie.getBackdropPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(movieImageView);


        setMovieTitle();

        setToolbarBackgroundColor();

        setReleaseDate();

        setRatingBar();

        setReviewText();


    }

    private void setReleaseDate() {
        releaseDateTextView.setText(movie.getReleaseDate());
    }

    private void setRatingBar() {
        int ratingStarsNumber = 5;
        ratingBar.setRating((Float.parseFloat(movie.getVoteAverage().toString()))/ ratingStarsNumber);
    }

    private void setMovieTitle() {
        movieTitle.setText(movie.getTitle());
    }

    private Toolbar setToolbar() {
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
        toolbar.setBackgroundColor(
                ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorPrimary)));
    }

    private void setReviewText() {
        reviewView.setText(movie.getOverview());
    }


    private Movie getMovieFromIntentExtras() {
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