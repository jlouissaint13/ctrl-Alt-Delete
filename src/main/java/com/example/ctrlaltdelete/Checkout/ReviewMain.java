package com.example.ctrlaltdelete.Checkout;

import javafx.application.Application;
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
        primaryStage.show();
    }
}
