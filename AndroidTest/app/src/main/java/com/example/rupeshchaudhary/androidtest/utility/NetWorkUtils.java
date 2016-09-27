package com.example.rupeshchaudhary.androidtest.utility;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class NetWorkUtils {
    public static boolean checkIsNetworkAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
