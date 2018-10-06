package com.example.fragmenthomework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ${Aina} on 01.10.2018.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ListViewHolder> {
    List<String> names;

    public GalleryAdapter(List<String> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public GalleryAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pic, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.ListViewHolder holder, int position) {
        holder.bindView(position);
        holder.itemView.setOnClickListener(v -> {
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public ListViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bindView(int position) {
            tvName.setText(names.get(0));
        }
    }
}
