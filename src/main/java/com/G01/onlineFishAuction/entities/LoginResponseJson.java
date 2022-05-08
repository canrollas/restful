package com.G01.onlineFishAuction.entities;



import java.util.Date;

import lombok.Data;

@Data
public class LoginResponseJson {
    String message;
    long dateTimeObject;
    String path;
    String userType;

    public LoginResponseJson( String message, String path,String userType) {
        this.message = message;
        this.dateTimeObject = new Date().getTime();
        this.path = path;
        this.userType = userType;
    }


	public String getMessage() {
		return message;
	}

	public long getDateTimeObject() {
		return dateTimeObject;
	}

	public String getPath() {
		return path;
	}

	public String getUserType() {
		return userType;
	}
    
    
}
