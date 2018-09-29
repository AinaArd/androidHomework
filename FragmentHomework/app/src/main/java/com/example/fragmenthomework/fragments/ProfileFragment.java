package com.example.fragmenthomework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.fragmenthomework.EditDialog;
import com.example.fragmenthomework.Listener;
import com.example.fragmenthomework.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements Listener {

    TextView textViewLogin;
    TextView textViewEmail;
    private String login = "Here must be your login";
    private String email = "Here must be your email";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Button editButton = v.findViewById(R.id.btn_edit);
        textViewLogin = v.findViewById(R.id.tv_login);
        textViewEmail = v.findViewById(R.id.tv_email);

        textViewLogin.setText(login);
        textViewEmail.setText(email);

        editButton.setOnClickListener(v1 -> {
            EditDialog editDialog = new EditDialog();
            editDialog.show(getChildFragmentManager(), "dialog");
        });
        return v;
    }

    public void saveData(String login, String email) {
        textViewLogin.setText(login);
        textViewEmail.setText(email);
    }

    @Override
    public void mListener(String login, String email) {
        textViewLogin.setText(login);
        textViewEmail.setText(email);
    }
}
