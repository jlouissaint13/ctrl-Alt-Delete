package com.example.ctrlaltdelete.Login;

import javafx.animation.PauseTransition;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPane; //Created so I can set the children up to be in the way of rows and columns a good set up for a login page
    private Label email,pw,forgotPassword;
    private TextField emailE,passwordE;
    private Button cAccount,cGuest,show,signIn;
    private HBox hbtn;

    //Will have all the ui components of my program
    public void components() {
        email = new Label("Email");
        emailE = new TextField();
        pw = new Label("Password");
        // show = new Button("Show");
        //forgotPassword = new Label("Forgot Password?");
        passwordE = new TextField();
        cAccount = new Button("Create Account");
        cGuest = new Button("Continue as Guest");
        signIn = new Button("Sign in");
        hbtn = new HBox(10);

    }
    public void properties() {
        cAccount.setMinSize(150,25);
        cGuest.setMinSize(150,25);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbtn.getChildren().add(signIn);

    }
    //Will be used to add components to program;
    public void addComponents() {
        gridPane.add(email,0,7);
        gridPane.add(emailE,0,8);
        gridPane.add(pw,0,9);
        // gridPane.add(show,0,10);
        gridPane.add(passwordE,0,10);
        // gridPane.add(forgotPassword,0,11);
        gridPane.add(hbtn,0,11);
        gridPane.add(new Label("Don't have one?  Make one!"),0,22);
        gridPane.add(cAccount,0,23);
        gridPane.add(cGuest,0,25);


    }
    public LoginView(Stage stage) { //initialize my login screen
        components();
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); //Makes the gridpane center instead of default alignment;
        gridPane.setHgap(10);
        gridPane.setVgap(5);//Vertical gap between each label;
        properties();
        addComponents();
        scene = new Scene(gridPane,350,600);
        stage.setTitle("Login to Slice Heaven");
        stage.setScene(scene);

    }

    //Gets the login button
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
    public String getEmail () {
        return emailE.getText();
    }
    //Returns the user password
    public String getPassword() {
        return passwordE.getText();
    }
    public Scene getScene() {
        stage.setTitle("Login to Slice Heaven");
        return scene;
    }
    //Displays logging in when clicking log in button
    public void displayLogin() {
        Text login = new Text("Logging in....");
        gridPane.add(login,0,11);
        //Amount of time to delay the remove of the text
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        //After the delay is finished remove loginText from the gridPane
        pause.setOnFinished(e -> gridPane.getChildren().remove(login));
        //Starts the timer
        pause.play();
    }
    public void displayPlaceholder() {
        Text placeholder = new Text("Does not exist XD");
        gridPane.add(placeholder,0,0);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.2));
        pause.setOnFinished(e ->gridPane.getChildren().remove(placeholder));
        pause.play();
    }

}
