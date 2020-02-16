package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
        //implements RoomListener {

        private String channelID = "Kg1OF0QfYGklQFqQ";
        private String roomName = "Bridge";
        private EditText editText;
        Button btnLogIn;
        Button btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                editText = (EditText)findViewById(R.id.editText);
                btnLogIn = findViewById(R.id.buttonLogin);
                btnSignUp = findViewById(R.id.buttonSignup);

                btnLogIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent launchLogin = new Intent(getApplicationContext(), Login.class);
                                startActivity(launchLogin);
                                finish();
                        }
                });

                btnSignUp.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                                Intent launchSignup = new Intent(getApplicationContext(), Register.class);
                                startActivity(launchSignup);
                                finish();
                        }
                });
        }


//        @Override
//        public void onOpen(Room room){
//                System.out.println("Connected to room.");
////                scaledrone.subscribe(roomName,MainActivity.this);
//        }
//
//        @Override
//        public void onOpenFailure(Room room, Exception ex){
//                System.err.println(ex);
//        }
//
//        @Override
//        public void onMessage(Room room, com.scaledrone.lib.Message receivedMessage){
//                final ObjectMapper mapper = new ObjectMapper();
//                try {
//                        final User data = mapper.treeToValue(receivedMessage.getMember().getClientData(), User.class);
//                        boolean belongsToCurrentUser = receivedMessage.getClientID().equals(scaledrone.getClientID());
//                        final Message message = new Message(receivedMessage.getData().asText(), data, belongsToCurrentUser);
//                        runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                        MessageAdapter.add(message);
//                                        messagesView.setSelection(messagesView.getCount() - 1);
//                                }
//                        });
//                } catch (JsonProcessingException e) {
//                        e.printStackTrace();
//                }
//        }
//
//        public void sendMessage(View view) {
//                String message = editText.getText().toString();
//                if(message.length() > 0) {
//                        scaledrone.publish("Bridge", message);
//                        editText.getText().clear();
//                }
//        }


}
