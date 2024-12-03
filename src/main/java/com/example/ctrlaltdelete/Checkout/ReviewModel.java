package com.example.ctrlaltdelete.Checkout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReviewModel {
private StringBuilder sb;
private ArrayList<String> read = new ArrayList<>();
private static String fName,lName,phoneNumber,address;
public ReviewModel() {
    readFile();


}
public ReviewModel(String fName,String lName,String phoneNumber,String address) {

    ReviewModel.fName = fName;
    ReviewModel.lName = lName;
    ReviewModel.phoneNumber = phoneNumber;
    ReviewModel.address = address;

}
public String orderDetails() {
    return String.valueOf(sb);
}
    //Reads in the save file to be stored in a vbox
    public void readFile() {
         sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line +"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Returns user info
    public String getfName() {
    return fName;
    }
    public String getlName() {
    return lName;
    }
    public String getPhoneNumber() {
    return phoneNumber;
    }
    public String getAddress() {return address;}

    //Resets the information login information of users
    public void resetloginGuest() {
    fName = null;
    lName = null;
    phoneNumber = null;
    }

}
