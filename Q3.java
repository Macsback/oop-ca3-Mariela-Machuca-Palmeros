
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(new File("Q1.java"));
        //creates map storing identifiers and their occurrences
        Map<String, ArrayList<String>> map = new TreeMap<>();
        String line = " ";

        while (read.hasNextLine()) //reading each line from the file
        {
            Scanner lineRead = new Scanner(read.nextLine());
            lineRead.useDelimiter("[^A-Za-z0-9_]+");

            while (lineRead.hasNext()) {
                String key = lineRead.next();
                line = read.nextLine();
                if(!map.containsKey(key))
                {
                    map.put(key,new ArrayList<String>());
                }
                map.get(key).add(line);
            }
            System.out.println(map);
        }


    }
}
// Create a map (key) name of the identifier (value) Arraylist containing the lines where the identifiers are in
// Scan through lines for identifiers, when Identifier is found check your map in case it exists
// if it exists you just add the line into the arraylist of that identifier
// if it doesnt you add it to the map and create a new key and arraylist for it with the line where it spotted it
