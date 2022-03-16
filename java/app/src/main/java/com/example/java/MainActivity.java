package com.example.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "안녕 나는 홍길동이야. 안녕";

        Log.i("replace : ",text.replace("안녕","Hi~"));
        Log.i("replaceAll : ",text.replaceAll("안녕","Hi~"));

        Log.i("replace : ",text.replace(".","!"));
        Log.i("replaceAll : ",text.replaceAll(".","!"));

        text = "내이름은 코난! 탐정이죠~ :)";

        Log.i("replace : ",
                text.replace("!","")
                .replace("~","")
                .replace(":","")
                .replace(")",""));

        Log.i("replaceAll : ",
                text.replaceAll("[!~:)]",""));
    }
}