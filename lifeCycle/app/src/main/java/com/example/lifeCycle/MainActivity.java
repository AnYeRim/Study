package com.example.lifeCycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubActivity, btnDialog;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        init();
    }

    private void init() {
        btnSubActivity = findViewById(R.id.btnSubActivity);
        btnDialog = findViewById(R.id.btnDialog);

        btnSubActivity.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
    }

    private void showDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("제목입니다")
                .setMessage("내용입니다.")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("확인", null)
                .setNegativeButton("취소", null).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubActivity:
                Intent intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDialog:
                showDialog();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

}