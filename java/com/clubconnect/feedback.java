package com.clubconnect;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {
        EditText nameEditText, emailEditText, feedbackEditText;
        Button submitButton;
        DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_feedback);

            databaseReference = FirebaseDatabase.getInstance().getReference("feedback");

            nameEditText = findViewById(R.id.fbname);
            emailEditText = findViewById(R.id.fbemail);
            feedbackEditText = findViewById(R.id.fbfb);
            submitButton = findViewById(R.id.submitfb);

            submitButton.setOnClickListener(v -> saveFeedback());
        }

        private void saveFeedback() {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String feedback = feedbackEditText.getText().toString().trim();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(feedback)) {
                // Generating a unique key for the feedback
                String feedbackId = databaseReference.push().getKey();

                // Creating a Feedback object with the provided data
                feedbackdata feedbackData = new feedbackdata(name, email, feedback);

                // Inserting the feedback data into the Firebase Realtime Database
                if (feedbackId != null) {
                    databaseReference.child(feedbackId).setValue(feedbackData)
                            .addOnSuccessListener(aVoid -> {
                                // Show a success message if the feedback is added successfully
                                Toast.makeText(feedback.this, "Feedback submitted successfully", Toast.LENGTH_SHORT).show();

                                // Navigate back to the main activity
                                startActivity(new Intent(feedback.this, MainActivity.class));
                                finish();
                            })
                            .addOnFailureListener(e -> {
                                // Show a failure message if there's an error adding the feedback
                                Toast.makeText(feedback.this, "Failed to submit feedback: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                } else {
                    // Show a failure message if feedbackId is null
                    Toast.makeText(feedback.this, "Failed to generate feedback ID", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        }
    }
