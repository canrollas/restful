package com.G01.onlineFishAuction.entities;

import lombok.Data;

import java.util.Date;

@Data
public class LoginResponseJson {
    int status;
    String message;
    long dateTimeObject;
    String path;
    String userType;

    public LoginResponseJson(int status, String message, String path,String userType) {
        this.status = status;
        this.message = message;
        this.dateTimeObject = new Date().getTime();
        this.path = path;
        this.userType = userType;
    }
}