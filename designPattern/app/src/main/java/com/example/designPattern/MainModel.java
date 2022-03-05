package com.example.designPattern;

import java.util.Date;

public class MainModel {

    private String name;
    private Date birthday;

    public MainModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
