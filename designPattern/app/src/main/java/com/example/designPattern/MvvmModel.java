package com.example.designPattern;

import java.util.Date;

public class MvvmModel {

    private String name;
    private Date birthday;

    public MvvmModel() {
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