package com.example.ctrlaltdelete.Checkout;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ReviewMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
ReviewView reviewView;
ReviewController reviewController;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        reviewView = new ReviewView(primaryStage);
        reviewController = new ReviewController(primaryStage);
        Image image = new Image("sliceHeaven.png");

        primaryStage.getIcons().add(image);
        primaryStage.show();
    }
}