package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageUI extends AppCompatActivity {

    Button btnAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_ui);

        btnAccount = findViewById(R.id.account);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent launchAccount = new Intent(getApplicationContext(), AcountPageUI.class);
                startActivity(launchAccount);
                finish();
            }
        });
    }

}
