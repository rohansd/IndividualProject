import java.util.Scanner;
import components.*;

import java.util.ArrayList;
import java.util.HashMap;

public class App {
    static HashMap<String, Item> Stock = new HashMap<>();
    static HashMap<String, Order> Orders = new HashMap<>();
    public static ArrayList<String> Cards = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {

            // get input path for stock csv
            System.out.println("Enter file path for the Stock Data :");
            String filePath = input.nextLine();
            Stock = StockLoader.checkFilePath(filePath);

            // get input path for order csv
            System.out.println("Enter file path for the Card Data :");
            String filePathForCard = input.nextLine();

            // get input path for order csv
            System.out.println("Enter file path for the Input Data :");
            String InputPath = input.nextLine();
            Orders = ReadOrders.ValidateOrders(InputPath);
            CardController.ReadCardDetails(filePathForCard,Orders);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Validate Orders
        ValidateOrders.validate(Stock,Orders);
    }
}

// /Users/rohandeshmukh/Desktop/Dataset.csv

// /Users/rohandeshmukh/Desktop/Cards - Sheet1.csv

// /Users/rohandeshmukh/Desktop/Input1.csv