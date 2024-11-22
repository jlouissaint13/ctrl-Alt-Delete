package com.example.ctrlaltdelete.Login;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreationView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPaneR,gridPaneL;
    private Label fName,lName,email,pw,phoneNumber;
    private Text createAccount;
    private TextField fNameE,lNameE,emailE,passwordE,phoneNumberE;
    private Button cAccount;
        //All variables with e at the end means that it is the variable for the textfield;
    public void components() {
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
    }
    public void properties() {
        fNameE.setMinWidth(115);
        lNameE.setPrefWidth(117);
        emailE.setMinWidth(300);
        passwordE.setMinWidth(300);
        phoneNumberE.setMinWidth(300);

        //gridpane properties
        gridPaneL.setAlignment(Pos.TOP_LEFT);
        gridPaneL.setHgap(10);
        gridPaneL.setVgap(5);

    }
    public void addComponents() {




        //gridpaneL
        gridPaneL.add(fName,3,23);
        gridPaneL.add(fNameE,3,24);

        gridPaneL.add(lName,11,23);
        gridPaneL.add(lNameE,11,24);
        gridPaneL.add(email,3,27);
        gridPaneL.add(emailE,3,28);
        gridPaneL.add(pw,3,30);
        gridPaneL.add(passwordE,3,31);
        gridPaneL.add(phoneNumber,3,34);
        gridPaneL.add(phoneNumberE,3,35);
        gridPaneL.setGridLinesVisible(false);
        //gripdPaneR



    }
    public void initializeGridPane() {
        gridPaneL = new GridPane();
        //Everytime I make a constrain it increments to the next column;
        //Process was painful but we were able to reach column four with columnConstrains3
        ColumnConstraints columnConstraints = new ColumnConstraints();
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        ColumnConstraints columnConstraints3 = new ColumnConstraints();
        gridPaneL.getColumnConstraints().add(columnConstraints);
        gridPaneL.getColumnConstraints().add(columnConstraints1);
        gridPaneL.getColumnConstraints().add(columnConstraints2);
        columnConstraints3.setMaxWidth(100);
        gridPaneL.getColumnConstraints().add(columnConstraints3);


    }

    public CreationView(Stage stage) {
        components();
        initializeGridPane();
        properties();
        addComponents();

        scene = new Scene(gridPaneL,350,600);
        stage.setTitle("Create Account");
        stage.setScene(scene);


    }


}
