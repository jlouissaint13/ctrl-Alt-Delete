package com.example.ctrlaltdelete.Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    private LoginModel model;
    private LoginView view;
    private Button login,guest,cAccount;
    private Stage stage;
    private CreationView creationView;
    public LoginController(Stage stage,LoginModel model, LoginView view) {

        this.model = model;
        this.view = view;

        login = view.getlogin();
        guest = view.getGuest();
        cAccount = view.getcAccount();
        guest.setOnAction(event -> view.displayPlaceholder()); //Action handler for sign in as a guest;
        cAccount.setOnAction(event -> {
            creationView = new CreationView(stage);
            stage.setScene(creationView.scene);}); //Action handler for create account;
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (model.isValid()) {
                    view.displayLogin();



                }


            }

        }
        );


    }
}