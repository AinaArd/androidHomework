package com.example.musicplayerv2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.MediaController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback, SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SongAdapter songAdapter = new SongAdapter(new AppListDiffCallback(), this);
        RecyclerView recyclerView = findViewById(R.id.rv_songs);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(songAdapter);
        songAdapter.submitList(getSongs());

        SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void callback(int position) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menu1 = menu.add(0, 1, 0, "Preferences");
        Intent intent = new Intent(this, ThemeActivity.class);
        menu1.setIntent(intent);
        return super.onCreateOptionsMenu(menu);
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
