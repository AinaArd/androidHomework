package com.example.musicplayerv2

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by ${Aina} on 11.11.2018.
 */
object Themes {

    fun getTheme(context: Context): Int {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        val thisTheme = sp.getString("this", "current")
        var themeId = R.style.AppTheme
        when (thisTheme) {
            "First" -> themeId = R.style.first
            "Second" -> themeId = R.style.second
            "Third" -> themeId = R.style.third
        }
        return themeId
    }
}
