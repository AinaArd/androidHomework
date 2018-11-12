package com.example.musicplayerv2;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class ThemeActivity extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        /*SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String currentTheme = sharedPref.getString("current_theme", "First");
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
        setTheme(themeId);*/
    }
}
