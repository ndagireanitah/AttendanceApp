package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class RegistrationActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEditText = findViewById(R.id.registrationNameEditText);
        emailEditText = findViewById(R.id.registrationEmailEditText);
        passwordEditText = findViewById(R.id.registrationPasswordEditText);
        registrationButton = findViewById(R.id.registrationButton);

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract user input
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Register the user using Firebase Authentication
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Registration was successful
                                    Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                                    // Redirect back to the login activity
                                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish(); // Close this activity
                                } else {
                                    // Registration failed
                                    if (task.getException() != null) {
                                        String errorMessage = task.getException().getMessage();
                                        Toast.makeText(RegistrationActivity.this, "Registration failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                                    } else {
                                        // Handle the case when getException() is null (shouldn't happen)
                                        Toast.makeText(RegistrationActivity.this, "Registration failed: Unknown error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
        });
    }}