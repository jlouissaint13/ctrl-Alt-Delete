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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class LoginView {
    private Stage stage;
    public Scene scene;
    private GridPane gridPane; //Created so I can set the children up to be in the way of rows and columns a good set up for a login page
    private Label email,pw,forgotPassword,makeAccount;
    private TextField emailE,passwordE;
    private Button cAccount,cGuest,show,signIn;
    private Pane pane;
    private Text sign,or;

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
        or = new Text("Or");
        makeAccount = new Label("Don't have one? Make one!");
        sign = new Text("Sign-In");
        sign.setStyle("-fx-font: 40 comfortaa");
        pane = new Pane();
    }
    public void properties() {

       //Account stuff
        cAccount.setPrefSize(150,25);
        cGuest.setPrefSize(150,25);
        makeAccount.setLayoutX(97);
        makeAccount.setLayoutY(380);
        cAccount.setLayoutX(97);
        cAccount.setLayoutY(403);

        //email
        email.setLayoutX(97);
        email.setLayoutY(180);
        emailE.setLayoutX(97);
        emailE.setLayoutY(200);
        emailE.setPrefSize(150,25);
        //password
        pw.setLayoutX(97);
        pw.setLayoutY(230);
        passwordE.setLayoutX(97);
        passwordE.setLayoutY(250);
        passwordE.setPrefSize(150,25);
        //miscellaneous
        or.setLayoutX(167);
        or.setLayoutY(445);
        cGuest.setLayoutX(97);
        cGuest.setLayoutY(453);
        signIn.setLayoutX(193);
        signIn.setLayoutY(282);
        sign.setLayoutX(100);
        sign.setLayoutY(100);
    }
    //Will be used to add components to program;
    public void addComponents() {
        pane.getChildren().add(email);

        pane.getChildren().add(emailE);

        pane.getChildren().add(pw);

        pane.getChildren().add(passwordE);

        pane.getChildren().add(makeAccount);

        pane.getChildren().add(cAccount);

        pane.getChildren().add(or);

        pane.getChildren().add(cGuest);

        pane.getChildren().add(signIn);

        pane.getChildren().add(sign);
    }
    public LoginView(Stage stage) { //initialize my login screen
        components();
        gridPane = new GridPane();//Vertical gap between each label;
        properties();
        addComponents();
        VBox vbox = new VBox(pane);
        scene = new Scene(vbox,350,600);
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
        pane.getChildren().add(login);
        login.setLayoutX(97);
        login.setLayoutY(295);
        //Amount of time to delay the remove of the text
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        //After the delay is finished remove loginText from the gridPane
        pause.setOnFinished(e -> pane.getChildren().remove(login));
        //Starts the timer
        pause.play();
    }
    public void invalid() {
        Text passwordInv = new Text("Invalid Password!");
        pane.getChildren().add(passwordInv);
        passwordInv.setLayoutX(97);
        passwordInv.setLayoutY(295);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(passwordInv));
        pause.play();
    }
    public void displayPlaceholder() {
        Text placeholder = new Text("Does not exist XD");
        pane.getChildren().add(placeholder);
        placeholder.setLayoutX(100);
        placeholder.setLayoutY(150);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.2));
        pause.setOnFinished(e ->pane.getChildren().remove(placeholder));
        pause.play();
    }

}
