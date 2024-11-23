package com.example.ctrlaltdelete.Login;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginModel {
    private String email;
    private String password;


    public LoginModel(String email,String password) {
        this.email = email;
        this.password = password;


    }
    public LoginModel () {

    }
    //Will come back to later;
    public boolean isValid() {
        return true;
    }


}
