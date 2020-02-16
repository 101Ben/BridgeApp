package com.example.bridge;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Message extends AppCompatActivity {

    private String messageText;
    private String messageUser;
    private long messageTime;

    public Message(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;

        messageTime = new Date().getTime();
    }

    public Message(){

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button fab = findViewById(R.id.buttonsend);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = findViewById(R.id.sendMessage);

                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new Message(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getDisplayName())
                        );

                input.setText("");
            }
        });
    }

}

//
//package com.example.bridge;
//
//public class Message extends User {
//    private String text;
//    private User userData;
//    private boolean belongToCurrentUser;
//
//    public Message(String text, User userData, boolean belongToCurrentUser) {
//        this.text = text;
//        this.userData = userData;
//        this.belongToCurrentUser = belongToCurrentUser;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public User getUserData() {
//        return userData;
//    }
//
//    public boolean getBelongToCurrentUser() {
//        return belongToCurrentUser;
//    }
//}
//
//
