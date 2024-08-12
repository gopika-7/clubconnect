package com.clubconnect;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class post extends AppCompatActivity {

    EditText postDescEditText, clubname;
    Button addPostButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("posts");

        // Initialize UI elements
        postDescEditText = findViewById(R.id.postdesc);
        clubname = findViewById(R.id.clubname);
        addPostButton = findViewById(R.id.addpostButton);

        // Set click listener for add post button
        addPostButton.setOnClickListener(v -> addPostToDatabase());

        // Initialize and handle bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.buttonPost);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Handle navigation item clicks
            if (item.getItemId() == R.id.buttonPost) {
                // Handle Home item click
                return true;}
                else if (item.getItemId() == R.id.buttonHome) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.buttonEvent) {
                startActivity(new Intent(getApplicationContext(), event.class));
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

    private void addPostToDatabase() {
        // Get data from UI elements
        String clubNameText = clubname.getText().toString().trim();
        String postDescText = postDescEditText.getText().toString().trim();

        // Check if club name and post description are not empty
        if (!clubNameText.isEmpty() && !postDescText.isEmpty()) {
            // Create a new Posts object with the retrieved data
            Posts post = new Posts(clubNameText, postDescText);

            // Push the Posts object to Firebase database
            String postId = databaseReference.push().getKey();
            assert postId != null;
            databaseReference.child(postId).setValue(post);
            Toast.makeText(post.this, "Activity added successfully", Toast.LENGTH_SHORT).show();

            // Navigate back to MainActivity

            // Pass the data to MainActivity2
            Intent intent = new Intent(post.this, MainActivity.class);
            intent.putExtra("clubName", clubNameText);
            intent.putExtra("postDesc", postDescText);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu1, menu);
        return true;
    }
}
