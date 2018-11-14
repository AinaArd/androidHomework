package com.example.musicplayerv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Callback, SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(ThemePicker.getTheme(getApplicationContext()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SongAdapter songAdapter = new SongAdapter(new AppListDiffCallback(), this);
        RecyclerView recyclerView = findViewById(R.id.rv_songs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(songAdapter);
        songAdapter.submitList(getSongs());
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void exactSong(int position) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        recreate();
    }

    public static ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.raw.song_1, "First Song", "First Artist"));
        songs.add(new Song(R.raw.song_2, "Second Song", "Second Artist"));
        songs.add(new Song(R.raw.song_3, "Third Song", "Third Artist"));
        songs.add(new Song(R.raw.song_4, "Fourth Song", "Fourth Artist"));
        songs.add(new Song(R.raw.song_1, "Fifth Song", "Fifth Artist"));
        return songs;
    }
}
