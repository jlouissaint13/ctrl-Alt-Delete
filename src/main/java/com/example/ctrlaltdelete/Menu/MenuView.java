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
    private Pane pane;
    private Text word,wordTwo;
    private Scene scene;
    private Button minus,plus;
    private TextField special;
    //Here you will initialize your components
public void components() {
    //word = new word("Word");
    pane = new Pane();
    //wordTwo = new Text("30");
    //special = new TextField();
    //minus = new Button("-");
}

//Decide the properties size and where they go
public void properties() {
    //word.setLayoutX();
    //word.setLayoutY();


}
//This one is for adding elements to the pane
public void addComponents() {
    //pane.getChildren.add(word);

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
