package components;
import java.util.*;

public class ValidateOrders {
    public static int EssentialsCount = 5;
    public static int LuxuryCount = 3;
    public static int MiscCount = 6;

    public static ArrayList<String> EssentialsItemsList;
    public static ArrayList<String> LuxuryItemsList;
    public static ArrayList<String> MiscItemsList;

    public static boolean checkEssentials = true;
    public static boolean checkLuxury = true;
    public static boolean checkMiscCount = true;

    public static double TotalAmountPaid = 0;

    HashMap<String, Item> ValidOrders = new HashMap<String, Item>();
    HashMap<String, Item> InvalidOrders = new HashMap<String, Item>();
    

    public static double validate(HashMap<String, Item> Stock, HashMap<String, Order> Orders){

        
        int EssentialsItemsQuantity = 0, LuxuryItemsQuantity = 0, MiscItemsQuantity = 0;
        for (String name: Orders.keySet()) {
            Order order = Orders.get(name);//value.getItem()
            Item stock = Stock.get(name);

            if(stock.getCategory()=="Essentials"){
                EssentialsItemsQuantity += order.getQuantity();
            }
            else if(stock.getCategory()=="Luxury"){
                LuxuryItemsQuantity += order.getQuantity();
            }
            else if(stock.getCategory()=="Misc"){
                MiscItemsQuantity += order.getQuantity();
            }
        }

        if(EssentialsItemsQuantity>EssentialsCount){
            checkEssentials = false;
        }
        if(LuxuryItemsQuantity>LuxuryCount){
            checkLuxury = false;
        }
        if(MiscItemsQuantity>MiscCount){
            checkMiscCount = false;
        }

        for (String name: Orders.keySet()) {
            Order order = Orders.get(name);//value.getItem()
            Item stock = Stock.get(name);
            if(stock.getQuantityStock()>=order.getQuantity()){
                if(stock.getCategory().equals("Essential") && checkEssentials){
                    TotalAmountPaid += (order.getQuantity()*stock.getPrice());
                }
                else if(stock.getCategory().equals("Luxury") && checkLuxury){
                    TotalAmountPaid += (order.getQuantity()*stock.getPrice());
                }
                else if(stock.getCategory().equals("Misc") && checkMiscCount){
                    TotalAmountPaid += (order.getQuantity()*stock.getPrice());
                }
            }
        }
        return TotalAmountPaid;

    }
}
