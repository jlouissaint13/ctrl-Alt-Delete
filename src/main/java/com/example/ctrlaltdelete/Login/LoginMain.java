package com.example.ctrlaltdelete.Login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

//Using Model-View-Controller methodology to organize my code
public class LoginMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    LoginModel model;
    LoginView view;
    LoginController controller;

    @Override
    public void start(Stage stage) {

        view = new LoginView(stage);//Creates all my components to be used and sets up my screen
        model = new LoginModel();
        controller = new LoginController(stage,model, view);
        //The controller needs to be initialized all the methods are in there

        Image image = new Image("sliceHeaven.png");

        stage.getIcons().add(image);
        stage.show(); //will not show without this\\

    }

}
