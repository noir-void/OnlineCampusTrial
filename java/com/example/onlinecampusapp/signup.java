package com.example.onlinecampusapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private Button buttonSignup;

    private FirebaseAuth signupAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignup = findViewById(R.id.buttonSignUp);

        signupAuth = FirebaseAuth.getInstance();

        buttonSignup.setOnClickListener(v -> signupUser());
    }


    private void signupUser(){

        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        signupAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                this, task -> {

                    if (task.isSuccessful()){
                        Toast.makeText(this, "You have been signedup", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signup.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(this, "Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}