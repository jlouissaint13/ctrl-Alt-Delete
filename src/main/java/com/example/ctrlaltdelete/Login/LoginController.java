package com.example.ctrlaltdelete.Login;

import com.example.ctrlaltdelete.Menu.MenuMain;
import com.example.ctrlaltdelete.Menu.PizzaDeliveryApp;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;
    private Button login,guest,cAccount;
    private Stage stage;
    private CreationView creationView;
    private CreationMain creationMain;
    private String emailText,passwordText;
    private MenuMain menuMain;
    public LoginController(Stage stage, LoginModel loginModel, LoginView loginView) {
        //So I can go to the next scene
        menuMain = new MenuMain();

        this.loginView = loginView;
        this.loginModel = loginModel;
        //I need to do this because the buttons are in the model class these methods will return the buttons so this class can use them;
        login = loginView.getlogin(); //returns login button

        guest = loginView.getGuest(); //same for these with guest button and create account button

        cAccount = loginView.getcAccount();


        guest.setOnAction(event -> {
            System.out.println("Button is active");

            menuMain.start(stage);
        }); //Action handler for sign in as a guest;



        cAccount.setOnAction(event -> {

           CreationMain creationMain1 = new CreationMain();
           creationMain1.start(stage);

           }

        ); //Action handler for create account;



        login.setOnAction(event -> {
            //First I am going to check and make sure both rows are filled
           if ( loginModel.inputValidation(loginView.getPhone(),loginView.getPassword()) == true) {
               loginView.displayCompleteFields();
               return;
           }
            //When this is initialized in the main class these values are set to null; As soon as the login button is pressed they are updated with the content of the text fields
            loginModel.setAccount(this.loginView.getPhone(), this.loginView.getPassword());
            switch (this.loginModel.isValid(loginView.getPhone(),loginView.getPassword()))  {
                //Case 1 log you in; Case 2 Invalid password; case 3 account does not exist;
                case 1:
                    loginView.displayLogin();
                    menuMain.start(stage);
                    break;
                case 2: loginView.invalidPassword(); break;
                case 3: loginView.invalidAccount(); break;

            }
        });

        loginView.getPhoneE().setOnAction(e -> {
            //First I am going to check and make sure both rows are filled
            if ( loginModel.inputValidation(loginView.getPhone(),loginView.getPassword()) == true) {
                loginView.displayCompleteFields();
                return;
            }
            //When this is initialized in the main class these values are set to null; As soon as the login button is pressed they are updated with the content of the text fields
            loginModel.setAccount(this.loginView.getPhone(), this.loginView.getPassword());
            switch (this.loginModel.isValid(loginView.getPhone(),loginView.getPassword()))  {
                //Case 1 log you in; Case 2 Invalid password; case 3 account does not exist;
                case 1:
                    loginView.displayLogin();
                    menuMain.start(stage);break;
                case 2: loginView.invalidPassword(); break;
                case 3: loginView.invalidAccount(); break;
            }
        });
        loginView.getPasswordE().setOnAction(e ->{    //First I am going to check and make sure both rows are filled
            if ( loginModel.inputValidation(loginView.getPhone(),loginView.getPassword()) == true) {
                loginView.displayCompleteFields();
                return;
            }
            //When this is initialized in the main class these values are set to null; As soon as the login button is pressed they are updated with the content of the text fields
            loginModel.setAccount(this.loginView.getPhone(), this.loginView.getPassword());
            switch (this.loginModel.isValid(loginView.getPhone(),loginView.getPassword()))  {
                //Case 1 log you in; Case 2 Invalid password; case 3 account does not exist;
                case 1: loginView.displayLogin();
                    menuMain.start(stage);
                break;
                case 2: loginView.invalidPassword(); break;
                case 3: loginView.invalidAccount(); break;
            }});



    }
}