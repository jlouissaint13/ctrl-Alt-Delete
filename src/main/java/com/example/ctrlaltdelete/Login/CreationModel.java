package com.example.ctrlaltdelete.Login;

import java.util.HashMap;

public class CreationModel {
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phoneNumber;
    private HashMap<String,String> accounts = new HashMap<>();

    //Using a hashmap because no duplicate keys; I do not want to allow two of the same email;
    //I do not mind if two people use the same password;
    public CreationModel(String fName,String lName,String email,String password,String phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        String [] info = {email,password};
        accounts.put(info[0],info[1]);

    }
    public CreationModel() {

    }
    public String getfName() {
        return this.fName;
    }
    public String getlName() {
        return this.lName;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void storeAccountInfo() {

    }
}
