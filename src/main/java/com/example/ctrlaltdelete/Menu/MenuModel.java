package com.example.ctrlaltdelete.Menu;

import javafx.css.Size;

public class MenuModel {
    private String size , drinkSize;
    private double priceSize,toppings,drink;
    private double toppingsCost,drinkCost;
    private static double totalCost;
    public MenuModel() {


    }

    //size 1 = small
    //size 2 = medium
    //size 3 = large
    //size 4 = X - large
    public void addPizza(String size) {


        if (size.equals("small")) {
            priceSize = 11.50;
        }
        else if (size.equals("medium")) {
            priceSize = 13.00;
        }
        else if (size.equals("Large"))
        {
            priceSize = 15.00;
        }
        else if (size.equals("X-Large")) {
            priceSize = 18.00;
        }
         totalCost += priceSize;
    }
    public double sizeCalculation(int quantity) {
     double sizeCost;
      if (size.equals("small")) {
          priceSize = 11.50;
      }
      else if (size.equals("medium")) {
          priceSize = 13.00;
      }
      else if (size.equals("Large"))
      {
          priceSize = 15.00;
      }
      else if (size.equals("X-Large")) {
          priceSize = 18.00;
      }
       return sizeCost = priceSize * quantity;
    }
    //Toppings will be a double we don't care about the name of the toppings just the quantity;
    //Same for drink

    public void drinkCalculation(int quantity) {
        if (drinkSize.equals("small"));




    }


}
