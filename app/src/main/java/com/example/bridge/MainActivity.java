package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bridge.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

public class MainActivity extends AppCompatActivity {

/*        private String channelID = "Kg1OF0QfYGklQFqQ";
        private String roomName = "Bridge";
        private EditText editText;
        private Scaledrone scaledrone;*/
        Button btnLogIn;
        Button btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                btnLogIn = findViewById(R.id.buttonLogin);
                btnSignUp = findViewById(R.id.buttonSignUp);

                btnLogIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent launchLogin = new Intent(MainActivity.this, Login.class);
                                startActivity(launchLogin);
                        }
                });

                btnSignUp.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                                Intent launchSignup = new Intent(MainActivity.this, Register.class);
                                startActivity(launchSignup);
                        }
                });
        }
/*

        @Override
        public void onOpen(Room room){
                System.out.println("Connected to room");
        }

        @Override
        public void onOpenFailure(Room room, Exception ex){
                System.err.println(ex);
        }

        @Override
        public void onMessage(Room room, com.scaledrone.lib.Message receivedMessage){
                final ObjectMapper mapper = new ObjectMapper();
                try {
                        final User data = mapper.treeToValue(receivedMessage.getMember().getClientData(), User.class);
                        boolean belongsToCurrentUser = receivedMessage.getClientID().equals(scaledrone.getClientID());
                        final Message message = new Message(receivedMessage.getData().asText(), data, belongsToCurrentUser);
                        runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                        messageAdapter.add(message);
                                        messagesView.setSelection(messagesView.getCount() - 1);
                                }
                        });
                } catch (JsonProcessingException e) {
                        e.printStackTrace();
                }
        }

        public void sendMessage(View view) {
                String message = editText.getText().toString();
                if(message.length() > 0) {
                        scaledrone.publish("Bridge", message);
                        editText.getText().clear();
                }
        }*/


}
