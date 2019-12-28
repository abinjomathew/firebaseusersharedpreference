package com.example.firebasesuser;

public class SignupModule {
    public String name;
    public String emailid;
    public String phone;
    public String place;
    public String password;

    public SignupModule() {
    }

    public SignupModule(String name, String emailid, String phone, String place, String password) {
        this.name = name;
        this.emailid = emailid;
        this.phone = phone;
        this.place = place;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
