package com.example.musicplayerv2

import android.content.SharedPreferences
import android.preference.Preference
import android.preference.PreferenceActivity
import android.os.Bundle
import android.preference.PreferenceFragment
import android.preference.PreferenceManager

class ThemeActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
    }
}
