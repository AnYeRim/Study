package com.example.designPattern;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String saveData;

    private EditText edtInput;
    private Button btnSave, btnLoad;
    private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edtInput);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtOutput = findViewById(R.id.txtOutput);

        btnSave.setOnClickListener(view -> saveData = getInputData());
        btnLoad.setOnClickListener(view -> showData(saveData));
    }

    @NonNull
    private String getInputData() {
        return edtInput.getText().toString();
    }

    private void showData(String data) {
        txtOutput.setText(data);
    }

}