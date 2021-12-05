package components;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;



public class ValidOrderOutputGenerator {
    static int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
    public static void Generate(double totalAmountPaid) {        
        try{
            FileWriter errorFile = new FileWriter("/Users/rohandeshmukh/Desktop"+"/Order_"+randomNum+".txt");
            errorFile.write("Amount Paid : \n");
            errorFile.write(totalAmountPaid+"\n");
            errorFile.close();
            System.out.println("Order output file has been generated at the given path !");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
