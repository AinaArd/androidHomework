package com.example.intenttasks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    TextView emailEdit;
    TextView nameEdit;
    TextView phoneNumberEdit;
    ImageView profilePicEdit;
    Button confirmButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailEdit = findViewById(R.id.emailEdit);
        nameEdit = findViewById(R.id.nameEdit);
        phoneNumberEdit = findViewById(R.id.phoneNumberEdit);
        profilePicEdit = findViewById(R.id.profilePic);
        confirmButton = findViewById(R.id.confirmButton);
        cancelButton = findViewById(R.id.cancelButton);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailEdit.getText().toString() != null && nameEdit.getText().toString() != null && phoneNumberEdit.getText().toString() != null) {
                    Intent intentPost = new Intent();
                    intentPost.putExtra("email", emailEdit.getText().toString());
                    intentPost.putExtra("name", nameEdit.getText().toString());
                    intentPost.putExtra("number", phoneNumberEdit.getText().toString());
                    setResult(RESULT_OK, intentPost);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Fill in all the gaps", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}
