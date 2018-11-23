package com.example.musicplayerv2

import android.support.v7.util.DiffUtil

/**
 * Created by ${Aina} on 11.11.2018.
 */
internal class AppListDiffCallback : DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean = oldItem.artist == newItem.artist
}
