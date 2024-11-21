package com.example.ctrlaltdelete.Login;

public class CreationModel {
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phoneNumber;

    public CreationModel(String fName,String lName,String email,String password,String phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
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
}
