package com.clubconnect;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class event extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.buttonEvent);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.buttonEvent) {
                // Handle Home item click
                return true;
            } else if (item.getItemId() == R.id.buttonHome) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
                return true;
            } else if (item.getItemId() == R.id.buttonPost) {
                startActivity(new Intent(getApplicationContext(), post.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
                return true;
            } else if (item.getItemId() == R.id.buttonMyprofile) {
                startActivity(new Intent(getApplicationContext(), profile.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
                return true;
            }
            return false;
        });
    }
}
