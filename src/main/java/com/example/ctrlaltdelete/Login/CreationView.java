package com.example.ctrlaltdelete.Login;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreationView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPane;
    private Label fName,lName,email,pw,phoneNumber;
    private TextField fNameE,lNameE,emailE,passwordE,phoneNumberE;
    private Button cAccount;
    public CreationView(Stage stage) {
        gridPane = new GridPane(350,600);
        scene = new Scene(gridPane,350,600);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        stage.setTitle("Create Account");
        stage.setScene(scene);
        gridPane.add(new Text("Testing"),0,0);

    }


}
