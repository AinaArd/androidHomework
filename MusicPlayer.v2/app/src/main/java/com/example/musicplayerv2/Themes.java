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
        switch (thisTheme) {
            case "First":
                themeId = R.style.first;
                break;
            case "Second":
                themeId = R.style.second;
                break;
            case "Third":
                themeId = R.style.third;
                break;
        }
        return themeId;
    }
}
