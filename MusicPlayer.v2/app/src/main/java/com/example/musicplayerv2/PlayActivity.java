package com.example.musicplayerv2;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity implements Callback, SharedPreferences.OnSharedPreferenceChangeListener, ServiceConnection {

    ImageView playPic;
    Button prev;
    Button next;
    Button play;
    Button change;
    TextView nameOfSong;
    TextView artist;
    int position;
    MusicService mediaPlayer;
    ArrayList<Song> songs = MainActivity.getSongs();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        playPic = findViewById(R.id.iv_play);
        prev = findViewById(R.id.btn_prev);
        next = findViewById(R.id.btn_next);
        play = findViewById(R.id.btn_play);
        change = findViewById(R.id.btn_settings);
        nameOfSong = findViewById(R.id.tv_name);
        artist = findViewById(R.id.tv_artist);
        position = getIntent().getIntExtra("position", 0);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                position = position == -1 ? songs.size() - 1 : position;
                mediaPlayer.playPrev();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                position = position == songs.size() ? 0 : position;
                mediaPlayer.playNext();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.play();
            }
        });
        updatePlayingSong();

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String currentTheme = sharedPref.getString("current_theme", "First");
        int themeId;
        switch (currentTheme) {
            case "First":
                themeId = R.style.first;
                break;
            case "Second":
                themeId = R.style.second;
                break;
            case "Third":
                themeId = R.style.third;
                break;
            default:
                themeId = R.style.first;
        }
        setTheme(themeId);


        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, this, Context.BIND_AUTO_CREATE);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThemeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer = null;
        super.onDestroy();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        MusicService.MusicBinder binder = (MusicService.MusicBinder) service;
        mediaPlayer = binder.getService();
        mediaPlayer.initMusicPlayer(this, songs, position);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        unbindService(this);
    }

    @SuppressLint("ResourceType")
    @Override
    public void exactSong(int id) {
        position = id;
        updatePlayingSong();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        recreate();
    }

    private void updatePlayingSong() {
        nameOfSong.setText(songs.get(position).getName());
        artist.setText(songs.get(position).getArtist());
    }
}
