import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Q4 {

    public static void main(String[] args) throws IOException {
        Stack<String> open = new Stack<String>();
        Stack<String> close = new Stack<String>();
        File doc = new File("Tags 1.txt");
        Scanner read = new Scanner(doc);
        String line;

        while(read.hasNextLine()){
            line = read.next();

                if(line!=" "){
                    String tag = line;

                    if(tag.contains("/")){
                        close.push(tag);
                    }
                    else {
                        open.push(tag);
                    }

            }
        }

        System.out.println(open);
        System.out.println(close);
    }
}
