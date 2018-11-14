package com.example.musicplayerv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ${Aina} on 13.11.2018.
 */
public class ThemePicker {
    public static int getTheme(Context context) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String currentTheme = sharedPref.getString("themes", "First");
        int themeId ;
        switch (currentTheme) {
            case "first":
                themeId = R.style.first;
                break;
            case "second":
                themeId = R.style.second;
                break;
            case "third":
                themeId = R.style.third;
                break;
            default:
                themeId = R.style.default1;
        }
        return themeId;
    }
}
