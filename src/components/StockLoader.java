package components;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class StockLoader {

	static ArrayList<String> fileContent = new ArrayList<>();

    static HashMap<String, Item> items = new HashMap<>();

    public static HashMap<String, Item> checkFilePath(String filePath){
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

            for( String line : fileContent ) {
                String[] item = line.split(",");
                items.put(item[1], new Item(item[0], item[1], Double.parseDouble(item[3]), Integer.parseInt(item[2])));
            }

		} catch (Exception e) {
			
            System.out.println(e);
			// System.out.println( "The stock file was not found, Please check the file path." );
			System.exit(0);
			
		}
        return items;
    }
}
