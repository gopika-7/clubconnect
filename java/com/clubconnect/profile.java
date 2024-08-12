package com.clubconnect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class profile extends AppCompatActivity {
    Button feedbackButton, clubDetailsButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        feedbackButton = findViewById(R.id.FeedbackButton);
        clubDetailsButton = findViewById(R.id.clubdetailbutton);
        logoutButton = findViewById(R.id.logoutButton);

        feedbackButton.setOnClickListener(v -> startActivity(new Intent(profile.this, feedback.class)));

        clubDetailsButton.setOnClickListener(v -> startActivity(new Intent(profile.this, clubdetails.class)));

        logoutButton.setOnClickListener(v -> {
            startActivity(new Intent(profile.this, login.class));
            finish();
        });
    }
       }
