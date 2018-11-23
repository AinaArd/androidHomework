package com.example.musicplayerv2

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.SharedPreferences
import android.os.IBinder
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayActivity : AppCompatActivity(), Callback, SharedPreferences.OnSharedPreferenceChangeListener, ServiceConnection {

    private lateinit var playPic: ImageView
    private lateinit var prev: Button
    private lateinit var next: Button
    private lateinit var play: Button
    private lateinit var change: Button
    private lateinit var nameOfSong: TextView
    private lateinit var artist: TextView
    private var position: Int = 0
    private lateinit var musicService: MusicService
    private var songs = MainActivity.songs

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(ThemePicker.getTheme(applicationContext))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        playPic = findViewById(R.id.iv_play)
        prev = findViewById(R.id.btn_prev)
        next = findViewById(R.id.btn_next)
        play = findViewById(R.id.btn_play)
        change = findViewById(R.id.btn_settings)
        nameOfSong = findViewById(R.id.tv_name)
        artist = findViewById(R.id.tv_artist)
        position = intent.getIntExtra("position", 0)

        prev.setOnClickListener {
            position--
            position = if (position == -1) songs.size - 1 else position
            musicService.playPrev()
        }

        next.setOnClickListener {
            position++
            position = if (position == songs.size) 0 else position
            musicService.playNext()
        }

        play.setOnClickListener { musicService.play() }
        updatePlayingSong()

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.registerOnSharedPreferenceChangeListener(this)

        val intent = Intent(this, MusicService::class.java)
        startService(intent)
        bindService(intent, this, Context.BIND_AUTO_CREATE)

        change.setOnClickListener {
            val intent = Intent(applicationContext, ThemeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        musicService.stop()
        super.onDestroy()
    }

    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        val binder = service as MusicService.MusicBinder
        musicService = binder.service
        musicService.initMusicPlayer(this, songs, position)
    }

    override fun onServiceDisconnected(name: ComponentName) {
        unbindService(this)
    }

    @SuppressLint("ResourceType")
    override fun exactSong(position: Int) {
        this.position = position
        updatePlayingSong()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        recreate()
    }

    private fun updatePlayingSong() {
        nameOfSong.text = songs[position].name
        artist.text = songs[position].artist
    }
}
