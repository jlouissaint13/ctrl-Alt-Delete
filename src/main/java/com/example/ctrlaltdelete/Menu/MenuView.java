package com.example.ctrlaltdelete.Menu;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Text headerText;
    private TextField nameField, phoneField, priceField;
    private RadioButton smallSize, mediumSize, largeSize;
    private CheckBox pepperoni, hamburger, sausage, canadianBacon, chicken, greenPeppers, redPeppers, onions, mushrooms, blackOlives;
    private Button calculateButton, placeOrderButton, exitButton;
    private Scene scene;

    //Here you will initialize your components
public void components() {
    //word = new word("Word");
    pane = new Pane();

    // Adding header text
    headerText = new Text("Menu");

    // Text fields
    nameField = new TextField();
    phoneField = new TextField();
    priceField = new TextField();
    priceField.setEditable(false);


    // Radio buttons for pizza size
    smallSize = new RadioButton("Small");
    mediumSize = new RadioButton("Medium");
    largeSize = new RadioButton("Large");
    ToggleGroup sizeGroup = new ToggleGroup();
    smallSize.setToggleGroup(sizeGroup);
    mediumSize.setToggleGroup(sizeGroup);
    largeSize.setToggleGroup(sizeGroup);

    // Checkboxes for toppings
    pepperoni = new CheckBox("Pepperoni");
    hamburger = new CheckBox("Hamburger");
    sausage = new CheckBox("Sausage");
    canadianBacon = new CheckBox("Canadian Bacon");
    chicken = new CheckBox("Chicken");
    greenPeppers = new CheckBox("Green Peppers");
    redPeppers = new CheckBox("Red Peppers");
    onions = new CheckBox("Onions");
    mushrooms = new CheckBox("Mushrooms");
    blackOlives = new CheckBox("Black Olives");

    // Buttons
    calculateButton = new Button("Calculate");
    placeOrderButton = new Button("Place Order");
    exitButton = new Button("Exit");


}

//Decide the properties size and where they go
public void properties() {
    // Header properties
    headerText.setLayoutX(100);
    headerText.setLayoutY(40);

    // Name and phone fields
    nameField.setLayoutX(20);
    nameField.setLayoutY(80);
    nameField.setPromptText("Name:");
    phoneField.setLayoutX(20);
    phoneField.setLayoutY(120);
    phoneField.setPromptText("Phone Number:");

    // Pizza size
    smallSize.setLayoutX(20);
    smallSize.setLayoutY(240);
    mediumSize.setLayoutX(80);
    mediumSize.setLayoutY(240);
    largeSize.setLayoutX(160);
    largeSize.setLayoutY(240);

    // Toppings
    pepperoni.setLayoutX(20);
    pepperoni.setLayoutY(280);
    hamburger.setLayoutX(150);
    hamburger.setLayoutY(280);
    sausage.setLayoutX(20);
    sausage.setLayoutY(320);
    canadianBacon.setLayoutX(150);
    canadianBacon.setLayoutY(320);
    chicken.setLayoutX(20);
    chicken.setLayoutY(360);
    greenPeppers.setLayoutX(150);
    greenPeppers.setLayoutY(360);
    redPeppers.setLayoutX(20);
    redPeppers.setLayoutY(400);
    onions.setLayoutX(150);
    onions.setLayoutY(400);
    mushrooms.setLayoutX(20);
    mushrooms.setLayoutY(440);
    blackOlives.setLayoutX(150);
    blackOlives.setLayoutY(440);

    // Price field
    priceField.setLayoutX(20);
    priceField.setLayoutY(480);
    priceField.setPromptText("Price:");

    // Buttons
    calculateButton.setLayoutX(20);
    calculateButton.setLayoutY(520);
    placeOrderButton.setLayoutX(100);
    placeOrderButton.setLayoutY(520);
    exitButton.setLayoutX(200);
    exitButton.setLayoutY(520);

}
//This one is for adding elements to the pane
public void addComponents() {
    // Add header and subheader
    pane.getChildren().addAll(
            headerText, nameField, phoneField,
            smallSize, mediumSize, largeSize,
            pepperoni, hamburger, sausage, canadianBacon, chicken, greenPeppers,
            redPeppers, onions, mushrooms, blackOlives,
            priceField, calculateButton, placeOrderButton, exitButton

    );

}


public MenuView(Stage stage) {
   components();
   properties();
   addComponents();

    VBox vBox = new VBox(pane);
    vBox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    scene = new Scene(vBox,350,600);
    stage.setTitle("Menu Page");
    stage.setScene(scene);

}

}
