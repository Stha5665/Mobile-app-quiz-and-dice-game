package com.example.tca1;

import android.widget.EditText;

public class Credentials {
    private String UserName;
    private String Password;
    private String loggedInUser;
    private String loggedInUserPass;

    Credentials(){

    }
    Credentials(String username, String password) {
        this.UserName = username;
        this.Password = password;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public String getLoggedInUserPass() {
        return loggedInUserPass;
    }

    public void setLoggedInUserPass(String loggedInUserPass) {
        this.loggedInUserPass = loggedInUserPass;
    }
}




