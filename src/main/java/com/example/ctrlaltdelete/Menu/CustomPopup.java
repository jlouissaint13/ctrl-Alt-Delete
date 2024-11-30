package com.example.ctrlaltdelete.Menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomPopup extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button showPopupButton = new Button("Show Popup");
        showPopupButton.setOnAction(e -> showPopup(primaryStage));

        VBox layout = new VBox(10, showPopupButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Popup Example");
        primaryStage.show();
    }

    private void showPopup(Stage owner) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(owner);

        // Circle with checkmark
        Circle circle = new Circle(40, Color.LIGHTGREEN);
        circle.setStroke(Color.DARKGREEN);

        Text checkmark = new Text("✔");
        checkmark.setFont(Font.font("Arial", 40));
        checkmark.setFill(Color.DARKGREEN);

        // Added! text
        Text addedText = new Text("ADDED!");
        addedText.setFont(Font.font("Arial", 20));
        addedText.setStyle("-fx-font-weight: bold;");

        // Buttons for Menu and Checkout
        Button menuButton = new Button("MENU");
        Button checkoutButton = new Button("CHECKOUT");

        menuButton.setOnAction(e -> popupStage.close());
        checkoutButton.setOnAction(e -> System.out.println("Proceeding to Checkout..."));

        VBox popupLayout = new VBox(10, circle, checkmark, addedText, menuButton, checkoutButton);
        popupLayout.setStyle(
                "-fx-alignment: center; " +
                        "-fx-padding: 20; " +
                        "-fx-background-color: white; " +
                        "-fx-border-color: black; " +
                        "-fx-border-width: 2;"
        );

        Scene popupScene = new Scene(popupLayout, 300, 500);
        popupStage.setScene(popupScene);
        popupStage.setTitle("Popup");
        popupStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}