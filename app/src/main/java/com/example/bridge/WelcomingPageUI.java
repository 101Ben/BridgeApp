package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class WelcomingPageUI extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseAuth mFirebaseAuth;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcoming_page_ui);

        mFirebaseAuth = FirebaseAuth.getInstance();
        btnContinue = findViewById(R.id.button);
        Spinner spinner =findViewById(R.id.languagesWPButton);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnContinue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(WelcomingPageUI.this, HomePageUI.class);
                startActivity(i);
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        String userID = mFirebaseAuth.getCurrentUser().getUid();
        DatabaseReference currentUser = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);
        Register.newPost.put("language", text);
        currentUser.setValue(Register.newPost);

        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(WelcomingPageUI.this, HomePageUI.class));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
