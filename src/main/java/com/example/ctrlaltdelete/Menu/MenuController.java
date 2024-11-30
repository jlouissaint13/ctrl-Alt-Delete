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











       plus.setOnAction(e -> {
           menuModel.addPizza(size);
       });
       minus.setOnAction(e -> {
           menuModel.removePizza(size);
       });












        //All checkboxs

       pepperonni.setOnAction(e -> {
           if (pepperonni.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }

       });
       ham.setOnAction(actionEvent -> {
           if (ham.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }

       });
       sausage.setOnAction(e -> {
           if (sausage.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }
       });
       canadianBacon.setOnAction(e-> {
           if (canadianBacon.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }
       });
       chicken.setOnAction(actionEvent -> {
           if (chicken.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }

       });
       greenPeppers.setOnAction(actionEvent -> {
           if (greenPeppers.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }

       });
       redPeppers.setOnAction(actionEvent -> {
           if(redPeppers.isSelected()) {
               menuModel.addToppings();
           }
           else{
               menuModel.subToppings();
           }

       });
       onions.setOnAction(actionEvent -> {
           if (onions.isSelected()) {
               menuModel.addToppings();
           }
           else {
               menuModel.subToppings();
           }
       });
   }


}
