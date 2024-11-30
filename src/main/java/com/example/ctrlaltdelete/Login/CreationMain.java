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
    private CreationController controller;
    @Override
    public void start(Stage stage) {

        view = new CreationView(stage);

        controller = new CreationController(stage,model,view);
        Image image = new Image("sliceHeaven.png");
        stage.getIcons().add(image);
        stage.show();
    }
}
