package com.example.ctrlaltdelete.Login;

import com.example.ctrlaltdelete.Login.ValidationException.EmailValidation;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.InputStream;


public class CreationView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPaneL;
    private Pane pane;
    private Label fName,lName,email,pw,phoneNumber;
    private Text createAccount,required,accountExists,invalidEmail,invalidPhoneNumber,inputValidation;
    private TextField fNameE,lNameE,emailE,passwordE,phoneNumberE;
    private Button cAccount,test,backButton;
    private Line line;
    private Image home,logo;
    private InputStream inputStreamLogo, inputStreamHome;
    private PauseTransition pause;
        //All variables with e at the end means that it is the variable for the textfield;
    public void components() {
        pane = new Pane();
        createAccount = new Text("Create Account");
        fName = new Label("First Name*");
        fNameE = new TextField();
        lName = new Label("Last Name*");
        lNameE = new TextField();
        email = new Label("Email*");
        emailE = new TextField();
        pw = new Label("Password*");
        passwordE = new TextField();
        phoneNumber = new Label("Phone Number*");
        phoneNumberE = new TextField();
        cAccount = new Button("Create Account");
        line = new Line(0,0,500,0);
        required = new Text("*Required Field");
        accountExists = new Text("Account Exists");
        backButton = new Button();
        inputStreamLogo = getClass().getResourceAsStream("/sliceHeaven.png");
        inputStreamHome = getClass().getResourceAsStream("/home.png");
        logo = new Image(inputStreamLogo);
        home = new Image(inputStreamHome);
        invalidPhoneNumber = new Text("Invalid Phone Number");
        invalidEmail = new Text("Invalid email");
        inputValidation = new Text("Please complete all fields");
    }
    public void properties() {
        //fname
        fNameE.setMaxWidth(117);
        fName.setLayoutX(25);
        fName.setLayoutY(100);
        fNameE.setLayoutX(25);
        fNameE.setLayoutY(120);
        //Their are ids for fname and last because i needed to make them smaller in the css styling
        fNameE.setId("fnameE");
        //lname
        lName.setLayoutX(200);
        lName.setLayoutY(100);
        lNameE.setPrefWidth(117);
        lNameE.setLayoutX(200);
        lNameE.setLayoutY(120);
        lNameE.setId("lnameE");

        //email

        emailE.setMinWidth(292);
        email.setLayoutX(25);
        email.setLayoutY(175);
        emailE.setLayoutX(25);
        emailE.setLayoutY(195);

        //password

        passwordE.setMinWidth(292);
        pw.setLayoutX(25);
        pw.setLayoutY(250);
        passwordE.setLayoutX(25);
        passwordE.setLayoutY(270);
        //phonenumber
        phoneNumberE.setMinWidth(292);
        phoneNumber.setLayoutX(25);
        phoneNumber.setLayoutY(325);
        phoneNumberE.setLayoutX(25);
        phoneNumberE.setLayoutY(345);

        //miscellaneous
        line.setTranslateY(430);
        cAccount.setLayoutX(88);
        cAccount.setLayoutY(480);
        cAccount.setMinSize(130,70);
        cAccount.setId("cAccount");
        createAccount.setLayoutX(60);
        createAccount.setLayoutY(75);
        createAccount.setStyle("-fx-font: 25 Comfortaa;");
        required.setStyle("-fx-font: 13 Comfortaa;");
        accountExists.setLayoutX(25);
        accountExists.setLayoutY(300);
        required.setLayoutX(25);
        required.setLayoutY(420);
        backButton.setId("backButton");


        //image
        

            ImageView imageView = new ImageView(logo);
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);
            imageView.setX(230);
            imageView.setY(35);
            pane.getChildren().add(imageView);
            ImageView imageView2 = new ImageView(home);
            imageView2.setFitWidth(30);
            imageView2.setFitHeight(25);
            backButton.setGraphic(imageView2);
            
            
            

        


    }
    public void addComponents() {

        //pane
        pane.getChildren().add(fName);
        pane.getChildren().add(fNameE);
        pane.getChildren().add(lName);
        pane.getChildren().add(lNameE);
        pane.getChildren().add(email);
        pane.getChildren().add(emailE);
        pane.getChildren().add(pw);
        pane.getChildren().add(passwordE);
        pane.getChildren().add(phoneNumber);
        pane.getChildren().add(phoneNumberE);
        pane.getChildren().add(line);
        pane.getChildren().add(cAccount);
        pane.getChildren().add(createAccount);
        pane.getChildren().add(required);
        pane.getChildren().add(backButton);




    }
    public void initializeLayout() {

        //layout


        //Everytime I make a constrain it increments to the next column;
       /* ColumnConstraints columnConstraints = new ColumnConstraints();
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        ColumnConstraints columnConstraints3 = new ColumnConstraints();
        gridPaneL.getColumnConstraints().add(columnConstraints);
        gridPaneL.getColumnConstraints().add(columnConstraints1);
        gridPaneL.getColumnConstraints().add(columnConstraints2);
        columnConstraints3.setMaxWidth(100);
        gridPaneL.getColumnConstraints().add(columnConstraints3);
        */

    }
    public Button getHomeButton() {
        return backButton;
    }

    public Button getcAccount() {
        return cAccount;
    }
    public String getfName() {
        return fNameE.getText();
    }
    public String getlName() {
        return lNameE.getText();
    }
    public String getEmail()  {
       // if (emailE.getText().contains("@"))
            return emailE.getText();

    }
    //Displays account already exist message for 1.5 seconds
    public void accountExist() {

        pane.getChildren().add(accountExists);
        accountExists.setLayoutX(25);
        accountExists.setLayoutY(460);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e ->pane.getChildren().remove(accountExists));
        pause.play();
    }
    //Displays invalid phone number for 1.5 seconds
    public void displayInvalidPhone() {
        pane.getChildren().add(invalidPhoneNumber);
        invalidPhoneNumber.setLayoutX(25);
        invalidPhoneNumber.setLayoutY(460);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> pane.getChildren().remove(invalidPhoneNumber));
        pause.play();
    }
    public void displayInvalidEmail() {
        pane.getChildren().add(invalidEmail);
        invalidEmail.setLayoutX(25);
        invalidEmail.setLayoutY(460);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> pane.getChildren().remove(invalidEmail));
        pause.play();
    }
    public void displayValidationCheck() {
        pane.getChildren().add(inputValidation);
        inputValidation.setLayoutX(25);
        inputValidation.setLayoutY(460);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> pane.getChildren().remove(inputValidation));
        pause.play();
    }

    public String getPassword() {
        return passwordE.getText();
    }
    public String getPhoneNumber() {
        return phoneNumberE.getText();
    }
    


    public CreationView(Stage stage) {
        components();

        properties();
        addComponents();

        //Cannot add two gridpanes so we will store them in a vbox container then add them to scene;
        VBox scene2 = new VBox(pane);


        scene = new Scene(scene2,350,600);
        stage.setTitle("Create Account");
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);


    }


}
