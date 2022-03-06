package com.example.designPattern;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Presenter
public class MainViewModel extends ViewModel {

    private MainModel model;

    private MutableLiveData<String> name, birthday;

    public void onClickBtnSave(String name, String birthday) {
        getModel().setName(name);
        getModel().setBirthday(toDate(birthday));
    }

    public void onClickBtnLoad() {
        name.setValue(getModel().getName());
        birthday.setValue(toString(getModel().getBirthday()));
    }

    public MainModel getModel() {
        if(model == null){
            model = new MainModel();
        }
        return model;
    }

    public LiveData<String> getName() {
        if(name == null){
            name = new MutableLiveData<>();
        }
        return name;
    }

    public LiveData<String> getBirthday() {
        if(birthday == null){
            birthday = new MutableLiveData<>();
        }
        return birthday;
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

}
