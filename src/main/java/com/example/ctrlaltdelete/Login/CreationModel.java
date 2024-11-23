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
    private HashMap<String,String> accounts = new HashMap<>();
    private String [] data = new String[5];
    //Using a hashmap because no duplicate keys; I do not want to allow two of the same email;
    //I do not mind if two people use the same password;
    public CreationModel(String fName,String lName,String email,String password,String phoneNumber) throws FileNotFoundException {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        data[0] = fName;
        data[1] = lName;
        data[2]=email;
        data[3] = password;
        data[4] = phoneNumber;
        String info = convertToCSV(data);
        writeCSV(info);
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
    public String convertToCSV(String [] data) {
        //returns the stream of data
        return Arrays.stream(data)
                //joins them with custom delimiter "|" was concerned about commas possibly messing with it;
                .collect(Collectors.joining("|"));


    }
    public void writeCSV(String data) throws FileNotFoundException {
        File csv = new File("accounts.csv");
        //So I can append to the file instead of overwriting it for now
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(csv,true))) {
            printWriter.println(data);
            System.out.println(data);

            System.out.println("Data has been written");

        }
    }

}
