package com.example.ctrlaltdelete.Checkout;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckoutView {
private Pane pane;
private Scene scene;
private Stage stage;
public void components() {

}
public void properties() {

}
public void addComponents() {

}



public CheckoutView(Stage stage) {
    components();
    properties();
    addComponents();


    VBox vBox = new VBox(pane);
    scene = new Scene(vBox,350,600);
    stage.setTitle("Checkout Page");
    stage.setScene(scene);
}




}