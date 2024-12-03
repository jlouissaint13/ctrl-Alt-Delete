package com.example.ctrlaltdelete.Checkout;

import com.example.ctrlaltdelete.Menu.PizzaDeliveryApp;
import com.example.ctrlaltdelete.OrderConfirmation.OrderConfirmationMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ReviewController {
    private Button placeOrder,backButton;
    private ReviewView reviewView;
    private OrderConfirmationMain orderConfirmationMain;
    private PizzaDeliveryApp pizzaDeliveryApp;
    Stage stage;

    //Starts the controller
    public ReviewController(Stage stage) throws FileNotFoundException {
        reviewView = new ReviewView(stage);
        pizzaDeliveryApp = new PizzaDeliveryApp();
        placeOrder = reviewView.getPlaceOrderButton();
        backButton = reviewView.getBackButton();

        //All actions that take place when this button is clicked
        backButton.setOnAction(actionEvent -> {
            //resets the static cost for totalCost so it doesn't save
            pizzaDeliveryApp.resetTotalCost();
            pizzaDeliveryApp.start(stage);
        });
        placeOrder.setOnAction(actionEvent -> {

            //if cash is selected as how they want to purchase then true
            reviewView.setCashTrue();
            //if carryout is selected then it will be true and the signature option will be invisible
            reviewView.setCarryOut();
            ReviewModel reviewModel = new ReviewModel(reviewView.getFirstName(), reviewView.getLastName(), reviewView.getPhoneField(), reviewView.getAddressField());
            orderConfirmationMain = new OrderConfirmationMain();
            try {
                orderConfirmationMain.start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Button is working");
        });

    }
}
