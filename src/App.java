import components.StockLoader;
import java.util.Scanner;
import components.*;
import java.util.HashMap;

public class App {
    static HashMap<String, Item> Stock = new HashMap<>();
    static HashMap<String, Order> Orders = new HashMap<>();
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {

            // get input path for stock csv
            System.out.println("Enter file path for the Stock Data :");
            String filePath = input.nextLine();
            Stock = StockLoader.checkFilePath(filePath);

            // get input path for order csv
            System.out.println("Enter file path for the Input Data :");
            String InputPath = input.nextLine();
            Orders = ReadOrders.ValidateOrders(InputPath);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Validate Orders
        ValidateOrders.validate(Stock,Orders);
    }
}
// /Users/rohandeshmukh/Desktop/Dataset.csv

// /Users/rohandeshmukh/Desktop/Input3 - Sheet1.csv