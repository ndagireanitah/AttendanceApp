package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class TakeAttendance extends AppCompatActivity {

    private DatePicker datePicker;
    private Spinner sectorSpinner;
    private Spinner classSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        datePicker = findViewById(R.id.datePicker);
        sectorSpinner = findViewById(R.id.sectorSpinner);
        classSpinner = findViewById(R.id.classSpinner);

        // Set the DatePicker to display the current date
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(currentYear, currentMonth, currentDay, null);

        // Create an ArrayAdapter for the sector Spinner
        ArrayAdapter<CharSequence> sectorAdapter = ArrayAdapter.createFromResource(this, R.array.sector_names, android.R.layout.simple_spinner_item);
        sectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectorSpinner.setAdapter(sectorAdapter);

        // Set a default class adapter (e.g., Cambridge)
        String[] defaultClassesArray = getResources().getStringArray(R.array.cambridge_classes);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, defaultClassesArray);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);

        sectorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Depending on the selected sector, set the appropriate class names in the class spinner.
                String[] classesArray;
                if (position == 0) {
                    classesArray = getResources().getStringArray(R.array.cambridge_classes);
                } else {
                    classesArray = getResources().getStringArray(R.array.national_classes);
                }
                ArrayAdapter<String> classAdapter = new ArrayAdapter<>(TakeAttendance.this, android.R.layout.simple_spinner_item, classesArray);
                classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                classSpinner.setAdapter(classAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle when nothing is selected in the sector spinner.
            }
        });

        // Add the code to open the Student Registration Activity when the button is clicked
        Button studentRegistrationButton = findViewById(R.id.buttonStudentRegister);

        studentRegistrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Student Registration Activity when the button is clicked
                Intent intent = new Intent(TakeAttendance.this, RegisterStudentActivity.class);
                startActivity(intent);
            }
        });
    }
}
