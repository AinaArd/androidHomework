package com.example.musicplayerv2

import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

class MainActivity : AppCompatActivity(), Callback, SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(ThemePicker.getTheme(applicationContext))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val songAdapter = SongAdapter(AppListDiffCallback(), this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_songs)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = songAdapter
        songAdapter.submitList(songs)
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun exactSong(position: Int) {
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        recreate()
    }

    companion object {

        val songs: ArrayList<Song>
            get() {
                val songs = ArrayList<Song>()
                songs.add(Song(R.raw.song_1, "First Song", "First Artist"))
                songs.add(Song(R.raw.song_2, "Second Song", "Second Artist"))
                songs.add(Song(R.raw.song_3, "Third Song", "Third Artist"))
                songs.add(Song(R.raw.song_4, "Fourth Song", "Fourth Artist"))
                songs.add(Song(R.raw.song_1, "Fifth Song", "Fifth Artist"))
                return songs
            }
    }
}
