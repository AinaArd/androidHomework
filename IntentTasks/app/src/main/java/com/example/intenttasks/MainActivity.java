package com.example.intenttasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView email;
    TextView name;
    TextView phoneNumber;
    ImageView profilePic;
    Button editButton;
    Button sendButton;

    private static final int REQUEST_ID = 1;
    private static final int EDIT_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);

        profilePic = findViewById(R.id.profilePic);
        editButton = findViewById(R.id.buttonEdit);
        sendButton = findViewById(R.id.sendButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String send = email.getText().toString() + name.getText().toString() + phoneNumber.getText().toString();
                Intent intentSend = new Intent(Intent.ACTION_SEND);
                intentSend.putExtra(Intent.EXTRA_TEXT, send);
                intentSend.setType("text/plain");

                if (intentSend.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intentSend, REQUEST_ID);
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDIT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String filledEmail = data.getStringExtra("email");
                String filledName = data.getStringExtra("name");
                String filledNumber = data.getStringExtra("number");

                email.setText(filledEmail);
                name.setText(filledName);
                phoneNumber.setText(filledNumber);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_ID) {
            if (resultCode == RESULT_OK) {
                String filledEmail = data.getStringExtra("email");
                String filledName = data.getStringExtra("name");
                String filledNumber = data.getStringExtra("number");

                email.setText(filledEmail);
                name.setText(filledName);
                phoneNumber.setText(filledNumber);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
