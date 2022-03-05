package com.example.designPattern;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Presenter
public class MainPresenter {

    private MainModel model;
    private MainActivity view;

    public MainPresenter(MainActivity view) {
        this.model = new MainModel();
        this.view = view;
    }

    public void onClickBtnSave(){
        model.setName(view.getName());
        model.setBirthday(toDate(view.getBirthday()));
    }

    public void onClickBtnLoad(){
        view.showData(model.getName(), toString(model.getBirthday()));
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
