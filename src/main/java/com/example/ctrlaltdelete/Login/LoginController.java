package com.example.ctrlaltdelete.Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;
    private Button login,guest,cAccount;
    private Stage stage;
    private CreationView creationView;
    public LoginController(Stage stage, LoginModel loginModel, LoginView loginView) {

        this.loginModel = loginModel;
        this.loginView = loginView;

        //I need to do this because the buttons are in the model class these methods will return the buttons so this class can use them;
        login = loginView.getlogin(); //returns login button
        guest = loginView.getGuest(); //same for these with guest button and create account button
        cAccount = loginView.getcAccount();
        guest.setOnAction(event -> loginView.displayPlaceholder()); //Action handler for sign in as a guest;
        cAccount.setOnAction(event -> {
            creationView = new CreationView(stage);
            stage.setScene(creationView.scene);}); //Action handler for create account;
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (loginModel.isValid()) {
                    loginView.displayLogin();



                }


            }

        }
        );


    }
}