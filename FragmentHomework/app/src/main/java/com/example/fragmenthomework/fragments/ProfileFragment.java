package com.example.fragmenthomework.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.fragmenthomework.EditDialog;
import com.example.fragmenthomework.DataTransmitter;
import com.example.fragmenthomework.R;

public class ProfileFragment extends Fragment implements DataTransmitter {
    TextView tvLogin;
    TextView tvEmail;
    private String login = "Here must be your login";
    private String email = "Here must be your email";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Button editButton = v.findViewById(R.id.btn_edit);
        tvLogin = v.findViewById(R.id.tv_login);
        tvEmail = v.findViewById(R.id.tv_email);

        tvLogin.setText(login);
        tvEmail.setText(email);

        editButton.setOnClickListener(v1 -> {
            EditDialog editDialog = new EditDialog();
            editDialog.show(getChildFragmentManager(), "dialog");
        });
        return v;
    }

    public void saveData(String login, String email) {
        tvLogin.setText(login);
        tvEmail.setText(email);
    }

    @Override
    public void transmitter(String login, String email) {
        tvLogin.setText(login);
        tvEmail.setText(email);
    }
}
