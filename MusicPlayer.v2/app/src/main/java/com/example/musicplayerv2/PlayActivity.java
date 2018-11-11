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
        SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs.registerOnSharedPreferenceChangeListener(this);
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer = null;
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menu1 = menu.add(0, 1, 0, "Preferences");
        Intent intent = new Intent(this, ThemeActivity.class);
        menu1.setIntent(intent);
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public void callback(int id) {
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
