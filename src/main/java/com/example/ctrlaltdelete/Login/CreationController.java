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
    private String fName,lName,email,password,phoneNumber;
    private Button createAccount;
 public CreationController(Stage stage, CreationModel creationModel, CreationView creationView) {
        this.creationView = creationView;

        createAccount = this.creationView.getcAccount();
        //on button click grab all text and store them in model constructor;
     createAccount.setOnAction(e -> {
         fName = creationView.getfName();
         lName = creationView.getlName();

         email = creationView.getEmail();



         password = creationView.getPassword();
         phoneNumber = creationView.getPhoneNumber();
         System.out.println("Button is working");
         try {
             this.creationModel = new CreationModel(fName,lName,email,password,phoneNumber);
         } catch (FileNotFoundException ex) {
             throw new RuntimeException(ex);
         }
     });

 }
}
