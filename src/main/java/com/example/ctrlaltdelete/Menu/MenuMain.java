package com.example.ctrlaltdelete.Menu;

import javafx.application.Application;
import javafx.stage.Stage;

public class MenuMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
     MenuView menuView = new MenuView(primaryStage);

     primaryStage.show();
    }
}
