package com.example.ctrlaltdelete.Login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoginModel {
    private String email;
    private String password;
    private String [] data = new String[5];
    private HashMap<String,String> account = new HashMap<>();

    public LoginModel(String email,String password) throws FileNotFoundException {
        this.email = email;
        this.password = password;

        readCSV();
    }
    //Will come back to later;
    //Reading the csv file to check if the account exists
    public void readCSV() throws FileNotFoundException {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("accounts.csv"))) {
            while ((line = br.readLine()) != null) {
                //the value[2] is the email and the value[3] is the password;
                //I am going to put these in a hashmap as soon as the program loads.
                //the key will be the email and the value will be the password;
                String [] values = line.split("\\|");
                account.put(values[2],values[3]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //The hashmap is going to read the entire csv;
    //This way even previously created accounts will still exists upon closure of the program;
    //Now I am going to validate the entered username and password against the hashmap
    public int isValid() {
        if (account.containsKey(this.email)) {
                if (account.get(this.email).equals(this.password)) {
                    //password is valid;
                    return 1;
                }
                //password is invalid
                return 2;

        }
        return 3;//account does not exist;
    }
    //When I initialize these in the main these values will be null;
    //I need to use setters so I can update these values right when they are clicked with the login set action button;
    public void setAccount(String email,String password) {
        this.email = email;
        this.password = password;
    }

}
