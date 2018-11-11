package com.example.musicplayerv2;

import android.support.v7.util.DiffUtil;

/**
 * Created by ${Aina} on 11.11.2018.
 */
class AppListDiffCallback extends DiffUtil.ItemCallback<Song> {
    @Override
    public boolean areItemsTheSame(Song oldItem, Song newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(Song oldItem, Song newItem) {
        return oldItem.getArtist().equals(newItem.getArtist());
    }
}
