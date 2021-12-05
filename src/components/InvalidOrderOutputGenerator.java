package components;
import java.util.*;
import java.io.FileWriter;
import java.util.concurrent.ThreadLocalRandom;

public class InvalidOrderOutputGenerator {
    static int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
    public static void Generate(ArrayList<Order> InValidOrders, HashMap<String, Item> Stock) {
        try {
            FileWriter errorFile = new FileWriter("/Users/rohandeshmukh/Desktop"+"/Order_"+randomNum+".txt");
            errorFile.write("Please correct quantities of one of the following items : \n");
            for(Order order: InValidOrders){
                errorFile.write("Item : "+order.getItem()+" \t "+" Input Quantity : "+order.getQuantity()+" \t"+"Inventory Quantity : "+Stock.get(order.getItem()).getQuantityStock()+"\n");
            }
            errorFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
