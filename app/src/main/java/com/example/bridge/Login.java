package com.example.bridge;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button btnSignIn;
    TextView tvSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        btnSignIn = findViewById(R.id.buttonLogin);
        tvSignUp = findViewById(R.id.textViewSignup);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(Login.this, "You are logged in.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, HomePageUI.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Login.this, "You are logged in", Toast.LENGTH_SHORT).show();
                }
            }
        };


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String emailId = email.getText().toString();
                String pwd = password.getText().toString();
                if (emailId.isEmpty()) {
                    email.setError("Please enter a valid email address");
                    email.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter a valid password");
                    password.requestFocus();
                } else if (emailId.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Login.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else if (!(emailId.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(emailId, pwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task <AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login Error. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intToHome = new Intent(Login.this, HomePageUI.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
