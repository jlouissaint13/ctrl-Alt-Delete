package com.example.ctrlaltdelete.Login;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class LoginView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPane; //Created so I can set the children up to be in the way of rows and columns a good set up for a login page
    private Label phone,pw,forgotPassword,makeAccount;
    private TextField phoneE;
    private PasswordField passwordE;
    private Button cAccount,cGuest,show,signIn;
    private Pane pane;
    private Text sign;
    PauseTransition pause;

    // Will have all the UI components of my program
    public void components() {
        phone = new Label("Phone Number");
        phoneE = new TextField();
        phoneE.setPromptText("Phone Number");
        phoneE.setStyle("-fx-font-size: 13 comfortaa");
        pw = new Label("Password");
        passwordE = new PasswordField();
        passwordE.setPromptText("Password");
        passwordE.setStyle("-fx-font-size: 13 comfortaa");
        cAccount = new Button("Create Account");
        cGuest = new Button("Continue as Guest");
        signIn = new Button("Sign in");
        makeAccount = new Label("Don't have one? Make one!");
        forgotPassword = new Label("Forgot Password?");
        sign = new Text("Sign-In");
        sign.setStyle("-fx-font: 40 comfortaa");
        pane = new Pane();
    }

    public void properties() throws FileNotFoundException {
        // Account stuff
        cAccount.setPrefSize(150, 25);
        cGuest.setPrefSize(150, 25);
        makeAccount.setLayoutX(100);
        makeAccount.setLayoutY(380);
        cAccount.setLayoutX(90);
        cAccount.setLayoutY(403);

        // Email
        phone.setLayoutX(97);
        phone.setLayoutY(180);
        phoneE.setLayoutX(90);
        phoneE.setLayoutY(200);
        phoneE.setPrefSize(150, 25);

        // Password
        pw.setLayoutX(87);
        pw.setLayoutY(230);
        passwordE.setLayoutX(90);
        passwordE.setLayoutY(250);
        passwordE.setPrefSize(150, 25);

        // Miscellaneous
        cGuest.setLayoutX(90);
        cGuest.setLayoutY(453);
        signIn.setLayoutX(178);
        signIn.setLayoutY(300);
        signIn.setId("signIn");
        sign.setLayoutX(110);
        sign.setLayoutY(70);

        // Forgot Password (placed below the "Sign in" button)
        forgotPassword.setLayoutX(128);
        forgotPassword.setLayoutY(352);  // Adjusted Y position to place it below the "Sign in" button
        forgotPassword.setStyle("-fx-font-size: 12px; -fx-text-fill: gray");

    }
    //Will be used to add components to program;
    public void addComponents() {
        pane.getChildren().add(phoneE);
        pane.getChildren().add(passwordE);
        pane.getChildren().add(makeAccount);
        pane.getChildren().add(cAccount);
        pane.getChildren().add(cGuest);
        pane.getChildren().add(signIn);
        pane.getChildren().add(sign);
        pane.getChildren().add(forgotPassword);
    }
    public LoginView(Stage stage) throws FileNotFoundException { //initialize my login screen
        components();
        properties();
        addComponents();
        //all of this is to get the image from the resource folder and put it in the program
        InputStream inputStream = getClass().getResourceAsStream("/sliceHeaven.png");

            Image image = new Image(inputStream);

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(110);
            imageView.setFitHeight(110);
            imageView.setX(120);
            imageView.setY(85);
            pane.getChildren().add(imageView);

        VBox scene1 = new VBox(pane);
        scene = new Scene(scene1,350,600);
        stage.setTitle("Login to Slice Heaven");
        scene1.requestFocus(); //I have textPrompts for both of my textFields I am requesting focus that way both textPrompts can be seen;
        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }

    public Button getlogin() {
        return signIn;
    }
    public Button getGuest() {
        return cGuest;
    }
    public Button getcAccount() {
        return cAccount;
    }
    //Returns the user email;
    public String getPhone() {
        return phoneE.getText();
    }
    //Returns the user password
    public String getPassword() {
        return passwordE.getText();
    }
    public TextField getPhoneE() {return phoneE;}
    public TextField getPasswordE() {return  passwordE;}
    public Scene getScene() {
        stage.setTitle("Login to Slice Heaven");
        return scene;
    }
    //Displays logging in when clicking log in button
    public void displayLogin() {
        Text login = new Text("Logging in....");
        pane.getChildren().add(login);
        login.setLayoutX(88);
        login.setLayoutY(324);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(login));
        pause.play();
    }

    public void invalidPassword() {
        Text passwordInv = new Text("Invalid Password!");
        pane.getChildren().add(passwordInv);
        passwordInv.setLayoutX(40);
        passwordInv.setLayoutY(324);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(passwordInv));
        pause.play();
    }
    public void invalidAccount() {
        Text accountInv = new Text("Account does not exist!");
        pane.getChildren().add(accountInv);
        accountInv.setLayoutX(40);
        accountInv.setLayoutY(324);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(accountInv));
        pause.play();
    }
    public void displayCompleteFields() {
        Text allFields = new Text("Please complete all fields");
        pane.getChildren().add(allFields);
        allFields.setLayoutX(32);
        allFields.setLayoutY(324);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(allFields));
        pause.play();
    }
    public void displayPlaceholder() {
        Text placeholder = new Text("Does not exist XD");
        pane.getChildren().add(placeholder);
        placeholder.setLayoutX(40);
        placeholder.setLayoutY(324);
        pause = new PauseTransition(Duration.seconds(1.2));
        pause.setOnFinished(e ->pane.getChildren().remove(placeholder));
        pause.play();
    }
}