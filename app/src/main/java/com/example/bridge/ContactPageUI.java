package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.TextView;

public class ContactPageUI extends AppCompatActivity {

    Button btnAccount;
    Button btnSettings;
    Button btnMessages;
    Button btnAddContacts;
    Button btnOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page_ui);

        btnAccount = findViewById(R.id.accountButton);
        btnSettings = findViewById(R.id.contactsButton);
        btnMessages = findViewById(R.id.messagesButton);
        btnAddContacts = findViewById(R.id.addContactButton);
        btnOptions = findViewById(R.id.otherOptionButton);

        //setting button
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), SettingsPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        //messages button
        btnMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), HomePageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        //account button
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchLogOut = new Intent(getApplicationContext(), AccountPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        //contacts button
        btnAddContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchLogOut = new Intent(getApplicationContext(), AddContactsUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });

        //options button
        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent launchLogOut = new Intent(getApplicationContext(), OptionPageUI.class);
                startActivity(launchLogOut);
                finish();
            }
        });





        //implement : when a new contact is added, make a new button to message the new contact
    }
}
