package com.example.designPattern;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.designPattern.databinding.ActivityMvvmBinding;

// View 관련 작업만
public class MvvmActivity extends AppCompatActivity {

    private MvvmViewModel viewModel;
    private ActivityMvvmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);

        // ViewModel 클래스가 owner 의 수명주기가 완전 finish() 될 때까지 메모리에 남아있다.
        // 즉 화면 회전을 하여도 ViewModel 데이터가 보존될 수 있다.
        viewModel = new ViewModelProvider(this).get(MvvmViewModel.class);

        // LiveData 의 변경 사항을 관찰하는 데 사용해야 하는 LifecycleOwner 지정한다.
        binding.setLifecycleOwner(this);

        // binding 에서  ViewModel 을 변수로 넣어 데이터 바인딩 가능하게 해준다.
        binding.setViewModel(viewModel);

        binding.btnSave.setOnClickListener(view -> viewModel.onClickBtnSave(getName(), getBirthday()));
        binding.btnLoad.setOnClickListener(view -> viewModel.onClickBtnLoad());
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