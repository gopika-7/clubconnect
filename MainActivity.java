package com.clubconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.buttonHome);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.buttonHome) {
                // Handle Home item click
                return true;
            } else if (item.getItemId() == R.id.buttonEvent) {
                startActivity(new Intent(getApplicationContext(), event.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.buttonPost) {
                startActivity(new Intent(getApplicationContext(), post.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.buttonMyprofile) {
                startActivity(new Intent(getApplicationContext(), profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu1, menu);
        return true;
    }
}
