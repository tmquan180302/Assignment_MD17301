package com.example.assignment_md17301.Interface;

import com.example.assignment_md17301.model.User;

public class ServerRespone {
    private String result , message;
    private User user;

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
