package com.example.designPattern;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Presenter
public class MainViewModel {

    private MainModel model;
    private MainActivity view;

    public ObservableField<String> name;
    public ObservableField<String> birthday;

    public MainViewModel(MainActivity view) {
        this.view = view;
        init();
    }

    private void init() {
        model = new MainModel();
        name = new ObservableField<>("");
        birthday = new ObservableField<>("");
    }

    public void onClickBtnSave() {
        model.setName(view.getName());
        model.setBirthday(toDate(view.getBirthday()));
    }

    public void onClickBtnLoad() {
        name.set(model.getName());
        birthday.set(toString(model.getBirthday()));
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
