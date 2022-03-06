package com.example.designPattern;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.designPattern.databinding.ActivityMainBinding;


// View 관련 작업만
public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = new MainViewModel(this);
        binding.setViewModel(viewModel);
    }

    @NonNull
    public String getBirthday() {
        return binding.edtBirthday.getText().toString();
    }

    @NonNull
    public String getName() {
        return binding.edtName.getText().toString();
    }

}