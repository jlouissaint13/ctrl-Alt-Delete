package com.example.ctrlaltdelete.Menu;

import com.example.ctrlaltdelete.Login.CreationModel;
import javafx.css.Size;

public class MenuModel {
    private String size , drinkSize;
    private int sPizza,mPizza,lPizza,xlPizza,sDrink,mDrink,lDrink;
    private double priceSize,toppings,drink,pizzaCost;
    private double toppingsCost,drinkCost;
    private static double totalCost;
    public MenuModel() {


    }
    public void addPizza(String size) {
        if (size.equals("small")) sPizza += 1;
        if (size.equals("medium")) mPizza += 1;
        if (size.equals("Large")) lPizza += 1;
        if (size.equals("XLarge")) xlPizza += 1;
    }
    //Methods to add and subtract pizza types from each other;
    public void removePizza(String size) {
        if (size.equals("small")) sPizza -= 1;
        if (size.equals("medium")) mPizza -= 1;
        if (size.equals("Large")) lPizza -= 1;
        if (size.equals("XLarge")) xlPizza -= 1;
    }
    public void addToppings() {
        toppings += 1;
    }
    public void subToppings() {
        toppings -= 1;
    }
    public void addDrink() {
        if (size.equals("small")) sDrink += 1;
        if (size.equals("medium")) mDrink += 1;
        if (size.equals("Large")) lDrink += 1;
    }
    public void subDrink() {
        if (size.equals("small")) sDrink -= 1;
        if (size.equals("medium")) mDrink -= 1;
        if (size.equals("Large")) lDrink -= 1;
    }
    //Light cheese will have no impact on pricing;
    public void extraCheese() {
        pizzaCost += 0.75;
    }
    public void removeExtraCheese() {
        pizzaCost -= 0.75;
    }
    public void stuffedCrust() {
        pizzaCost += 1.50;
    }
    public void removeStuffed() {
        pizzaCost -= 1.50;
    }
    //Calculate the total cost
    public double calculateCost() {
     pizzaCost = (sPizza * 11.50) + (mPizza * 13.50) + (lPizza * 15.00) + (xlPizza * 18.00);
     drinkCost = (sDrink * 1.25) + (mDrink * 1.75) + (lDrink * 2.25);
     toppingsCost = (toppings * 0.75);

     return pizzaCost + drinkCost + toppingsCost;
    }


    //size 1 = small
    //size 2 = medium
    //size 3 = large
    //size 4 = X - large


}
