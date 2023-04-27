package com.example.broadcast_receiver;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_CHAT = "com.example.action.SEND_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.button);

        btnSend.setOnClickListener(v -> {
            sendBroadcastTest();
        });
    }

    private void sendBroadcastTest() {
        Intent intent = new Intent(ACTION_CHAT);
        intent.putExtra("title","홍길동");
        intent.putExtra("message","안녕?!");

        sendBroadcast(intent);
    }
}