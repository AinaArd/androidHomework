package com.example.musicplayerv2

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by ${Aina} on 13.11.2018.
 */
object ThemePicker {
    fun getTheme(context: Context): Int {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val currentTheme = sharedPref.getString("themes", "First")
        return when (currentTheme) {
            "first" -> R.style.first
            "second" -> R.style.second
            "third" -> R.style.third
            else -> R.style.default1
        }
    }
}
