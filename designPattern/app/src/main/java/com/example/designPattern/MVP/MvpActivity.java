package com.example.designPattern.MVP;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.designPattern.R;

// View 관련 작업만
public class MvpActivity extends AppCompatActivity {

    private MvpPresenter presenter;

    private EditText edtName, edtBirthday;
    private Button btnSave, btnLoad;
    private TextView txtName, txtBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        presenter = new MvpPresenter(this);

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