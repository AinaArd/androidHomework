package com.example.userslist.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.userslist.R;

public class Main2Activity extends AppCompatActivity implements MyCallback {
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        description = findViewById(R.id.tv_descr);
        Bundle b = getIntent().getExtras();
        String info = (String) b.get("info");
        description.setText(info);
    }

    @Override
    public void callBack(String info) {
        description.setText(info);
    }
}