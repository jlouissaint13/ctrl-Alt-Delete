package com.example.ctrlaltdelete.Login;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
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
        fNameE.setMaxWidth(100);
        lNameE.setMaxWidth(100);
        //gridpane properties
        gridPaneL.setAlignment(Pos.TOP_LEFT);
        gridPaneL.setHgap(10);
        gridPaneL.setVgap(5);
        gridPaneR.setHgap(10);
        gridPaneR.setVgap(5);
        gridPaneR.setAlignment(Pos.TOP_RIGHT);
    }
    public void addComponents() {




        //gridpaneL
        gridPaneL.add(fName,3,23);
        gridPaneL.add(fNameE,3,24);
        gridPaneL.add(email,3,40);
        gridPaneL.add(emailE,3,41);
        //gripdPaneR

        gridPaneR.add(lName,9,23);
        gridPaneR.add(lNameE,9,24);


    }
    public void initializeGridPane() {
        gridPaneL = new GridPane();
        gridPaneR = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        RowConstraints rowConstraints = new RowConstraints();
        columnConstraints.setPercentWidth(0);
        gridPaneL.getColumnConstraints().add(columnConstraints);
        gridPaneL.getRowConstraints().add(rowConstraints);
        gridPaneR.getRowConstraints().add(rowConstraints);
        gridPaneR.getColumnConstraints().add(columnConstraints);



    }

    public CreationView(Stage stage) {
        components();
        initializeGridPane();
        properties();
        addComponents();
        HBox hbox = new HBox(gridPaneL,gridPaneR);
        scene = new Scene(hbox,350,600);
        stage.setTitle("Create Account");
        stage.setScene(scene);


    }


}
