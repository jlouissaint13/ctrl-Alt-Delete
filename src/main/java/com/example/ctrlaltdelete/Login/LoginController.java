package com.example.ctrlaltdelete.Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;
    private Button login,guest,cAccount;
    private Stage stage;
    private CreationView creationView;
    private String emailText,passwordText;
    public LoginController(Stage stage, LoginModel loginModel, LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = loginModel;
        //I need to do this because the buttons are in the model class these methods will return the buttons so this class can use them;
        login = loginView.getlogin(); //returns login button

        guest = loginView.getGuest(); //same for these with guest button and create account button

        cAccount = loginView.getcAccount();


        guest.setOnAction(event -> loginView.displayPlaceholder()); //Action handler for sign in as a guest;



        cAccount.setOnAction(event -> {
            creationView = new CreationView(stage);
            stage.setScene(creationView.scene);}); //Action handler for create account;



        login.setOnAction(event -> {
            //When this is initialized in the main class these values are set to null; As soon as the login button is pressed they are updated with the content of the text fields
            loginModel.setAccount(loginView.getEmail(), loginView.getPassword());
            switch (this.loginModel.isValid())  {
                //Case 1 log you in; Case 2 Invalid password; case 3 account does not exist;
                case 1: loginView.displayLogin(); break;
                case 2: loginView.invalidPassword(); break;
                case 3: loginView.invalidAccount(); break;
            }
        });



    }
}