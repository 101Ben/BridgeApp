package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class SettingsPageUI extends AppCompatActivity {

    Button btnAccount;
    Button btnContacts;
    Button btnMessages;
    Button btnLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page_ui);

        btnAccount = findViewById(R.id.accountButton);
        btnContacts = findViewById(R.id.contactsButton);
        btnMessages = findViewById(R.id.messagesButton);
        btnLanguages = findViewById(R.id.languagesButton);

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

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), AccountPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        btnLanguages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), LanguagePageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });
    }
}
