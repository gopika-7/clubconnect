package com.clubconnect;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addevent extends AppCompatActivity {

    EditText eventNameEditText, eventDateTimeEditText, eventLocationEditText, eventDescriptionEditText;
    Button addEventButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);

        databaseReference = FirebaseDatabase.getInstance().getReference("staff-event");

        // Initialize UI elements
        eventNameEditText = findViewById(R.id.event_name);
        eventDateTimeEditText = findViewById(R.id.event_date);
        eventLocationEditText = findViewById(R.id.event_loc);
        eventDescriptionEditText = findViewById(R.id.event_desc);
        addEventButton = findViewById(R.id.AddEventButton);

        // Set click listener for add event button
        addEventButton.setOnClickListener(v -> {
            // Getting text from EditText fields
            String eventName = eventNameEditText.getText().toString().trim();
            String eventDateTime = eventDateTimeEditText.getText().toString().trim();
            String eventLocation = eventLocationEditText.getText().toString().trim();
            String eventDescription = eventDescriptionEditText.getText().toString().trim();

            // Checking if any field is empty
            if (TextUtils.isEmpty(eventName) || TextUtils.isEmpty(eventDateTime) || TextUtils.isEmpty(eventLocation) || TextUtils.isEmpty(eventDescription)) {
                Toast.makeText(addevent.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Adding event to Firebase database
                addEventToFirebase(eventName, eventDateTime, eventLocation, eventDescription);
            }
        });
    }

    private void addEventToFirebase(String eventName, String eventDateTime, String eventLocation, String eventDescription) {
        // Generating a unique key for the event
        String eventId = databaseReference.push().getKey();

        // Creating an Event object with the provided data
        EventHelper event = new EventHelper(eventName, eventDateTime, eventLocation, eventDescription);

        // Inserting the event data into the Firebase Realtime Database
        if (eventId != null) {
            databaseReference.child(eventId).setValue(event)
                    .addOnSuccessListener(aVoid -> {
                        // Show a success message if the event is added successfully
                        Toast.makeText(addevent.this, "Event added successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        // Show a failure message if there's an error adding the event
                        Toast.makeText(addevent.this, "Failed to add event: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        } else {
            // Show a failure message if eventId is null
            Toast.makeText(addevent.this, "Failed to generate event ID", Toast.LENGTH_SHORT).show();
        }
    }
}
