package com.example.ctrlaltdelete.Login;

import com.example.ctrlaltdelete.Login.ValidationException.EmailValidation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreationView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPaneL;
    private Pane pane;
    private Label fName,lName,email,pw,phoneNumber;
    private Text createAccount,required;
    private TextField fNameE,lNameE,emailE,passwordE,phoneNumberE;
    private Button cAccount,test,backButton;
    private Line line;
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
        backButton = new Button("<-");

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
        createAccount.setLayoutX(42);
        createAccount.setLayoutY(60);
        createAccount.setStyle("-fx-font: 40 Comfortaa;");
        required.setStyle("-fx-font: 13 Comfortaa;");
        required.setLayoutX(25);
        required.setLayoutY(420);
        backButton.setId("backButton");


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
