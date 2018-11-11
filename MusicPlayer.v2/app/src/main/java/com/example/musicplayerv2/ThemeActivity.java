package com.example.musicplayerv2;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class ThemeActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        addPreferencesFromResource(R.xml.preferences);

    }
}
