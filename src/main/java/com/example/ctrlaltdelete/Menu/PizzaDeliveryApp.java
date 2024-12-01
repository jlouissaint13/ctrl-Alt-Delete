package com.example.ctrlaltdelete.Menu;

import com.example.ctrlaltdelete.Checkout.ReviewMain;
import com.example.ctrlaltdelete.Menu.SaveFile;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class PizzaDeliveryApp extends Application {
    private ReviewMain reviewMain;
    private static double totalCost = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pizza Delivery App");

        double windowWidth = 350;
        double windowHeight = 600;

        // Labels
        Label sizeLabel = new Label("Choose Pizza Size:");
        Label crustLabel = new Label("Choose Crust Type:");
        Label toppingsLabel = new Label("Choose Toppings (Max 4):");
        Label beverageLabel = new Label("Choose Beverage and Size:");

        // Pizza Size
        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton smallSize = new RadioButton("Small ($5)");
        smallSize.setToggleGroup(sizeGroup);
        RadioButton mediumSize = new RadioButton("Medium ($8)");
        mediumSize.setToggleGroup(sizeGroup);
        RadioButton largeSize = new RadioButton("Large ($10)");
        largeSize.setToggleGroup(sizeGroup);
        RadioButton extraLargeSize = new RadioButton("Extra Large ($12)");
        extraLargeSize.setToggleGroup(sizeGroup);

        VBox sizeBox = new VBox(5, smallSize, mediumSize, largeSize, extraLargeSize);
        sizeBox.setPadding(new Insets(10, 0, 10, 0));

        // Crust Type
        ComboBox<String> crustComboBox = new ComboBox<>();
        crustComboBox.getItems().addAll("Thin Crust ($2)", "Thick Crust ($3)", "Stuffed Crust ($4)");
        crustComboBox.setPromptText("Select Crust");

        // Toppings
        CheckBox topping1 = new CheckBox("Cheese ($1)");
        CheckBox topping2 = new CheckBox("Pepperoni ($1)");
        CheckBox topping3 = new CheckBox("Mushrooms ($1)");
        CheckBox topping4 = new CheckBox("Olives ($1)");
        CheckBox topping5 = new CheckBox("Onions ($1)");
        CheckBox topping6 = new CheckBox("Green Peppers ($1)");
        CheckBox topping7 = new CheckBox("Bacon ($2)");
        CheckBox topping8 = new CheckBox("Pineapple ($2)");

        VBox toppingsBox = new VBox(5, topping1, topping2, topping3, topping4, topping5, topping6, topping7, topping8);
        toppingsBox.setPadding(new Insets(10, 0, 10, 0));

        // Toppings (selection up to 4)
        toppingsBox.getChildren().forEach(node -> {
            CheckBox checkBox = (CheckBox) node;
            checkBox.setOnAction(e -> {
                long selectedCount = toppingsBox.getChildren().stream()
                        .filter(n -> ((CheckBox) n).isSelected())
                        .count();
                if (selectedCount > 4) {
                    checkBox.setSelected(false);
                }
            });
        });

        // Beverage options and corresponding sizes
        ComboBox<String> beverageComboBox = new ComboBox<>();
        beverageComboBox.getItems().addAll("Coke ($2)", "Sprite ($2)", "Water ($1)", "Juice ($3)", "Coffee ($3)");
        beverageComboBox.setPromptText("Select Beverage");

        ToggleGroup beverageSizeGroup = new ToggleGroup();
        RadioButton smallBeverage = new RadioButton("Small");
        smallBeverage.setToggleGroup(beverageSizeGroup);
        RadioButton mediumBeverage = new RadioButton("Medium (+$1)");
        mediumBeverage.setToggleGroup(beverageSizeGroup);
        RadioButton largeBeverage = new RadioButton("Large (+$2)");
        largeBeverage.setToggleGroup(beverageSizeGroup);

        VBox beverageBox = new VBox(5, beverageComboBox, smallBeverage, mediumBeverage, largeBeverage);

        // Place order button and Output Label
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
                if (selectedSize == smallSize) totalCost += 5;
                else if (selectedSize == mediumSize) totalCost += 8;
                else if (selectedSize == largeSize) totalCost += 10;
                else if (selectedSize == extraLargeSize) totalCost += 12;
            }

            // Crust Type
            String crustType = crustComboBox.getValue();
            if (crustType != null) {
                orderDetails.append("Crust: ").append(crustType).append("\n");
                if (crustType.contains("$2")) totalCost += 2;
                else if (crustType.contains("$3")) totalCost += 3;
                else if (crustType.contains("$4")) totalCost += 4;
            }

            // Toppings
            orderDetails.append("Toppings: ");
            if (topping1.isSelected()) {
                orderDetails.append("Cheese ($1) ");
                totalCost += 1;
            }
            if (topping2.isSelected()) {
                orderDetails.append("Pepperoni ($1) ");
                totalCost += 1;
            }
            if (topping3.isSelected()) {
                orderDetails.append("Mushrooms ($1) ");
                totalCost += 1;
            }
            if (topping4.isSelected()) {
                orderDetails.append("Olives ($1) ");
                totalCost += 1;
            }
            if (topping5.isSelected()) {
                orderDetails.append("Onions ($1) ");
                totalCost += 1;
            }
            if (topping6.isSelected()) {
                orderDetails.append("Green Peppers ($1) ");
                totalCost += 1;
            }
            if (topping7.isSelected()) {
                orderDetails.append("Bacon ($2)" );
                totalCost += 2;
            }
            if (topping8.isSelected()) {
                orderDetails.append("Pineapple ($2)" );
                totalCost += 2;
            }
            orderDetails.append("\n");

            // Beverage
            String beverage = beverageComboBox.getValue();
            if (beverage != null) {
                orderDetails.append("Beverage: ").append(beverage).append(" ");
                totalCost += beverage.contains("$2") ? 2 : beverage.contains("$3") ? 3 : 1;

                RadioButton selectedBeverageSize = (RadioButton) beverageSizeGroup.getSelectedToggle();
                if (selectedBeverageSize != null) {
                    orderDetails.append("(").append(selectedBeverageSize.getText()).append(")\n");
                    if (selectedBeverageSize == mediumBeverage) totalCost += 1;
                    else if (selectedBeverageSize == largeBeverage) totalCost += 2;
                }
            }

            orderDetails.append("Total Cost: $").append(totalCost);
            SaveFile saveFile = new SaveFile();

            saveFile.saveFile(String.valueOf(orderDetails));
            outputLabel.setText(orderDetails.toString());
            reviewMain = new ReviewMain();
            try {
                reviewMain.start(primaryStage);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

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
                beverageLabel, beverageBox,
                submitButton, outputLabel
        );

        // Wrap the layout inside a ScrollPane
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);  // Ensure the content fits the width of the window
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);  // Enable vertical scrolling

        Scene scene = new Scene(scrollPane, windowWidth, windowHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public double returnTotalCost() {
        return totalCost;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
