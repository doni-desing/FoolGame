package com.example.cardstupet.profaile.model;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ProfaileModel {
    public String login;
    public String password;
    public String repeatPass;
    public String number;

    public ProfaileModel(String login, String password, String repeatPass, String number) {
        this.login = login;
        this.password = password;
        this.repeatPass = repeatPass;
        this.number = number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
