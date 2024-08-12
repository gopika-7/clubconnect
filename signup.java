package com.clubconnect;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText nameEditText, numberEditText, categoryEditText, emailEditText, passwordEditText, category;
    Button signUpButton;
    private String[] type;
    DatabaseReference databaseReference;
     CheckBox showPasswordCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Get references to EditText fields and Firebase database
        category = findViewById(R.id.catt);

        // Create an ArrayAdapter using the string array and a default spinner layout


        nameEditText = findViewById(R.id.name);
        numberEditText = findViewById(R.id.number);
        categoryEditText = findViewById(R.id.catt);
        emailEditText = findViewById(R.id.signupEmail);
        passwordEditText = findViewById(R.id.signupPassword);
        signUpButton = findViewById(R.id.signupButton);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values from EditText fields
                String name = nameEditText.getText().toString().trim();
                String number = numberEditText.getText().toString().trim();
                String category = categoryEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate inputs here if needed

                // Create a User object
                com.clubconnect.User user = new User(name, number, category, email, password);

                // Push the user object to Firebase database
                String userId = databaseReference.push().getKey();
                assert userId != null;
                databaseReference.child(userId).setValue(user);
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView signupRedirectText = findViewById(R.id.loginRedirectText);
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to signup activity
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });
        showPasswordCheckBox = findViewById(R.id.checkBoxShowPassword);
        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Change password visibility based on checkbox state
                if (isChecked) {
                    // Show password
                    passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // Hide password
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                // Move cursor to the end of the text
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });
    }
}
