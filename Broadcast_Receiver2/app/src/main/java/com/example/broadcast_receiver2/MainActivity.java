package com.example.broadcast_receiver2;

import static com.example.broadcast_receiver2.ChatReceiver.ACTION_CHAT;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ChatReceiver chatReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);

        String title = getIntent().getStringExtra("title");
        String message = getIntent().getStringExtra("message");

        textView1.setText(title);
        textView2.setText(message);

        chatReceiver = new ChatReceiver();

        IntentFilter intentFilter = new IntentFilter(ACTION_CHAT);
        registerReceiver(chatReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(chatReceiver);
    }
}