package com.example.ctrlaltdelete.Login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class LoginModel {
    private String email;
    private String password;
    private String [] data = new String[5];
    private HashMap<String,String> account = new HashMap<>();
    private String line;
    public LoginModel(String email,String password) throws FileNotFoundException {
        this.email = email;
        this.password = password;

        readCSV();
    }
    public LoginModel() throws FileNotFoundException {
        readCSV(); //Read the csv here because other wise account will be empty and our method accountExist will not work;
    }
    //Will come back to later;
    //Reading the csv file to check if the account exists
    public void readCSV() throws FileNotFoundException {

        try(BufferedReader br = new BufferedReader(new FileReader("accounts.csv"))) {
            while ((line = br.readLine()) != null) {
                //Inner while loop for looping if we have a blank line this way we can loop over blank lines as they will throw an array out of bounds exception
                while (line.isBlank()) line = br.readLine();
                //the value[2] is the email and the value[3] is the password;
                //I am going to put these in a hashmap as soon as the program loads.
                //the key will be the email and the value will be the password;

                String[] values = line.split("\\|");
                account.put(values[2].trim(), values[3].trim());
            }
            //If it is blank or accidentally goes to the next line this error needs to be handled to prevent issues;
        }catch(NullPointerException e) {
            System.out.println("Null end of file found");
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
    public boolean inputValidation(String email,String password) {
       return (email == null || email.isBlank() || password == null || password.isBlank());
    }
    //When I initialize these in the main these values will be null;
    //I need to use setters, so I can update these values right when they are clicked with the login set action button;
    public void setAccount(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public boolean accountExist(String email) {


        return account.containsKey(email.toLowerCase());
    }
}
