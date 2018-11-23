package com.example.musicplayerv2

import android.content.SharedPreferences

/**
 * Created by ${Aina} on 11.11.2018.
 */
interface Callback {
    fun exactSong(position: Int)
    fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String)
}
