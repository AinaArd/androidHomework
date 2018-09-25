package com.example.fragmenthomework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmenthomework.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends Fragment {


    public PhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photoragment, container, false);
        TextView fragmentName = v.findViewById(R.id.photo_frgm_name);
        return v;
    }

}
