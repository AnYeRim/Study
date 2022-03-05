package com.example.designPattern;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// View 관련 작업만
public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    private EditText edtInput;
    private Button btnSave, btnLoad;
    private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        edtInput = findViewById(R.id.edtInput);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtOutput = findViewById(R.id.txtOutput);

        btnSave.setOnClickListener(view -> presenter.onClickBtnSave());
        btnLoad.setOnClickListener(view -> presenter.onClickBtnLoad());
    }

    @NonNull
    public String getInputData() {
        return edtInput.getText().toString();
    }

    public void showData(String data) {
        txtOutput.setText(data);
    }

}