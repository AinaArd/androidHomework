package com.example.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WakeUpActivity extends AppCompatActivity {

    TextView tvCongrats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up);
        tvCongrats = findViewById(R.id.tv_congrats);
    }
}
