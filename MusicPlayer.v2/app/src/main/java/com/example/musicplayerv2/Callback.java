package com.example.musicplayerv2;

import android.content.SharedPreferences;

/**
 * Created by ${Aina} on 11.11.2018.
 */
public interface Callback {
    void callback(int position);

    void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key);
}
