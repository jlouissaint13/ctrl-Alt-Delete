package com.example.ctrlaltdelete.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CreationModel {
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String [] data = new String[6];
    //Using a hashmap because no duplicate keys; I do not want to allow two of the same email;
    //I do not mind if two people use the same password;
    public CreationModel(String fName,String lName,String email,String password,String phoneNumber,String address) throws FileNotFoundException {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        data[0] = fName;
        data[1] = lName;
        data[2] = email;
        data[3] = password;
        data[4] = phoneNumber;
        data[5] = address;
        String info = convertToCSV(data);
    }
    public CreationModel() {

    }
    //Need to convert data to csv format before we return it so the string can take it in
    public String getData() {

        return convertToCSV(data);


    }
    public String [] getDataArray() {
        return data;
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
    public String getAddress() {return this.address;}
    public void storeAccountInfo() {

    }
    public boolean validPhoneNumber(String phoneNumber) {
        //if phone number equals 10 then check if phone is all digits then return the outcome;
        if (phoneNumber.length() == 10 ) return phoneNumber.matches("\\d+");
        //if phone number is not 10 digits return false;
        return false;
    }
    //email validation if i have time i will come back and improve it with a regex function;
    public boolean validEmail(String email) {
        return email.contains("@") && email.contains(".com");
    }
    //checks if textFields are left empty or null;
    public boolean inputValidation(String [] data) {
        for(String d:data) {
            if (d == null || d.isBlank()) return false;
        }
        return true;
    }
    public String convertToCSV(String [] data) {
        //returns the stream of data
        return Arrays.stream(data)
                //joins them with custom delimiter "|" was concerned about commas possibly messing with it;
                .collect(Collectors.joining("|"));


    }
    public void writeCSV(String data) throws FileNotFoundException {
        File csv = new File("accounts.csv");
        //So I can append to the file instead of overwriting it for now
        //If the account exist tell the user they have to use another email because that one is in use

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(csv,true))) {
            printWriter.println(data);
            System.out.println(data);

            System.out.println("Data has been written");

        }
    }

}
