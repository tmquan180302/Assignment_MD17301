package com.example.assignment_md17301.Interface;

import com.example.assignment_md17301.model.User;

public class ServerRequest {

    private String operation; // ddng nhap dang ky
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
