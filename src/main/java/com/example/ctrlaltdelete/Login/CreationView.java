package com.example.ctrlaltdelete.Login;

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
    private Text createAccount;
    private TextField fNameE,lNameE,emailE,passwordE,phoneNumberE;
    private Button cAccount;
    private Line line;
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
        line = new Line(0,0,500,0);

    }
    public void properties() {
        fNameE.setMinWidth(115);
        lNameE.setPrefWidth(117);
        emailE.setMinWidth(300);
        passwordE.setMinWidth(300);
        phoneNumberE.setMinWidth(300);
        //gridpaneL properties
        gridPaneL.setAlignment(Pos.TOP_LEFT);
        gridPaneL.setHgap(10);
        gridPaneL.setVgap(5);
        line.setTranslateY(100);
        cAccount.setLayoutX(108);
        cAccount.setLayoutY(140);
        cAccount.setMinSize(130,70);
        createAccount.setLayoutX(95);
        createAccount.setLayoutY(-265);

        createAccount.setStyle("-fx-font: 25 Comfortaa;");


    }
    public void addComponents() {




        //gridpaneL
        gridPaneL.add(fName,3,25);
        gridPaneL.add(fNameE,3,26);

        gridPaneL.add(lName,11,25);
        gridPaneL.add(lNameE,11,26);
        gridPaneL.add(email,3,28);
        gridPaneL.add(emailE,3,29);
        gridPaneL.add(pw,3,31);
        gridPaneL.add(passwordE,3,32);
        gridPaneL.add(phoneNumber,3,35);
        gridPaneL.add(phoneNumberE,3,36);
        gridPaneL.setGridLinesVisible(false);
        //gripdPaneB
        pane.getChildren().add(line);
        pane.getChildren().add(cAccount);
        pane.getChildren().add(createAccount);




    }
    public void initializeLayout() {
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


        //layout
        pane = new Pane();



    }

    public CreationView(Stage stage) {
        components();
        initializeLayout();
        properties();
        addComponents();
        //Cannot add two gridpanes so we will store them in a vbox container then add them to scene;
        VBox vBox = new VBox(gridPaneL,pane);
        scene = new Scene(vBox,350,600);
        stage.setTitle("Create Account");
        stage.setScene(scene);


    }


}
