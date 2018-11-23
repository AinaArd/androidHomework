package com.example.musicplayerv2

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SongAdapter(diffCallback: DiffUtil.ItemCallback<Song>, private val callback: Callback) : ListAdapter<Song, SongAdapter.SongHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song, parent, false)
        return SongHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SongHolder, position: Int) {
        viewHolder.id = position
        viewHolder.itemView.setOnClickListener { callback.exactSong(viewHolder.id) }
        viewHolder.tvName.text = getItem(position).name
        viewHolder.tvArtist.text = getItem(position).artist
    }

    inner class SongHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var id: Int = 0
        var tvName: TextView = view.findViewById(R.id.tv_name)
        var tvArtist: TextView = view.findViewById(R.id.tv_artist)
    }
}
