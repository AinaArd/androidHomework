package com.example.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTimeMin;
    EditText etTimeSec;
    Button buttonSet;
    Button buttonCancel;
    TextView tvTimeLeft;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#c62828")));

        etTimeMin = findViewById(R.id.et_time_minutes);
        etTimeSec = findViewById(R.id.et_time_sec);
        tvTimeLeft = findViewById(R.id.tv_time_left);
        buttonSet = findViewById(R.id.btn_set);
        buttonCancel = findViewById(R.id.btn_cancel);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelTimer();
                tvTimeLeft.setText("");
            }
        });

        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
    }

    private void cancelTimer() {
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this, "You've cancelled", Toast.LENGTH_LONG).show();
        timer.cancel();
    }

    private void startTimer() {
        long timeOnTimer = Integer.parseInt(etTimeMin.getText().toString()) * 60000 +
                Integer.parseInt(etTimeSec.getText().toString()) * 1000;
        startTimer(timeOnTimer);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intentTimer = new Intent(this, Alert.class);
        pendingIntent = PendingIntent.getBroadcast(this, 555, intentTimer, PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeOnTimer, pendingIntent);
    }

    private void startTimer(final long timeOnTimer) {
        timer = new CountDownTimer(timeOnTimer, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimeLeft.setText("Left: " + millisUntilFinished / 60000 + "min" + (millisUntilFinished % 60000) / 1000 + "sec");
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Time has left." + "\n" + "Would you like to set up new alarm?", Toast.LENGTH_LONG)
                        .show();
            }
        }
                .start();
    }
}
