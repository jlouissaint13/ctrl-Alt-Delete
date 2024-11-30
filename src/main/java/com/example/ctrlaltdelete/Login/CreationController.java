package com.example.ctrlaltdelete.Login;

import com.example.ctrlaltdelete.Login.ValidationException.EmailValidation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class CreationController {
    private CreationModel creationModel;
    private CreationView creationView;
    private String fName,lName,email,password,phoneNumber,address;
    private Button createAccount,homeButton;
    private LoginModel loginModel;
 public CreationController(Stage stage, CreationModel creationModel, CreationView creationView) {
        this.creationView = creationView;

        createAccount = this.creationView.getcAccount();
        //on button click grab all text and store them in model constructor;


        homeButton = this.creationView.getHomeButton();


        homeButton.setOnAction(e -> {
            LoginMain loginMain = new LoginMain();
            try {
                loginMain.start(stage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

     createAccount.setOnAction(e -> {
         try {
             loginModel = new LoginModel();
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
         //Trim to get rid of the whitespace and make the code less error prone in my opinion;

         fName = creationView.getfName().trim();
         lName = creationView.getlName().trim();
         email = creationView.getEmail().trim();
         password = creationView.getPassword().trim();
         phoneNumber = creationView.getPhoneNumber().trim();
         address = creationView.getAddress();
         //Before we allow the user to create an account lets check if the account already exists in our files;

         System.out.println("Button is working");
         try {
             this.creationModel = new CreationModel(fName,lName,email,password,phoneNumber,address);
             //We also need to do a check on the phone number as well to see if it is valid;
             //if valid phoneNumber false then display message telling user so;
             // We need to create our constructor first or else we get a null pointer exception
             //The following if statements are all going to be validation checks before i allow the creation of an account;
             if(!this.creationModel.inputValidation(this.creationModel.getDataArray())) {
                 creationView.displayValidationCheck();
                 return;
             }
             if(loginModel.accountExist(email.toLowerCase())) {
                 creationView.accountExist();
                 return;
             }

             if (!this.creationModel.validPhoneNumber(this.phoneNumber)) {
                 creationView.displayInvalidPhone();
                 return;
             }
             if (!this.creationModel.validEmail(this.email)) {
                    creationView.displayInvalidEmail();
                    return;
             }
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
         try {
             this.creationModel.writeCSV(this.creationModel.getData());
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
         LoginMain loginMain = new LoginMain();
         try {
             loginMain.start(stage);
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
     });

     //Allows for enter button to be pressed to enter information;
     this.creationView.getPhoneNumberE().setOnAction(e -> {
         try {
             loginModel = new LoginModel();
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
         //Trim to get rid of the whitespace and make the code less error prone in my opinion;

         fName = creationView.getfName().trim();
         lName = creationView.getlName().trim();
         email = creationView.getEmail().trim();
         password = creationView.getPassword().trim();
         phoneNumber = creationView.getPhoneNumber().trim();

         //Before we allow the user to create an account lets check if the account already exists in our files;

         System.out.println("Button is working");
         try {
             this.creationModel = new CreationModel(fName,lName,email,password,phoneNumber,address);
             //We also need to do a check on the phone number as well to see if it is valid;
             //if valid phoneNumber false then display message telling user so;
             // We need to create our constructor first or else we get a null pointer exception
             //The following if statements are all going to be validation checks before i allow the creation of an account;
             if(!this.creationModel.inputValidation(this.creationModel.getDataArray())) {
                 creationView.displayValidationCheck();
                 return;
             }
             if(loginModel.accountExist(email.toLowerCase())) {
                 creationView.accountExist();
                 return;
             }

             if (!this.creationModel.validPhoneNumber(this.phoneNumber)) {
                 creationView.displayInvalidPhone();
                 return;
             }
             if (!this.creationModel.validEmail(this.email)) {
                 creationView.displayInvalidEmail();
                 return;
             }
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
         try {
             this.creationModel.writeCSV(this.creationModel.getData());
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
         LoginMain loginMain = new LoginMain();
         try {
             loginMain.start(stage);
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }



     });

 }
}
