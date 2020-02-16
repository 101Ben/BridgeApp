package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageUI extends AppCompatActivity {

    Button btnAccount;
    Button btnContacts;
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ui);

        btnAccount = findViewById(R.id.accountButton);
        btnContacts = findViewById(R.id.contactsButton);
        btnSettings = findViewById(R.id.settingsButton);

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent launchAccount = new Intent(getApplicationContext(), AccountPageUI.class);
                startActivity(launchAccount);
                finish();
            }
        });
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent launchAccount = new Intent(getApplicationContext(), ContactPageUI.class);
                startActivity(launchAccount);
                finish();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent launchAccount = new Intent(getApplicationContext(), SettingsPageUI.class);
                startActivity(launchAccount);
                finish();
            }
        });

    }

}
