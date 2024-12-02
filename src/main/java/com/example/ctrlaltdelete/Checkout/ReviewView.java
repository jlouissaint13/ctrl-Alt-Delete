package com.example.ctrlaltdelete.Checkout;

import java.io.FileNotFoundException;

import com.example.ctrlaltdelete.Login.LoginModel;
import com.example.ctrlaltdelete.Menu.PizzaDeliveryApp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReviewView {
    private Pane pane;
    private Scene scene;
    private Stage stage;
    private VBox root;  // This is the root container for the ScrollPane
    private ReviewModel reviewModel;
    private LoginModel loginModel;
    private PizzaDeliveryApp pizzaDeliveryApp;
    private Button placeOrderButton,backButton;
    private RadioButton cardPaymentButton,cashPaymentButton;
    private static boolean target;
    public void components() throws FileNotFoundException {
        pizzaDeliveryApp = new PizzaDeliveryApp();
        double totalCost = pizzaDeliveryApp.returnTotalCost();

        // Initialize the VBox root layout to contain all UI components
        root = new VBox(15); // 15 is the spacing between components in VBox
        root.setPadding(new Insets(20));
        reviewModel = new ReviewModel();
        loginModel = new LoginModel();

        // Header Section
        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        backButton = new Button("Back");
        backButton.setId("back");
        Label titleLabel = new Label("Review Page");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        headerBox.getChildren().addAll(backButton, titleLabel);

        // My Order Section
        VBox orderBox = new VBox(10);
        orderBox.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");
        orderBox.setPadding(new Insets(10));
        Label orderLabel = new Label("My Order");
        TextArea orderDetailsArea = new TextArea();

        orderDetailsArea.setText(reviewModel.orderDetails());
        orderDetailsArea.setEditable(false);


        orderBox.getChildren().addAll(orderLabel, orderDetailsArea);

        // Contact Info Section
        VBox contactInfoBox = new VBox(10);
        contactInfoBox.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");
        contactInfoBox.setPadding(new Insets(10));
        Label contactInfoLabel = new Label("Contact Info");
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");
        if (loginModel.getfName() != null) {
            firstNameField.setText(loginModel.getfName());
        }

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");
        if (loginModel.getlName() != null) lastNameField.setText(loginModel.getlName());
        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone Number");
        if (loginModel.getPhone() != null) phoneField.setText(loginModel.getPhone()) ;
        contactInfoBox.getChildren().addAll(contactInfoLabel, firstNameField, lastNameField, phoneField);

        // Carryout/Delivery Section
        VBox deliveryBox = new VBox(10);
        deliveryBox.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");
        deliveryBox.setPadding(new Insets(10));
        Label deliveryLabel = new Label("Carryout/Delivery");

        HBox deliveryActionsBox = new HBox(10);
        RadioButton deliveryButton = new RadioButton("Delivery");
        RadioButton carryoutButton = new RadioButton("Carryout");
        ToggleGroup deliveryGroup = new ToggleGroup();
        deliveryButton.setToggleGroup(deliveryGroup);
        carryoutButton.setToggleGroup(deliveryGroup);
        carryoutButton.setSelected(true); // Default to Carryout

        // Location message for Carryout
        Label carryoutLocationLabel = new Label("Ready in 20-30 minutes");
        Label carryoutLocationLabel1 = new Label("6383 DeerSprings Dr, Atlanta, GA 30033");
        Label carryoutLocationLabel2 = new Label("Phone Number #: 777-777-7770");

        // Fields for Delivery address input (initially hidden)
        Label streetAddressLabel = new Label("Street Address:");
        TextField streetAddressField = new TextField();
        streetAddressField.setPromptText("Enter Street Address");

        Label cityStateZipLabel = new Label("City, State, Zip Code:");
        TextField cityField = new TextField();
        cityField.setPromptText("Enter City");

        TextField stateField = new TextField();
        stateField.setPromptText("Enter State");

        TextField zipField = new TextField();
        zipField.setPromptText("Enter Zip Code");

        // Organizing Carryout/Delivery actions
        deliveryActionsBox.getChildren().addAll(deliveryButton, carryoutButton);

        // Add everything to the deliveryBox
        deliveryBox.getChildren().addAll(deliveryLabel, deliveryActionsBox, carryoutLocationLabel, carryoutLocationLabel1,carryoutLocationLabel2,
                streetAddressLabel, streetAddressField, cityStateZipLabel,
                cityField, stateField, zipField);

        // Initially, hide the delivery address fields
        streetAddressLabel.setVisible(false);
        streetAddressField.setVisible(false);
        cityStateZipLabel.setVisible(false);
        cityField.setVisible(false);
        stateField.setVisible(false);
        zipField.setVisible(false);

        // Adjust size based on delivery/carryout selection
        deliveryBox.setMinHeight(100);  // Set a minimum height for the box
        deliveryBox.setMaxHeight(190);  // Set a maximum height for the box when Carryout is selected

        // Listener to toggle between Carryout and Delivery
        deliveryGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == carryoutButton) {
                // Show Carryout location and hide address fields without leaving empty space
                carryoutLocationLabel.setVisible(true);
                carryoutLocationLabel1.setVisible(true);
                carryoutLocationLabel2.setVisible(true);
                carryoutLocationLabel.setManaged(true);
                carryoutLocationLabel1.setManaged(true);
                carryoutLocationLabel2.setManaged(true);

                streetAddressLabel.setVisible(false);
                streetAddressField.setVisible(false);
                cityStateZipLabel.setVisible(false);
                cityField.setVisible(false);
                stateField.setVisible(false);
                zipField.setVisible(false);

                streetAddressLabel.setManaged(false);
                streetAddressField.setManaged(false);
                cityStateZipLabel.setManaged(false);
                cityField.setManaged(false);
                stateField.setManaged(false);
                zipField.setManaged(false);

                // Shrink the box size for Carryout only
                deliveryBox.setMinHeight(100);  // Reduce to a smaller height for carryout
                deliveryBox.setMaxHeight(190);  // Shrink the box's height when only carryout is selected
            } else {
                // Hide Carryout location and show address fields for Delivery
                carryoutLocationLabel.setVisible(false);
                carryoutLocationLabel1.setVisible(false);
                carryoutLocationLabel2.setVisible(false);
                carryoutLocationLabel.setManaged(false);
                carryoutLocationLabel1.setManaged(false);
                carryoutLocationLabel2.setManaged(false);

                streetAddressLabel.setVisible(true);
                streetAddressField.setVisible(true);
                if (loginModel.getAddress() != null) streetAddressField.setText(loginModel.getAddress());
                cityStateZipLabel.setVisible(true);
                cityField.setVisible(true);
                stateField.setVisible(true);
                zipField.setVisible(true);

                streetAddressLabel.setManaged(true);
                streetAddressField.setManaged(true);
                cityStateZipLabel.setManaged(true);
                cityField.setManaged(true);
                stateField.setManaged(true);
                zipField.setManaged(true);
            }


            // Adjust the size back for Delivery, showing all address fields
                deliveryBox.setMinHeight(200);  // Expand the box when delivery fields are shown
                deliveryBox.setMaxHeight(379);  // Adjust max height when delivery is selected
        });

        // Payment Section
        VBox paymentBox = new VBox(15); // Increased spacing for better separation between elements
        paymentBox.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");
        paymentBox.setPadding(new Insets(10));
        Label paymentLabel = new Label("Payment");
        paymentLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        ToggleGroup paymentGroup = new ToggleGroup();
        cardPaymentButton = new RadioButton("Card/Debit");
        cashPaymentButton = new RadioButton("Cash");
        cardPaymentButton.setToggleGroup(paymentGroup);
        cashPaymentButton.setToggleGroup(paymentGroup);
        cardPaymentButton.setSelected(true);

        // HBox for card payment fields
        HBox cardFieldsBox = new HBox(15);  // Increased spacing between fields
        cardFieldsBox.setAlignment(Pos.CENTER_LEFT);
        Label nameOnCardLabel = new Label("Name on Card:");
        TextField nameOnCardField = new TextField();
        nameOnCardField.setPrefWidth(150);
        nameOnCardField.setId("nameCard");

        Label cardNumberLabel = new Label("Card Number:");
        TextField cardNumberField = new TextField();
        cardNumberField.setPrefWidth(150);
        cardNumberField.setId("cardNumber");
        Label mmLabel = new Label("MM/YY:");
        TextField mmField = new TextField();
        mmField.setPrefWidth(65);
        mmField.setId("mm");
        Label cardzipLabel = new Label("Zip Code:");
        TextField cardzipField = new TextField();
        cardzipField.setPrefWidth(70);
        cardzipField.setId("cardzipField");
        Label cvvLabel = new Label("CVV:");
        TextField cvvField = new TextField();
        cvvField.setPrefWidth(40);
        cvvField.setId("cvvField");
        // Organizing card fields in a grid-like format
        VBox cardDetailsBox = new VBox(10);  // Adding more vertical space
        cardDetailsBox.getChildren().addAll(
                new HBox(4, nameOnCardLabel, nameOnCardField),
                new HBox(10, cardNumberLabel, cardNumberField),
                new HBox(10, mmLabel, mmField, cardzipLabel, cardzipField),
                new HBox(28, cvvLabel, cvvField)
        );

        // HBox for cash payment (Smaller size when Cash is selected)
        HBox cashBox = new HBox(10); // Reduced spacing between elements in the cash section

        // Add the agreement text below the Cash button
        Label agreementLabel = new Label("You agree to pay with cash when you arrive.");
        agreementLabel.setStyle("-fx-font-weight: bold;");  // Set text to bold
        cashBox.getChildren().add(agreementLabel);  // Add agreement text inside the cash box

        // Add radio buttons and the payment details into the payment section
        paymentBox.getChildren().addAll(paymentLabel, cardPaymentButton, cashPaymentButton, cardDetailsBox, cashBox);

        // Initially, show card fields and hide cash box
        cardDetailsBox.setVisible(true);
        cashBox.setVisible(false);

        // Listener to toggle between card and cash payment options
        paymentGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == cardPaymentButton) {
                cardDetailsBox.setVisible(true);
                cashBox.setVisible(false);
            } else {
                cardDetailsBox.setVisible(false);
                cashBox.setVisible(true);
            }
        });

        // Total Price Section
        VBox priceBox = new VBox(10);
        priceBox.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");
        priceBox.setPadding(new Insets(10));
        double tax = 0.08 * totalCost;
        Label priceLabel = new Label("Final Price");
        Label subtotalLabel = new Label("Subtotal:    $" + String.format("%.2f", totalCost));
        Label taxLabel = new Label("Tax:          $" + String.format("%.2f", tax));
        totalCost += tax;
        Label totalLabel = new Label("Total:        $" + String.format("%.2f", totalCost));

        priceBox.getChildren().addAll(priceLabel, subtotalLabel, taxLabel, totalLabel);

        // Place Order Button
        placeOrderButton = new Button("Place Order");

        // Add all sections to the root layout
        root.getChildren().addAll(
                headerBox,
                orderBox,
                contactInfoBox,
                deliveryBox,
                paymentBox,
                priceBox,
                placeOrderButton
        );

        // Adjust visibility based on payment type selection
        paymentGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == cardPaymentButton) {
                cardFieldsBox.setVisible(true);
                cashBox.setVisible(false);
            } else {
                cardFieldsBox.setVisible(false);
                cashBox.setVisible(true);
            }
        });
    }
    public void cashSelected() {
        if (cashPaymentButton.isSelected()) target = true;
    }

    public void properties() {
        // Customize properties of the scene or other components if needed
    }

    public void addComponents() {
        // You could add additional logic here if needed
    }
    public Button getPlaceOrderButton() {
        return placeOrderButton;
    }
    public Button getBackButton() {
        return backButton;
    }
    public ReviewView(Stage stage) throws FileNotFoundException {
        components();
        properties();
        addComponents();

        //Wrap the VBox root in a ScrollPane
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true); // Ensures content width matches the ScrollPane width
        scrollPane.setPadding(new Insets(10));  // Padding inside the ScrollPane
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);  // Ensure vertical scrollbar is always enabled

        //Set up the scene with the ScrollPane
        scene = new Scene(scrollPane, 350, 600); // Scrollable area
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Review Page");
        stage.setScene(scene);
    }
}