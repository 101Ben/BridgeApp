package com.example.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bridge.R;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

public class MainActivity extends AppCompatActivity implements RoomListener {

        private String channelID = "Kg1OF0QfYGklQFqQ";
        private String roomName = "Bridge";
        private EditText editText;
        private Scaledrone scaledrone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                editText = (EditText)findViewById(R.id.editText);
        }

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

        }

        public void sendMessage(View view) {
                String message = editText.getText().toString();
                if(message.length() > 0) {
                        scaledrone.publish("Bridge", message);
                        editText.getText().clear();
                }
        }
}

// Karen's here