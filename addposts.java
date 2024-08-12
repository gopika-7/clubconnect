package com.clubconnect;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addposts extends AppCompatActivity {

    EditText guestEditText, numberStudentEditText,  postDescEditText;
    Button addPostButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addposts);

        databaseReference = FirebaseDatabase.getInstance().getReference("staff post");

        // Initialize UI elements
        guestEditText = findViewById(R.id.guest);
        numberStudentEditText = findViewById(R.id.numberstudent);
        postDescEditText = findViewById(R.id.postdescs);
        addPostButton = findViewById(R.id.addpostButton);

        // Set click listener for add post button
        addPostButton.setOnClickListener(v -> {
            // Getting text from EditText fields
            String guest = guestEditText.getText().toString().trim();
            String numberStudent = numberStudentEditText.getText().toString().trim();
            String postDescription = postDescEditText.getText().toString().trim();

            // Checking if any field is empty
            if (TextUtils.isEmpty(guest) || TextUtils.isEmpty(numberStudent) || TextUtils.isEmpty(postDescription)) {
                Toast.makeText(addposts.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Adding post to Firebase database
                addPostToFirebase(guest, numberStudent,  postDescription);
            }
        });
    }

    private void addPostToFirebase(String guest, String numberStudent, String postDescription) {
        // Generating a unique key for the post
        String postId = databaseReference.push().getKey();

        // Creating a Post object with the provided data
        Posts post = new Posts(guest, numberStudent,  postDescription);

        // Inserting the post data into the Firebase Realtime Database
        if (postId != null) {
            databaseReference.child(postId).setValue(post)
                    .addOnSuccessListener(aVoid -> {
                        // Show a success message if the post is added successfully
                        Toast.makeText(addposts.this, "Post added successfully", Toast.LENGTH_SHORT).show();
                        // Clear EditText fields after successful addition

                    })
                    .addOnFailureListener(e -> {
                        // Show a failure message if there's an error adding the post
                        Toast.makeText(addposts.this, "Failed to add post: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        } else {
            // Show a failure message if postId is null
            Toast.makeText(addposts.this, "Failed to generate post ID", Toast.LENGTH_SHORT).show();
        }
    }
}
