package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountPageUI extends AppCompatActivity {

    Button btnLogOut;
    Button btnContacts;
    Button btnMessages;
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount_page_ui);
        btnLogOut = findViewById(R.id.logOut);
        btnContacts = findViewById(R.id.contactsButton);
        btnMessages = findViewById(R.id.messagesButton);
        btnSettings = findViewById(R.id.settingsButton);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), ContactPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        btnMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), HomePageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), SettingsPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });
    }
}
