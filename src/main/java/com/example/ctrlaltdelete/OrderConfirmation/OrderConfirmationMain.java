package com.example.ctrlaltdelete.OrderConfirmation;

import com.example.ctrlaltdelete.Checkout.ReviewModel;
import com.example.ctrlaltdelete.Checkout.ReviewView;
import com.example.ctrlaltdelete.Login.LoginMain;
import com.example.ctrlaltdelete.Login.LoginModel;
import com.example.ctrlaltdelete.Login.LoginView;
import com.example.ctrlaltdelete.Menu.PizzaDeliveryApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.shape.Line;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.io.FileNotFoundException;

import java.util.Objects;


public class OrderConfirmationMain extends Application {

private PizzaDeliveryApp pizzaDeliveryApp;
LoginMain loginMain;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage orderConfirmationPage) throws Exception {
//creating instances of helper classes
        pizzaDeliveryApp = new PizzaDeliveryApp();
        LoginView loginView = new LoginView(orderConfirmationPage);
        LoginModel loginModel = new LoginModel();
        ReviewView reviewView2 = new ReviewView(orderConfirmationPage);
        ReviewModel reviewModel1 = new ReviewModel();

//variables for total
        double subTotalOut = pizzaDeliveryApp.returnTotalCost();
        double taxTotal = subTotalOut * 0.08;
        double totalCost = subTotalOut + taxTotal;

        String formatSubTotalOut = String.format("%.2f", subTotalOut);
        String formatTax = String.format("%.2f", taxTotal);
        String formatTotalCost = String.format("%.2f", totalCost);


//adding labels
        Label orderConfirmation = new Label("Order Confirmation");
        Label orderNumber;
        Label orderDate;
        Label orderTotal = new Label("Order Total");
        Label subTotal = new Label("Sub Total: $0.00");
        Label tax = new Label("Tax: $0.00");
        Label total = new Label("Total: $0.00");
        Label orderSummary = new Label("Order Summary");
        Label orderItems = new Label("Order Items");
        Label orderItemsList = new Label("Order Items List");
        Label signHere = new Label("Sign Here:");
        Label customerFirstName = new Label(loginModel.getfName());
        Label customerLastName = new Label(loginModel.getlName());
        Label customerEmail = new Label(loginModel.getEmail());
        Label customerPhone = new Label(loginModel.getPhone());
        Label customerAddress = new Label(loginModel.getAddress());
        Label yourInformation = new Label("Your Information");
        Label deliveryOrCarryout = new Label("Delivery");

//formatting all totals
        subTotal.setText("Sub Total: $" + formatSubTotalOut);
        tax.setText("Tax: $" + formatTax);
        total.setText("Total: $" + formatTotalCost);

//creating random number for order#
        Random r = new Random();
        int randomNumber = r.nextInt(1000000000);
        orderNumber = new Label("Order #: "+ randomNumber);

//getting local time
        LocalDateTime myObj = LocalDateTime.now();
        Instant now = Instant.now();

//formatting local date
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = localDateTime.format(formatter);
        orderDate = new Label("Order Date: "+ formattedDate);



        Button button = new Button("Homepage");

//aligning labels
        orderConfirmation.setTranslateY(120);
        orderConfirmation.setTranslateX(40);

        orderNumber.setTranslateY(180);
        orderNumber.setTranslateX(10);

        orderDate.setTranslateY(210);
        orderDate.setTranslateX(10);

        orderTotal.setTranslateY(240);
        orderTotal.setTranslateX(8);

        subTotal.setTranslateY(280);
        subTotal.setTranslateX(10);

        tax.setTranslateY(310);
        tax.setTranslateX(10);

        total.setTranslateY(340);
        total.setTranslateX(10);

        orderSummary.setTranslateY(360);
        orderSummary.setTranslateX(8);

        orderItems.setTranslateY(-35);
        orderItems.setTranslateX(10);

        orderItemsList.setTranslateY(410);
        orderItemsList.setTranslateX(10);

        signHere.setTranslateY(620);
        signHere.setTranslateX(30);

        yourInformation.setTranslateY(520);
        yourInformation.setTranslateX(10);

        customerFirstName.setTranslateY(535);
        customerFirstName.setTranslateX(10);

        customerLastName.setTranslateY(550);
        customerLastName.setTranslateX(10);

        customerEmail.setTranslateY(565);
        customerEmail.setTranslateX(10);

        customerPhone.setTranslateY(580);
        customerPhone.setTranslateX(10);

        customerAddress.setTranslateY(595);
        customerAddress.setTranslateX(10);

        deliveryOrCarryout.setTranslateY(410);
        deliveryOrCarryout.setTranslateX(65);

//aligning button
        button.setTranslateY(650);
        button.setTranslateX(90);
        button.setPrefHeight(40);
        button.setPrefWidth(150);

//Setting font size for elements
        orderConfirmation.setStyle("-fx-font-size: 30px;");
        orderTotal.setStyle("-fx-font-size: 23px;");
        orderNumber.setStyle("-fx-font-size: 15px;");
        orderDate.setStyle("-fx-font-size: 15px;");
        subTotal.setStyle("-fx-font-size: 15px;");
        tax.setStyle("-fx-font-size: 15px;");
        total.setStyle("-fx-font-size: 15px;");
        orderSummary.setStyle("-fx-font-size: 23px;");
        orderItems.setStyle("-fx-font-size: 15px;");
        orderItemsList.setStyle("-fx-font-size: 10px;");
        customerFirstName.setStyle("-fx-font-size: 10px;");
        customerLastName.setStyle("-fx-font-size: 10px;");
        customerEmail.setStyle("-fx-font-size: 10px;");
        customerPhone.setStyle("-fx-font-size: 10px;");
        customerAddress.setStyle("-fx-font-size: 10px;");
        yourInformation.setStyle("-fx-font-size: 10px;");
        deliveryOrCarryout.setStyle("-fx-font-size: 10px;");

//adding logo image
        Image logo = new Image("sliceHeaven.png");
        ImageView logoView = new ImageView(logo);

//aligning image
        logoView.setImage(logo);
        logoView.setTranslateY(-5);
        logoView.setTranslateX(100);
        logoView.setFitHeight(140);
        logoView.setFitWidth(140);

//adding lines
        Line line = new Line(20,170,320,170);
        Line line2 = new Line(0,275,200,275);
        Line line3 = new Line(0,400,200,400);
        Line signature = new Line(100,640,250,640);

//functionality for button returning to homepage
        loginMain = new LoginMain();
        button.setOnAction( actionEvent -> {

            try {
                loginMain.start(orderConfirmationPage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

//creating vbox and pane for scene creation
        Pane pane = new Pane();
        VBox vbox = new VBox();

//adding all scene elements to pane
        pane.getChildren().add(logoView);
        pane.getChildren().add(orderConfirmation);
        pane.getChildren().add(orderNumber);
        pane.getChildren().add(orderDate);
        pane.getChildren().add(orderTotal);
        pane.getChildren().add(subTotal);
        pane.getChildren().add(tax);
        pane.getChildren().add(total);
        pane.getChildren().add(orderSummary);
        pane.getChildren().add(orderItems);
        pane.getChildren().add(orderItemsList);
        pane.getChildren().add(button);
        pane.getChildren().add(line);
        pane.getChildren().add(line2);
        pane.getChildren().add(line3);
        pane.getChildren().add(signature);
        pane.getChildren().add(signHere);
        pane.getChildren().add(customerFirstName);
        pane.getChildren().add(customerLastName);
        pane.getChildren().add(customerEmail);
        pane.getChildren().add(customerPhone);
        pane.getChildren().add(customerAddress);
        pane.getChildren().add(yourInformation);
        pane.getChildren().add(deliveryOrCarryout);

//turning off signature if paying with cash
        if (reviewView2.getCashTrue()){
            signature.setVisible(false);
            signHere.setVisible(false);
        }

//recieving order items
        orderItemsList.setText(reviewModel1.orderDetails());

//getting customer information through guest login
        reviewModel1.getfName();
        reviewModel1.getlName();
        reviewModel1.getPhoneNumber();
        loginModel.getAddress();
        customerFirstName.setText(reviewModel1.getfName());
        customerLastName.setText(reviewModel1.getlName());
        customerPhone.setText(reviewModel1.getPhoneNumber());
        customerAddress.setText(reviewModel1.getAddress());

//sets to carry out if carry out is selected
        if(reviewView2.getCarryOut()){
            deliveryOrCarryout.setText("Carry out");
        }

//resets all info for when customer goes back to homepage
        reviewView2.resetCarryout();
        pizzaDeliveryApp.resetTotalCost();
        reviewView2.resetCash();
        loginModel.resetInfo();
        reviewModel1.resetloginGuest();

//adding pane to vbox and styling scene and stage
        vbox.getChildren().add(pane);
        vbox.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        vbox.setPrefHeight(700);
        Scene scene = new Scene(scrollPane,350,600);
        orderConfirmationPage.setScene(scene);
        orderConfirmationPage.setTitle("Order Confirmation Page");
        Image image = new Image("sliceHeaven.png");

//adding logo onto stage
        orderConfirmationPage.getIcons().add(image);
        orderConfirmationPage.getIcons().add(logo);
        orderConfirmationPage.show();

    }
}