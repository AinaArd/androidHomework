package com.example.fragmenthomework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenthomework.GalleryAdapter;
import com.example.fragmenthomework.R;

import java.util.List;

public class GalleryFragment extends Fragment {
    RecyclerView recyclerView;
    List<String> names;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        names.add("aina");
        names.add("kolya");
        names.add("vova");
        names.add("nail");

        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = v.findViewById(R.id.recycleView);

        GalleryAdapter galleryAdapter = new GalleryAdapter(names);
        recyclerView.setAdapter(galleryAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return v;
    }
}
