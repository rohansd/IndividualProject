package components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


public class CardController {
    static HashSet<String> cards = new HashSet<String>();
    static int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
    static HashSet<String> ListOfCardsNeedToBeAdded = new HashSet<String>();
    static HashSet<String> orderCards = new HashSet<String>();
    public static void ReadCardDetails(String filePath, HashMap<String, Order> Orders) {

        for (String name: Orders.keySet()) {
            Order order = Orders.get(name);
            orderCards.add(order.getCardNumber());
        }

        try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
            String buffer = "";
            while ((buffer = bufferedReader.readLine()) != null) {
                cards.add(buffer);
            }
		} catch (Exception e) {
            System.out.println(e);
			// System.out.println( "The stock file was not found, Please check the file path." );
			System.exit(0);
		}

        for(String card : orderCards){
            if(!cards.contains(card)){
                ListOfCardsNeedToBeAdded.add(card);
            }
        }

        addCard(ListOfCardsNeedToBeAdded,cards);
    }

    public static void addCard(HashSet<String> ListOfCardsNeedToBeAdded, HashSet<String> cards){
        try{
            FileWriter pw = new FileWriter("/Users/rohandeshmukh/Desktop/Cards - Sheet1.csv",true);
            // FileWriter errorFile = new FileWriter("/Users/rohandeshmukh/Desktop/Cards - Sheet1.csv");
            ///Users/rohandeshmukh/Desktop
            // errorFile.write("CardNumber : \n");
            for(String line : ListOfCardsNeedToBeAdded){
                pw.append("\n "+line+" ");
            }
            // for(String line : cards){
                // errorFile.write(" "+line+"\n");
            // }
            pw.flush();
            pw.close();
            System.out.println("Order output file has been generated at the given path !");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
