package com.example.ctrlaltdelete.Homepage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomepageView {
    private Pane pane;
    private Scene scene;
    private Stage stage;
    public void components() {
        pane = new Pane();

    }
    public void properties() {

    }
    public void addProperties() {

    }
    public HomepageView(Stage stage) {
       components();
       properties();
       addProperties();


       VBox vbox = new VBox(pane);
       scene = new Scene(vbox,350,600);
       stage.setTitle("Homepage");
       stage.setScene(scene);
    }
}
