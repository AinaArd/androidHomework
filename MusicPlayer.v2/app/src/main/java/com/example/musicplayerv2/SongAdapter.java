package com.example.musicplayerv2;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SongAdapter extends ListAdapter<Song, SongAdapter.SongHolder> {

    private Callback callback;

    public SongAdapter(@NonNull DiffUtil.ItemCallback<Song> diffCallback, Callback callback) {
        super(diffCallback);
        this.callback = callback;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song, parent, false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SongHolder viewHolder, int position) {
        viewHolder.id = position;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.callback(viewHolder.id);
            }
        });
        viewHolder.tvName.setText(getItem(position).getName());
        viewHolder.tvArtist.setText(getItem(position).getArtist());
    }

    class SongHolder extends RecyclerView.ViewHolder {
        int id;
        TextView tvName;
        TextView tvArtist;
        View view;

        SongHolder(View itemView) {
            super(itemView);
            view = itemView;

            tvName = view.findViewById(R.id.tv_name);
            tvArtist = view.findViewById(R.id.tv_artist);

        }
    }
}
