package com.example.ctrlaltdelete.Menu;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.synedra.validatorfx.Check;

import java.io.InputStream;


public class MenuView {
    private Pane pane;
    private Text headerText;
    private Label name,phone,price,allDrinks,drinkSizes;
    private TextField nameField, phoneField, priceField;
    private RadioButton smallSize, mediumSize, largeSize,pickup,delivery;
    private CheckBox pepperoni, hamburger, sausage, canadianBacon, chicken, greenPeppers, redPeppers, onions, mushrooms, blackOlives;
    private Button placeOrderButton, exitButton,plus,minus;
    private Scene scene;
    private Line line;
    ObservableList<String> Drinks =
            FXCollections.observableArrayList(
                    "Sprite",
                    "Coke",
                    "Fanta Orange",
                    "Lemonade",
                    "Pepsi",
                    "None"
            );
    final ComboBox comboBox = new ComboBox(Drinks);
    ObservableList<String> DrinksSize =
            FXCollections.observableArrayList(
                 "Small",
                    "Medium",
                    "Large"
            );
    final ComboBox drinkSize = new ComboBox(DrinksSize);
    //Here you will initialize your components
public void components() {
    //word = new word("Word");
    pane = new Pane();
    //Combo Box beverages

    // Adding header text
    headerText = new Text("Menu");

    //Labels
    name = new Label("Name*");
    phone = new Label("Phone*");
    drinkSizes = new Label("Drinks");
    allDrinks = new Label("Drinks Sizes");

    //Line
    line = new Line();
    line.setStartX(20);
    line.setEndX(1000);
    line.setStartX(0);
    line.setEndY(0);

    // Text fields
    nameField = new TextField();
    phoneField = new TextField();
    priceField = new TextField();
    priceField.setEditable(false);

    //RadioButtons for pickup or delivery
    pickup = new RadioButton("Carryout");
    delivery = new RadioButton("Delivery");

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

    //calculateButton = new Button("Calculate");
    placeOrderButton = new Button("Place Order");
    exitButton = new Button("Exit");
    plus = new Button("+");
    minus = new Button("-");
    plus.setId("plus");
    minus.setId("minus");


}

//Decide the properties size and where they go
public void properties() {
    // Header properties
    headerText.setLayoutX(250);
    headerText.setLayoutY(40);

    // Name and phone fields
    name.setLayoutX(20);
    name.setLayoutY(22);
    nameField.setLayoutX(20);
    nameField.setLayoutY(40);
    nameField.setPromptText("Name:");
    phone.setLayoutX(20);
    phone.setLayoutY(92);
    phoneField.setLayoutX(20);
    phoneField.setLayoutY(110);
    phoneField.setPromptText("Phone Number:");


    //Line
    line.setLayoutX(0);
    line.setLayoutY(500);

    //Pickup or Delivery
    pickup.setLayoutX(20);
    pickup.setLayoutY(165);
    delivery.setLayoutX(100);
    delivery.setLayoutY(165);

    // Pizza size
    smallSize.setLayoutX(20);
    smallSize.setLayoutY(195);
    mediumSize.setLayoutX(100);
    mediumSize.setLayoutY(195);
    largeSize.setLayoutX(180);
    largeSize.setLayoutY(195);

    // Toppings
    pepperoni.setLayoutX(20);
    pepperoni.setLayoutY(230);
    hamburger.setLayoutX(150);
    hamburger.setLayoutY(230);
    sausage.setLayoutX(20);
    sausage.setLayoutY(270);
    canadianBacon.setLayoutX(150);
    canadianBacon.setLayoutY(270);
    chicken.setLayoutX(20);
    chicken.setLayoutY(310);
    greenPeppers.setLayoutX(150);
    greenPeppers.setLayoutY(310);
    redPeppers.setLayoutX(20);
    redPeppers.setLayoutY(350);
    onions.setLayoutX(150);
    onions.setLayoutY(350);


    //Beverages
    drinkSizes.setLayoutX(150);
    drinkSizes.setLayoutY(380);
    allDrinks.setLayoutX(20);
    allDrinks.setLayoutY(380);
    drinkSize.setLayoutX(20);
    drinkSize.setLayoutY(400);
    comboBox.setLayoutX(150);
    comboBox.setLayoutY(400);


    plus.setLayoutX(260);
    plus.setLayoutY(438);
    minus.setLayoutX(20);
    minus.setLayoutY(438);
    priceField.setLayoutX(80);
    priceField.setLayoutY(435);
    priceField.setPromptText("Price:");

    // Buttons

    placeOrderButton.setLayoutX(85);
    placeOrderButton.setLayoutY(530);
    exitButton.setLayoutX(200);
    exitButton.setLayoutY(520);

    //image
    InputStream inputStream = getClass().getResourceAsStream("/sliceHeaven.png");

    Image image = new Image(inputStream);

    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(110);
    imageView.setFitHeight(110);
    imageView.setX(210);
    imageView.setY(40);
    pane.getChildren().add(imageView);


}
//This one is for adding elements to the pane
public void addComponents() {
    // Add header and subheader
    pane.getChildren().addAll(
            headerText, nameField, phoneField,
            smallSize, mediumSize, largeSize,
            pepperoni, hamburger, sausage, canadianBacon, chicken, greenPeppers,
            redPeppers, onions,
            priceField,  placeOrderButton,pickup,delivery,name,phone,line,comboBox,drinkSize,drinkSizes,allDrinks,plus,minus

    );

}

    public Button getPlus() {
    return plus;
    }
    public Button getMinus() {
    return minus;
    }
    //All checkbox buttons
    public CheckBox getPepperoni() {
        return pepperoni;
    }
    public CheckBox getHamburger() {
        return hamburger;

    }
    public CheckBox getSausage() {
    return sausage;
    }
    public CheckBox getCanadianBacon() {
    return canadianBacon;
    }
    public CheckBox getGreenPeppers() {
    return greenPeppers;
    }
    public CheckBox getOnions() {
    return onions;
    }
    public CheckBox getRedPeppers() {
    return redPeppers;
    }
    public CheckBox getChicken() {
    return chicken;
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
