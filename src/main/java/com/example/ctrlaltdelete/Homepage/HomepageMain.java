package com.example.ctrlaltdelete.Homepage;
import javafx.application.Application;
import javafx.stage.Stage;

public class HomepageMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HomepageView homepageView = new HomepageView(primaryStage);

        primaryStage.show();
    }
}
