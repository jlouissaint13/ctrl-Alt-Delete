package com.example.ctrlaltdelete.Checkout;

import com.example.ctrlaltdelete.OrderConfirmation.OrderConfirmationMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ReviewController {
    private Button placeOrder;
    private ReviewView reviewView;
    private OrderConfirmationMain orderConfirmationMain;
    Stage stage;


    public ReviewController() throws FileNotFoundException {

        reviewView = new ReviewView(stage);
        placeOrder = reviewView.getPlaceOrderButton();

        placeOrder.setOnAction(actionEvent -> {
            orderConfirmationMain = new OrderConfirmationMain();
            try {
                orderConfirmationMain.start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}
