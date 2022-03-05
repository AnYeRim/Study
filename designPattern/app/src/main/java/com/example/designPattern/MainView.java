package com.example.designPattern;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

// View
public class MainView {

    private Activity activity;

    private EditText edtInput;
    private Button btnSave, btnLoad;
    private TextView txtOutput;

    public MainView(Activity activity) {
        this.activity = activity;
        init();
    }

    private void init() {
        edtInput = activity.findViewById(R.id.edtInput);
        btnSave = activity.findViewById(R.id.btnSave);
        btnLoad = activity.findViewById(R.id.btnLoad);
        txtOutput = activity.findViewById(R.id.txtOutput);
    }

    @NonNull
    public String getInputData() {
        return edtInput.getText().toString();
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnLoad() {
        return btnLoad;
    }

    public void showData(String data) {
        txtOutput.setText(data);
    }

}
