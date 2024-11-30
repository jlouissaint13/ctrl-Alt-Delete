package com.example.ctrlaltdelete.Checkout;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReviewView {
    private Pane pane;
    private Scene scene;
    private Stage stage;
    public void components() {
    pane = new Pane();
    }
    public void properties() {

    }
    public void addComponents() {

    }



    public ReviewView(Stage stage) {
        components();
        properties();
        addComponents();

        VBox vBox = new VBox(pane);

        scene = new Scene(vBox,350,600);
        stage.setTitle("Checkout Page");
        stage.setScene(scene);
    }

}
