package com.clubconnect;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    TextView signupRedirectText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get references to EditText fields and login button
        emailEditText = findViewById(R.id.loginEmail);
        passwordEditText = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        signupRedirectText = findViewById(R.id.signupRedirectText);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get email and password entered by the user
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Check if email and password are not empty
                if (TextUtils.isEmpty(email)) {
                    // Email is empty, show a toast message
                    Toast.makeText(getApplicationContext(), "Enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    // Password is empty, show a toast message
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check for valid email and password combinations
                if (email.equals("user@example.com") && password.equals("password")) {
                    // Email and password are correct for user, navigate to MainActivity
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close the login activity to prevent the user from coming back with the back button
                } else if (email.equals("staff@gmail.com") && password.equals("123")) {
                    // Email and password are correct for staff, navigate to MainActivity2
                    Intent intent = new Intent(login.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                } else if (email.equals("gopika@gmail.com") && password.equals("777")) {
                    // Email and password are correct for gopika, navigate to MainActivity
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Email or password is incorrect, show a toast message
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for the signup redirect text
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to signup activity
                startActivity(new Intent(login.this, signup.class));
            }
        });
    }
}
