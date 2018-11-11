package com.example.musicplayerv2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by ${Aina} on 30.10.2018.
 */
public class MusicService extends Service {

    private ArrayList<Song> songs;
    private MediaPlayer mediaPlayer;
    private int position;
    private IBinder musicBind = new MusicBinder();
    private Callback callback;

    @Override
    public void onDestroy() {
        stopForeground(true);
    }

    public void initMusicPlayer(Callback callback, ArrayList<Song> songs, int position) {
        this.callback = callback;
        this.songs = songs;
        this.position = position;
        start();
    }

    private void start() {
        mediaPlayer = MediaPlayer.create(this, songs.get(position).getId());
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playNext();
            }
        });
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.stop();
        mediaPlayer.release();
        return false;
    }

    class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    public void playNext() {
        position++;
        position = position == songs.size() ? 0 : position;
        callback.callback(position);
        start();
    }

    public void playPrev() {
        position--;
        position = position == -1 ? songs.size() - 1 : position;
        callback.callback(position);
        start();
    }

    public void play() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        } else {
            mediaPlayer.start();
        }
    }

    public void stop() {
        mediaPlayer.release();
    }
}
