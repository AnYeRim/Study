package com.example.designPattern;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// View 관련 작업만
public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    private EditText edtName, edtBirthday;
    private Button btnSave, btnLoad;
    private TextView txtName, txtBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        edtName = findViewById(R.id.edtName);
        edtBirthday = findViewById(R.id.edtBirthday);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtName = findViewById(R.id.txtName);
        txtBirthday = findViewById(R.id.txtBirthday);

        btnSave.setOnClickListener(view -> presenter.onClickBtnSave());
        btnLoad.setOnClickListener(view -> presenter.onClickBtnLoad());
    }

    @NonNull
    public String getBirthday() {
        return edtBirthday.getText().toString();
    }

    @NonNull
    public String getName() {
        return edtName.getText().toString();
    }

    public void showData(String name, String birthday) {
        txtName.setText(name);
        txtBirthday.setText(birthday);
    }

}