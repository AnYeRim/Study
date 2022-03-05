package com.example.designPattern;

public class MainPresenter {

    private MainModel model;
    private MainActivity view;

    public MainPresenter(MainActivity view) {
        this.model = new MainModel();
        this.view = view;
        init();
    }

    private void init() {
        view
    }


    public void onClickBtnSave(){
        model.setData(view.getInputData());
    }

    public void onClickBtnLoad(){
        view.showData(model.getData());
    }

}
