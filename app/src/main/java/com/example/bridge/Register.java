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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText email, password, fullname;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        fullname = findViewById(R.id.editTextFullName);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        btnSignUp = findViewById(R.id.buttonRegister);
        tvSignIn = findViewById(R.id.textViewSignin);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = email.getText().toString().trim();
                String pwd = password.getText().toString().trim();

                if (emailId.isEmpty()) {
                    email.setError("Please enter a valid email address");
                    email.requestFocus();
                }
                else if (pwd.isEmpty() || pwd.length() < 6) {
                    password.setError("Please enter a valid password");
                    password.requestFocus();
                }
                else if (emailId.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(Register.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else if (!(emailId.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(emailId, pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Register.this, "Can't sign up. Try again.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Register.this, "Sign up successful.", Toast.LENGTH_SHORT).show();
                                String userID = mFirebaseAuth.getCurrentUser().getUid();
                                DatabaseReference currentUser = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);
                                String full = fullname.getText().toString().trim();
                                Map newPost  =  new HashMap();
                                newPost.put("name", full);
                                currentUser.setValue(newPost);
                                startActivity(new Intent(Register.this, HomePageUI.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });
    }
}