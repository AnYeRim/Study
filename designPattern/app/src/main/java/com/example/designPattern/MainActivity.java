package com.example.designPattern;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// Controller : model 과 view 의 중간다리 역할.
// 안드로이드에서 view = xml
// 사용자 요청이 들어오면 관련된 작업 처리 (모델에 데이터 저장 및 호출, 뷰에 출력 요청)
public class MainActivity extends AppCompatActivity {

    private MainModel model;

    private EditText edtInput;
    private Button btnSave, btnLoad;
    private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new MainModel();

        edtInput = findViewById(R.id.edtInput);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtOutput = findViewById(R.id.txtOutput);

        btnSave.setOnClickListener(view -> model.setData(getInputData()));
        btnLoad.setOnClickListener(view -> showData(model.getData()));
    }

    @NonNull
    public String getInputData() {
        return edtInput.getText().toString();
    }

    public void showData(String data) {
        txtOutput.setText(data);
    }

}