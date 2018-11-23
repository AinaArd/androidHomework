package com.example.musicplayerv2

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

import java.util.ArrayList

/**
 * Created by ${Aina} on 30.10.2018.
 */
class MusicService : Service() {

    private lateinit  var songs: ArrayList<Song>
    private lateinit var mediaPlayer: MediaPlayer
    private var position: Int = 0
    private val musicBind = MusicBinder()
    private lateinit var callback: Callback

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    fun initMusicPlayer(callback: Callback, songs: ArrayList<Song>, position: Int) {
        this.callback = callback
        this.songs = songs
        this.position = position
        start()
    }

    private fun start() {
        mediaPlayer = MediaPlayer.create(this, songs[position].id)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener { playNext() }
    }

    override fun onBind(intent: Intent): IBinder? {
        return musicBind
    }

    override fun onUnbind(intent: Intent): Boolean {
        mediaPlayer.stop()
        mediaPlayer.release()
        return false
    }

    internal inner class MusicBinder : Binder() {
        val service: MusicService
            get() = this@MusicService
    }

    fun playNext() {
        position++
        position = if (position == songs.size) 0 else position
        callback.exactSong(position)
        mediaPlayer.release()
        start()
    }

    fun playPrev() {
        position--
        position = if (position == -1) songs.size - 1 else position
        callback.exactSong(position)
        mediaPlayer.release()
        start()
    }

    fun play() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        } else {
            mediaPlayer.start()
        }
    }

    fun stop() {
        mediaPlayer.release()
    }
}
