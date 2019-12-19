package com.example.cardstupet.profaile.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties

public class Post {

    public String login;
    public String number;
    public String password;
    public String repeatPass;

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Post(String login, String number, String password, String repeatPass) {
        this.login = login;
        this.number = number;
        this.password = password;
        this.repeatPass = repeatPass;
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("login", login);
        result.put("number", number);
        result.put("password", password);
        result.put("repeatRess", repeatPass);
        return result;
    }

}
