package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class ContactPageUI extends AppCompatActivity {

    Button btnAccount;
    Button btnSettings;
    Button btnMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page_ui);

        btnAccount = findViewById(R.id.accountButton);
        btnSettings = findViewById(R.id.contactsButton);
        btnMessages = findViewById(R.id.messagesButton);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), SettingsPageUI.class);
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
            public void onClick(View v) {
                Intent launchLogOut = new Intent(getApplicationContext(), AccountPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });
    }
}
