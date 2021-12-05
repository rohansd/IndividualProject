package components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadOrders {
    static HashMap<String, Order> Orders = new HashMap<>();
    static ArrayList<String> fileContent = new ArrayList<>();

    public static HashMap<String, Order> ValidateOrders(String filePath) {
        try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(filePath).toFile()));
            String buffer = "";
            boolean firstline = true;
            while ( ( buffer = bufferedReader.readLine() ) != null ) {
                if(firstline){
                    firstline = false;
                    continue;
                }
                fileContent.add( buffer );
            }

            for(String line : fileContent) {
                String[] item = line.split(",");
                Orders.put(item[0], new Order(item[0], Integer.parseInt(item[1]), item[2]));
            }

		} catch (Exception e) {
			
            System.out.println(e);
			System.exit(0);
			
		}
        return Orders;
    }
    
}
