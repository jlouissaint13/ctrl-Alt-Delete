package com.example.ctrlaltdelete.Menu;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PizzaDeliveryApp extends Application {




        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Pizza Delivery App");

            // Window Dimensions
            double windowWidth = 350;
            double windowHeight = 600;

            // Labels
            Label sizeLabel = new Label("Choose Pizza Size:");
            Label crustLabel = new Label("Choose Crust Type:");
            Label toppingsLabel = new Label("Choose Toppings:");

            // Pizza Size Options
            ToggleGroup sizeGroup = new ToggleGroup();
            RadioButton smallSize = new RadioButton("Small");
            smallSize.setToggleGroup(sizeGroup);
            RadioButton mediumSize = new RadioButton("Medium");
            mediumSize.setToggleGroup(sizeGroup);
            RadioButton largeSize = new RadioButton("Large");
            largeSize.setToggleGroup(sizeGroup);

            VBox sizeBox = new VBox(5, smallSize, mediumSize, largeSize);
            sizeBox.setPadding(new Insets(10, 0, 10, 0));

            // Crust Type Options
            ComboBox<String> crustComboBox = new ComboBox<>();
            crustComboBox.getItems().addAll("Thin Crust", "Thick Crust", "Stuffed Crust");
            crustComboBox.setPromptText("Select Crust");


            // Toppings Options
            CheckBox topping1 = new CheckBox("Cheese");
            CheckBox topping2 = new CheckBox("Pepperoni");
            CheckBox topping3 = new CheckBox("Mushrooms");
            CheckBox topping4 = new CheckBox("Olives");
            CheckBox topping5 = new CheckBox("Onions");
            VBox toppingsBox = new VBox(5, topping1, topping2, topping3, topping4, topping5);
            toppingsBox.setPadding(new Insets(10, 0, 10, 0));

            // Submit Button and Output Label
            Button submitButton = new Button("Place Order");
            submitButton.setMaxWidth(Double.MAX_VALUE);

            Label outputLabel = new Label();
            outputLabel.setWrapText(true);

            submitButton.setOnAction(e -> {
                StringBuilder orderDetails = new StringBuilder("Your Order:\n");

                // Pizza Size
                RadioButton selectedSize = (RadioButton) sizeGroup.getSelectedToggle();
                if (selectedSize != null) {
                    orderDetails.append("Size: ").append(selectedSize.getText()).append("\n");
                }

                // Crust Type
                String crustType = crustComboBox.getValue();
                if (crustType != null) {
                    orderDetails.append("Crust: ").append(crustType).append("\n");
                }



                // Toppings
                orderDetails.append("Toppings: ");
                if (topping1.isSelected()) orderDetails.append("Cheese ");
                if (topping2.isSelected()) orderDetails.append("Pepperoni ");
                if (topping3.isSelected()) orderDetails.append("Mushrooms ");
                if (topping4.isSelected()) orderDetails.append("Olives ");
                if (topping5.isSelected()) orderDetails.append("Onions ");

                outputLabel.setText(orderDetails.toString());
            });

            // Layout
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(15));
            layout.setAlignment(Pos.TOP_CENTER);
            layout.setPrefSize(windowWidth, windowHeight);

            layout.getChildren().addAll(
                    sizeLabel, sizeBox,
                    crustLabel, crustComboBox,
                    toppingsLabel, toppingsBox,
                    submitButton, outputLabel
            );

            // Scene and Stage
            Scene scene = new Scene(layout, windowWidth, windowHeight);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
