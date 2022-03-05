package com.example.designPattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// Controller
public class MainActivity extends AppCompatActivity {

    private MainModel model;
    private MainView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new MainModel();
        mView = new MainView(this);

        mView.getBtnSave().setOnClickListener(view -> model.setData(mView.getInputData()));
        mView.getBtnLoad().setOnClickListener(view -> mView.showData(model.getData()));
    }

}