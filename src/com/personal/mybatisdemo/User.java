package com.personal.mybatisdemo;

public class User {
    private String userName;
    private String Password;
    private String unid;

    public User(){}

    public User(String userName, String password, String unid) {
        this.userName = userName;
        Password = password;
        this.unid = unid;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
