package com.example.ctrlaltdelete.OrderConfirmation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;




public class OrderConfirmationMain extends Application {




    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage orderConfirmationPage) throws Exception {

        //adding labels
        Label orderConfirmation = new Label("Order Confirmation");
        Label orderNumber = new Label("Order #: 000000000000");
        Label orderDate = new Label("Order Date: 00/00/00");
        Label orderTotal = new Label("Order Total");
        Label subTotal = new Label("Sub Total: $0.00");
        Label tax = new Label("Tax: $0.00");
        Label total = new Label("Total: $0.00");
        Label orderSummary = new Label("Order Summary");
        Label orderItems = new Label("Order Items");
        Label orderItemsList = new Label("Order Items List");

        //adding button
        Button button = new Button("Return to Homepage");

        //aligning labels
        orderConfirmation.setTranslateY(-30);
        orderConfirmation.setTranslateX(40);

        orderNumber.setTranslateY(-35);
        orderNumber.setTranslateX(10);

        orderDate.setTranslateY(-35);
        orderDate.setTranslateX(10);

        orderTotal.setTranslateY(-35);
        orderTotal.setTranslateX(8);

        subTotal.setTranslateY(-35);
        subTotal.setTranslateX(10);

        tax.setTranslateY(-35);
        tax.setTranslateX(10);

        total.setTranslateY(-35);
        total.setTranslateX(10);

        orderSummary.setTranslateY(-35);
        orderSummary.setTranslateX(8);

        orderItems.setTranslateY(-35);
        orderItems.setTranslateX(10);

        orderItemsList.setTranslateY(-35);
        orderItemsList.setTranslateX(10);

        //aligning button
        button.setTranslateY(20);
        button.setTranslateX(70);
        button.setPrefHeight(70);
        button.setPrefWidth(190);

        //setting button action
        //button.setOnAction(actionEvent -> orderConfirmation.setScene("Goes Home"));


        //setting font size for elements
        orderConfirmation.setStyle("-fx-font-size: 30px;");
        orderTotal.setStyle("-fx-font-size: 23px;");
        orderNumber.setStyle("-fx-font-size: 15px;");
        orderDate.setStyle("-fx-font-size: 15px;");
        subTotal.setStyle("-fx-font-size: 15px;");
        tax.setStyle("-fx-font-size: 15px;");
        total.setStyle("-fx-font-size: 15px;");
        orderSummary.setStyle("-fx-font-size: 23px;");
        orderItems.setStyle("-fx-font-size: 15px;");
        orderItemsList.setStyle("-fx-font-size: 15px;");

        //adding images
        Image logo = new Image("file:/C:/Users/ColinPC/Pictures/Saved Pictures/sliceHeaven.png/");
        ImageView logoView = new ImageView(logo);

        //aligning image
        logoView.setImage(logo);
        logoView.setTranslateY(-5);
        logoView.setTranslateX(115);
        logoView.setFitHeight(100);
        logoView.setFitWidth(100);

        //adding lines
        //Line line = new Line(0,100,300,100);
        //line.setStartX(0.0);
        //line.setStartY(0.0);
        // line.setEndX(0.0);
        //line.setEndY(0.0);

        //line.setStroke(Color.BLACK);
        //line.setStrokeWidth(2);

        // line.setStartY(line.getStartY() + 50); // Move up by 20 pixels
        // line.setEndY(line.getEndY() + 50);     // Move up by 20 pixels

        //Line line2 = new Line(0,-100,300,-100);


//takes text fields from checkout and updates them for order confirmation
            //orderNumber.setText("pulled from class");
            //orderDate.setText("pulled from class");
            // orderTotal.setText("pulled from class");
            //subTotal.setText("pulled from class");
            //tax.setText("pulled from class");
            //total.setText("pulled from class");
            // orderItemsList.setText("pulled from class");

        //creating vbox for scene creation
        Pane pane = new VBox(10,logoView,orderConfirmation,orderNumber,orderDate,orderTotal,subTotal,tax,total,orderSummary,orderItems,orderItemsList,button);
             //pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color:#FEFFFF");






        //adding pizza logo to scene





        Scene scene = new Scene(pane,350,600);

        orderConfirmationPage.setScene(scene);
        orderConfirmationPage.setTitle("Order Confirmation Page");

        orderConfirmationPage.getIcons().add(logo);
        orderConfirmationPage.show();

    }
}