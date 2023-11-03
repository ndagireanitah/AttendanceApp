package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button attendanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the button
        attendanceButton = findViewById(R.id.attendanceBtn);

        // Set a click listener for the button
        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click event by navigating to the TakeAttendanceActivity
                Intent intent = new Intent(MainActivity.this, TakeAttendance.class);
                startActivity(intent);
            }
        });
    }
}


