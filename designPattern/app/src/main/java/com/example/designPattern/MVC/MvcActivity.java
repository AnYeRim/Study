package com.example.designPattern.MVC;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.designPattern.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Controller : view 일부 기능 + Controller 기능
public class MvcActivity extends AppCompatActivity {

    private MvcModel model;

    private EditText edtName, edtBirthday;
    private Button btnSave, btnLoad;
    private TextView txtName, txtBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        model = new MvcModel();

        edtName = findViewById(R.id.edtName);
        edtBirthday = findViewById(R.id.edtBirthday);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        txtName = findViewById(R.id.txtName);
        txtBirthday = findViewById(R.id.txtBirthday);

        btnSave.setOnClickListener(view -> {
            model.setName(getName());
            model.setBirthday(toDate(getBirthday()));
        });

        btnLoad.setOnClickListener(view -> showData(model.getName(), toString(model.getBirthday())));
    }

    @NonNull
    private String getName() {
        return edtName.getText().toString();
    }

    @NonNull
    private String getBirthday() {
        return edtBirthday.getText().toString();
    }

    private Date toDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @NonNull
    private String toString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        return dateFormat.format(date);
    }

    private void showData(String name, String birthday) {
        txtName.setText(name);
        txtBirthday.setText(birthday);
    }

}