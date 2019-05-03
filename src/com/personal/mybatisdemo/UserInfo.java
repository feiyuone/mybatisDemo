package com.personal.mybatisdemo;

public class UserInfo {
    private String unid;
    private String userName;
    private String mobilephone;
    private String gender;
    private String birthday;
    private String profession;

    public UserInfo() {
    }

    public UserInfo(String unid, String userName, String mobilephone, String gender, String birthday, String profession) {
        this.unid = unid;
        this.userName = userName;
        this.mobilephone = mobilephone;
        this.gender = gender;
        this.birthday = birthday;
        this.profession = profession;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
