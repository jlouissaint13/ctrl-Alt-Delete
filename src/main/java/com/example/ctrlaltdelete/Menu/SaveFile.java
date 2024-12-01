package com.example.ctrlaltdelete.Menu;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    public void saveFile(String orderDetails) { // whatever the order.txt file is replace that with ourss
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", false))) {
            writer.write(orderDetails);
            writer.newLine();
            writer.write("=========================================");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}