package com.example.designPattern.MVC;

import java.util.Date;

// Model
public class MvcModel {

    private String name;
    private Date birthday;

    public MvcModel() {
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
