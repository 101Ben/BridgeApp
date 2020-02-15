package com.example.bridgeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements RoomListener {
        private String channelID = "Kg1OF0QfYGklQFqQ";
        private String roomName = "BridgeApp";
        private EditText editText;
        private Scaledrone scaledrome;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                editText = (EditText)FindViewById(R.id.editText);
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

}