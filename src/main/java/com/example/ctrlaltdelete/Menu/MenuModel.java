package com.example.ctrlaltdelete.Menu;

import com.example.ctrlaltdelete.Login.CreationModel;
import javafx.css.Size;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class MenuModel {
    private String size , drinkSize;
    private int sPizza,mPizza,lPizza,xlPizza,sDrink,mDrink,lDrink;
    private double priceSize,drink,pizzaCost;
    private double toppingsCost,drinkCost;
    private double totalCost;
    private String toppings;
    private ArrayList<String> toppingsAll = new ArrayList<String>();
    ArrayList<OrderInfo> pizzaInfo = new ArrayList<>();

    public MenuModel() {


    }
    class OrderInfo {
        private int pizzaQuantity;
        private String pizzaSize;
        private int drinkQuantity;
        private String drinkSize;
        private String toppings;

        public OrderInfo(int pizzaQuantity,String pizzaSize,String toppings,int drinkQuantity,String drinkSize ) {
            this.pizzaQuantity = pizzaQuantity;
            this.pizzaSize = pizzaSize;
            this.toppings = toppings;
            this.drinkQuantity = drinkQuantity;
            this.drinkSize = drinkSize;
        }
    }


    public void addInfo(int pizzaQuantity,String pizzaSize,String toppings,int drinkQuantity,String drinkSize) {
       OrderInfo orderInfo = new OrderInfo(pizzaQuantity,pizzaSize,toppings,drinkQuantity,drinkSize);
       pizzaInfo.add(orderInfo);

    }
    public void printOrder() {
        for(int i = 0;i<pizzaInfo.size();i++) {
            System.out.println(pizzaInfo.get(i).pizzaQuantity + "x " + pizzaInfo.get(i).pizzaSize + " with " + pizzaInfo.get(i).toppings + " and " + pizzaInfo.get(i).drinkQuantity + "x " + pizzaInfo.get(i).drinkSize);
        }
    }

    public void addToppings(String toppingType) {
        totalCost += 0.75;
        toppingsAll.add(toppingType);

    }
    public void subToppings(String toppingType) {
        totalCost -= 0.75;
        toppingsAll.remove(toppingType);
    }
    public String returnToppings() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<toppingsAll.size();i++) {
            sb.append(toppingsAll + ",");
        }
        String toppings = new String(sb);
        return toppings;
    }
    public void setToppings() {
        this.toppings = returnToppings();
    }
    public void addPizza(String size, int quantity) {
        if (size.equals("small")) sPizza *= quantity;
        if (size.equals("medium")) mPizza *= quantity;
        if (size.equals("Large")) lPizza *= quantity;
        if (size.equals("xlpizza")) xlPizza *= quantity;
    }
    public void addDrink(String size,int quantity) {
        if (size.equals("small")) sDrink *= quantity;
        if (size.equals("medium")) mDrink *= quantity;
        if (size.equals("Large")) lDrink *= quantity;
    }

    //Light cheese will have no impact on pricing;
    public void extraCheese() {
        totalCost += 0.75;
    }
    public void stuffedCrust() {
        totalCost += 1.50;
    }
    public void deliveryFee() {
        totalCost += 2.00;
    }
    //adds the current selection
    public void addButton(int quantityPizza,String sizePizza,int quantityDrink,String drinkSize) {
        setToppings();
        String toppings = returnToppings();
        switch (sizePizza) {
            case "small": this.totalCost += (10.00 * quantityPizza) ; addPizza(sizePizza,quantityPizza); break;
            case "medium": this.totalCost += (13.00 * quantityPizza); addPizza(sizePizza,quantityPizza); break;
            case "large": this.totalCost += (15.00 * quantityPizza); addPizza(sizePizza,quantityPizza); break;
            case "xlarge": this.totalCost += (18.00 * quantityPizza); addPizza(sizePizza,quantityPizza); break;
            default:
                this.totalCost += 0.0;
                break;
         }
         switch (drinkSize) {
             case "small":this.totalCost += (1.25 * quantityDrink); addDrink(drinkSize,quantityDrink); break;
             case "medium":this.totalCost+= (1.50 * quantityDrink); addDrink(drinkSize,quantityDrink); break;
             case"large":this.totalCost+= (2.00 * quantityDrink); addDrink(drinkSize,quantityDrink); break;
             default:
                 this.totalCost += 0.0;
                 break;
         }
         addInfo(quantityPizza,sizePizza,toppings,quantityDrink,drinkSize);


    }
    public double gettotalCost() {
        return this.totalCost;
    }



    //size 1 = small
    //size 2 = medium
    //size 3 = large
    //size 4 = X - large


}
//hello3