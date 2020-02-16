package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcountPageUI extends AppCompatActivity {

    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount_page_ui);
        btnLogOut = findViewById(R.id.logOut);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(launchLogOut);
                finish();
            }
        });
    }
}
