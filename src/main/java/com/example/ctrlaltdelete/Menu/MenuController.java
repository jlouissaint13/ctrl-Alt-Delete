package com.example.ctrlaltdelete.Menu;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class MenuController {
    private Stage stage;
    private MenuView menuView = new MenuView(stage);
    private MenuModel menuModel = new MenuModel();
    private CheckBox pepperonni,ham,sausage,canadianBacon,chicken,redPeppers,onions,greenPeppers;
    private Button minus,plus;
    private String size;
   public MenuController(Stage stage, MenuModel menuModel,MenuView menuView) {
       this.menuModel = menuModel;
       this.menuView = menuView;
       pepperonni = menuView.getPepperoni();
       ham = menuView.getHam();
       sausage = menuView.getSausage();
       canadianBacon = menuView.getCanadianBacon();
       chicken = menuView.getChicken();
       redPeppers = menuView.getRedPeppers();
       onions = menuView.getOnions();
       greenPeppers = menuView.getGreenPeppers();
       plus = menuView.getPlus();
       minus = menuView.getPlus();
























        //All checkboxs

       pepperonni.setOnAction(e -> {
           if (pepperonni.isSelected()) {
               menuModel.addToppings("pepperoni");
           }
           else {
               menuModel.subToppings("pepperoni");
           }

       });
       ham.setOnAction(actionEvent -> {
           if (ham.isSelected()) {
               menuModel.addToppings("ham");
           }
           else {
               menuModel.subToppings("ham");
           }

       });
       sausage.setOnAction(e -> {
           if (sausage.isSelected()) {
               menuModel.addToppings("sausage");
           }
           else {
               menuModel.subToppings("sausage");
           }
       });
       canadianBacon.setOnAction(e-> {
           if (canadianBacon.isSelected()) {
               menuModel.addToppings("canadian bacon");
           }
           else {
               menuModel.subToppings("canadian bacon");
           }
       });
       chicken.setOnAction(actionEvent -> {
           if (chicken.isSelected()) {
               menuModel.addToppings("chicken");
           }
           else {
               menuModel.subToppings("chicken");
           }

       });
       greenPeppers.setOnAction(actionEvent -> {
           if (greenPeppers.isSelected()) {
               menuModel.addToppings("green peppers");
           }
           else {
               menuModel.subToppings("green peppers");
           }

       });
       redPeppers.setOnAction(actionEvent -> {
           if(redPeppers.isSelected()) {
               menuModel.addToppings("red peppers");
           }
           else{
               menuModel.subToppings("red peppers");
           }

       });
       onions.setOnAction(actionEvent -> {
           if (onions.isSelected()) {
               menuModel.addToppings("onions");
           }
           else {
               menuModel.subToppings("onions");
           }
       });
   }


}
