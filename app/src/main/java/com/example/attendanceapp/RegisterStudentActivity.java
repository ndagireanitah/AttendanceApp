package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterStudentActivity extends AppCompatActivity {

    private EditText studentNameEditText;
    private EditText studentNumberEditText;
    private Spinner classStreamSpinner;
    private Spinner termSpinner;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        studentNameEditText = findViewById(R.id.editTextStudentName);
        studentNumberEditText = findViewById(R.id.editTextStudentNumber);
        classStreamSpinner = findViewById(R.id.classStreamSpinner);
        termSpinner = findViewById(R.id.termSpinner);
        registerButton = findViewById(R.id.buttonRegisterStudent);

        // Set up ArrayAdapter for spinners
        ArrayAdapter<CharSequence> classStreamAdapter = ArrayAdapter.createFromResource(this, R.array.class_streams, android.R.layout.simple_spinner_item);
        classStreamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classStreamSpinner.setAdapter(classStreamAdapter);

        ArrayAdapter<CharSequence> termAdapter = ArrayAdapter.createFromResource(this, R.array.terms, android.R.layout.simple_spinner_item);
        termAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        termSpinner.setAdapter(termAdapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the data from the form
                String studentName = studentNameEditText.getText().toString().trim();
                String studentNumber = studentNumberEditText.getText().toString().trim();
                String classStream = classStreamSpinner.getSelectedItem().toString();
                String term = termSpinner.getSelectedItem().toString();

                // Display a registration success message
                String message = "Student registration information: " +
                        "Name: " + studentName + ", Number: " + studentNumber +
                        ", Class Stream: " + classStream + ", Term: " + term;

                Toast.makeText(RegisterStudentActivity.this, message, Toast.LENGTH_SHORT).show();

                // Create an intent to navigate back to the "Take Attendance" activity
                Intent intent = new Intent(RegisterStudentActivity.this, TakeAttendance.class);
                startActivity(intent);
                finish(); // This finishes the current activity to prevent going back to it with the back button.
            }
        });
    }
}
