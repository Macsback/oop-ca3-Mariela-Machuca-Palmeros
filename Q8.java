import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8 {

    public static void main(String[] args) {
        Stack<Integer> numbers= new Stack<Integer>();
        Stack<String> operators = new Stack<String>();

        Scanner kbrd = new Scanner(System.in);
        String function = "";

        System.out.println("Input one Operator or Number by line, Q to quit");

        do {
            function = kbrd.nextLine().toLowerCase();

            if (function.matches("\\d+")) {
//                    System.out.println("This is an integer " + function);

            int number = Integer.valueOf(function);

            numbers.push(number);



                }

            else {
//                    System.out.println("This is not an integer " + function);
                operators.push(function);

                }

        }

        while (!function.equals("q"));

//        do {
//            function = kbrd.next().toLowerCase();
//
//            while (function != "\n") {
//
//
//                if (function.matches("\\d+")) {
//                    System.out.println("This is an integer " + function);
//                }
//                else {
//                    System.out.println("This is not an integer " + function);
//                }
//            }
//        }
//
//        while(function.contains("done"));
    }



// TODO Make Scanner read one by one the parts of the operation !!
// Put each section in the correspondant Stack !!
// Read the Stacks and Calculate the operation
}

