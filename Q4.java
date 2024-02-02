import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q4 {

    public static void main(String[] args) throws IOException {
        Stack<String> open = new Stack<String>();
        Stack<String> close = new Stack<String>();
        File doc = new File("Tags 3.txt");
        Scanner read = new Scanner(doc);
        String line;
        boolean balanced = false;

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
        close = mirror(close);

        System.out.println(open);
        System.out.println(close);

        // char[] decomptag = decompose(open.peek());

        balanced = equalTags(open, close);

        if (balanced)
            System.out.println("The tags are properly nested");
        else
            System.out.println("The tags are not properly nested");

    }

    public static boolean equalTags(Stack<String> open, Stack<String> close){
//        char[] openTag;
//        char[] closeTag;

        String oTag;
        String cTag;

        String openTag;
        String closeTag;

        boolean balanced = false;

            while(!open.isEmpty() && !close.isEmpty()){
                oTag = open.pop();
                cTag = close.pop();
                openTag = oTag.substring(1);
                closeTag = cTag.substring(2);



                if (closeTag.equals(openTag)){
                    balanced = true;
                }
                else {
                    balanced = false;
                    break;
                }



            }

        return balanced;
    }

    public static Stack<String> mirror(Stack<String> normal){
        Stack<String> reverse = new Stack<String>();

        while (!normal.empty()){
            reverse.push(normal.pop());
        }

        return reverse;
    }

//    public static char[] decompose(String tag){
//       char[] decTag = tag.toCharArray();
////        for(int i = 0; i < decTag.length; i++){
////            System.out.println(decTag[i] + " ");
////        }
//
//        return decTag;
//    }
}
