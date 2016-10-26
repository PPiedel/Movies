package pl.yahoo.pawelpiedel.movies.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Pawel on 2016-10-26.
 */
public class Utility {

    public static boolean isNetworkConnection(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
