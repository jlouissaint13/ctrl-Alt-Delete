package com.example.ctrlaltdelete.Checkout;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ReviewMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        ReviewView reviewView = new ReviewView(primaryStage);

        primaryStage.show();
    }
}
