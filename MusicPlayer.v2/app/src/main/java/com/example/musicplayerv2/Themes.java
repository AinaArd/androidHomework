package com.example.musicplayerv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ${Aina} on 11.11.2018.
 */
public class Themes {

    public static int getTheme(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String thisTheme = sp.getString("this", "current");
        int themeId = R.style.AppTheme;
        if (thisTheme.equals("1")) {
            themeId = R.style.first;
        } else if (thisTheme.equals("2")) {
            themeId = R.style.second;
        } else if (thisTheme.equals("3")) {
            themeId = R.style.third;
        }
        return themeId;
    }
}
