package com.example.ctrlaltdelete.Login;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreationMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private CreationView view;
    private CreationModel model;
    private CreationMain main;
    private CreationMain controller;
    @Override
    public void start(Stage stage) {

        view = new CreationView(stage);


        stage.show();
    }
}
