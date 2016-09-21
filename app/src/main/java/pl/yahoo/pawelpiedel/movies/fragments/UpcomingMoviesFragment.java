package pl.yahoo.pawelpiedel.movies.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.yahoo.pawelpiedel.movies.R;

/**
 * Created by pawelpiedel on 27.08.16.
 */
public class UpcomingMoviesFragment extends Fragment {
    public UpcomingMoviesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.upcoming_fragment_layout,container, false);
    }
}
