package com.example.onlinecampusapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonDataStructures;
    private Button buttonMobileDevelopment;
    private Button buttonWebDevelopment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        buttonDataStructures = findViewById(R.id.buttonDataStructures);
        buttonMobileDevelopment = findViewById(R.id.buttonMobileDevelopment);
        buttonWebDevelopment = findViewById(R.id.buttonWebDevelopment);

        // Set click listeners for the course buttons
        buttonDataStructures.setOnClickListener(v -> openCourseDataStructures());
        buttonMobileDevelopment.setOnClickListener(v -> openCourseMobileDevelopment());
        buttonWebDevelopment.setOnClickListener(v -> openCourseWebDevelopment());
    }

    // Method to open CourseDataStructures activity
    private void openCourseDataStructures() {
        Intent intent = new Intent(MainActivity.this, CourseDataStructures.class);
        startActivity(intent);
    }

    // Method to open CourseMobileDevelopment activity
    private void openCourseMobileDevelopment() {
        Intent intent = new Intent(MainActivity.this, CourseMobilDevelopment.class);
        startActivity(intent);
    }

    // Method to open CourseWebDevelopment activity
    private void openCourseWebDevelopment() {
        Intent intent = new Intent(MainActivity.this, CourseWebDevelopment.class);
        startActivity(intent);
    }
}
