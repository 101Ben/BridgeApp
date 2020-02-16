package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

        private EditText editText;
        Button btnLogIn;
        Button btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                editText = (EditText)findViewById(R.id.editText);
                btnLogIn = findViewById(R.id.buttonLogin);
                btnSignUp = findViewById(R.id.buttonSignup);

                btnLogIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent launchLogin = new Intent(getApplicationContext(), Login.class);
                                startActivity(launchLogin);
                                finish();
                        }
                });

                btnSignUp.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                                Intent launchSignup = new Intent(getApplicationContext(), Register.class);
                                startActivity(launchSignup);
                                finish();
                        }
                });
        }

}
