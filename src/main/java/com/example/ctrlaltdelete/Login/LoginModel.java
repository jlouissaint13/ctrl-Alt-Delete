package com.example.ctrlaltdelete.Login;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginModel {
    private String email;
    private String password;
    //Using a hashmap because no duplicate keys; I do not want to allow two of the same email;
    //I do not mind if two people use the same password;
    private HashMap<String,String> accounts = new HashMap<>();
    public LoginModel(String email,String password) {
        this.email = email;
        this.password = password;
        String [] info = {email,password};
        accounts.put(info[0],info[1]);
    }
    public LoginModel () {

    }
    //Will come back to later;
    public boolean isValid() {
        return true;
    }


}
