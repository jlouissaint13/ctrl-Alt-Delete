package com.example.ctrlaltdelete.Menu;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuView {
    private Pane pane, header;
    private Text word,wordTwo;
    private Scene scene;
    private Button minus,plus;
    private TextField special;
    //Here you will initialize your components
public void components() {
    //word = new word("Word");
    pane = new Pane();

    // Adding header text
    word = new Text("Menu");

    // Buttons for adding/subtracting items
    minus = new Button("-");
    plus = new Button("+");

}

//Decide the properties size and where they go
public void properties() {
    // Header properties
    word.setLayoutX(20);
    word.setLayoutY(40);


    // Buttons for item addition/subtraction
    minus.setLayoutX(20);
    minus.setLayoutY(120);
    plus.setLayoutX(60);
    plus.setLayoutY(120);

}
//This one is for adding elements to the pane
public void addComponents() {
    // Add header and subheader
    pane.getChildren().addAll(word, wordTwo);

    // Add buttons
    pane.getChildren().addAll(minus, plus);



}



public MenuView(Stage stage) {
   components();
   properties();
   addComponents();

    VBox vBox = new VBox(pane);
    scene = new Scene(vBox,350,600);
    stage.setTitle("Menu Page");
    stage.setScene(scene);
}

}
