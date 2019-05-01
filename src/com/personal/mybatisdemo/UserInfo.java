package com.personal.mybatisdemo;

import java.util.Date;

public class UserInfo {
    private String UserName;
    private String mobilephone;
    private String gender;
    private Date birthday;
    private String profession;

    public UserInfo() {

    }

    public UserInfo(String userName, String mobilephone, String gender, Date birthday, String profession) {
        UserName = userName;
        this.mobilephone = mobilephone;
        this.gender = gender;
        this.birthday = birthday;
        this.profession = profession;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
