package com.example.designPattern;

import java.util.Date;

public class MvpModel {

    private String name;
    private Date birthday;

    public MvpModel() {
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
