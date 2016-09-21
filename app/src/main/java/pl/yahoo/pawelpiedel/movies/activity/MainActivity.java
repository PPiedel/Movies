package pl.yahoo.pawelpiedel.movies.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pl.yahoo.pawelpiedel.movies.R;
import pl.yahoo.pawelpiedel.movies.adapter.ViewPagerAdapter;
import pl.yahoo.pawelpiedel.movies.fragments.PopularMoviesFragment;
import pl.yahoo.pawelpiedel.movies.fragments.TopRatedMoviesFragment;
import pl.yahoo.pawelpiedel.movies.fragments.UpcomingMoviesFragment;


public class MainActivity extends AppCompatActivity {
    public static final String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    private ActionMenuView amvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        amvMenu = (ActionMenuView) toolbar.findViewById(R.id.amvMenu);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TopRatedMoviesFragment(), "TOP RATED");
        adapter.addFragment(new PopularMoviesFragment(), "POPULAR");
        adapter.addFragment(new UpcomingMoviesFragment(), "UPCOMING");
        viewPager.setAdapter(adapter);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, amvMenu.getMenu());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
