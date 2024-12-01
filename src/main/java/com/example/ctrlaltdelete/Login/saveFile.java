import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public void saveFile(String orderDetails) { // whatever the order.txt file is replace that with ourss
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
        writer.write(orderDetails);
        writer.newLine();
        writer.write("=========================================");
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}