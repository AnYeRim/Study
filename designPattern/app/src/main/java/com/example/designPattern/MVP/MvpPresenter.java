package com.example.designPattern.MVP;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Presenter
public class MvpPresenter {

    private MvpModel model;
    private MvpActivity view;

    public MvpPresenter(MvpActivity view) {
        this.model = new MvpModel();
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
