import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// This question required further help, so the functioning answer is in Q82.
// Did not want to delete process

public class Q8 {

    public static void main(String[] args) {
        Stack<Double> numbers = new Stack<Double>();
        Stack<String> operators = new Stack<String>();

        Scanner kbrd = new Scanner(System.in);
        String function = "";

        double num1 = 0;
        double num2 = 0;
        double result = 0;

        System.out.println("Input one Operator or Number by line, Q to quit, and = to calculate");

        do {
            function = kbrd.nextLine().toLowerCase();

            if (function.matches("\\d+")) {
//                    System.out.println("This is an integer " + function);

                double number = Double.valueOf(function);

                numbers.push(number);

                System.out.println(numbers.peek());

            }


            else {
//                    System.out.println("This is not an integer " + function);

                if(function.equals("(")){
                    operators.push(function);
                }
//                operators.push(function);
//                System.out.println(operators.peek());
                else if (function.equals("+") || function.equals("-")) {
                    if (numbers.size()>1 && !operators.isEmpty()) {
                        if (operators.peek().equals("*") || operators.peek().equals("/")) {
                            while(operators.peek().equals("*") || operators.peek().equals("/")){
                            result = calculate(numbers, operators);
                            operators.push(function);}
//                            String operator;
//                            num2 = numbers.pop();
//                            num1 = numbers.pop();

                        }
                        else{
                            operators.push(function);
                             result = calculate(numbers, operators);
                        }
                    } else if (function.equals(")")) {
                        if(!operators.peek().equals("(")){
                            while (!operators.peek().equals("(") && !operators.isEmpty()){
                                result = calculate(numbers, operators);
                            }
                            operators.pop();
                        }
                    }
                } else if (function.equals("=") && !operators.isEmpty()) {
                    result = calculate(numbers, operators);
                }
            }


            System.out.println("Calculating");
//            double result = calculate(numbers, operators);
            System.out.println(result);


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
//
    public static double calculate(Stack<Double> numbers, Stack<String> operators) {


        //Stack<String> tempOperators = new Stack<String>();
        String operator = operators.pop();

        double num2 = numbers.pop();
        double num1 = numbers.pop();
        double result = 0;
        System.out.println(numbers);
//        if (numbers.size()>1 && !operators.isEmpty()){
//             operator = operators.peek();
//
//            if(operator.equals("/") || operator.equals("*")){
//                num2 = numbers.pop();
//                num1 = numbers.pop();
//                operator = operators.pop();
//
//                switch (operator){
//
//                    case "/":
//                        result = num1/num2;
//                        break;
//
//                    case "*":
//                        result = num1*num2;
//                        break;
//
//                }
//            } else if (operator.equals("+") || operator.equals("-")) {
//                tempOperators.push(operators.pop());
//            }
//
// /*           switch (operator){
//                case "+":
//
//                    result = num1 + num2;
//
//                    break;
//
//                case "-":
//                    result = num1 - num2;
//                    break;
//
//                case "/":
//                    result = num1/num2;
//                    break;
//
//                case "*":
//                    result = num1*num2;
//                    break;
//
//            }*/
//        } else if (numbers.size()>1 && operators.isEmpty()) {
//            operator = tempOperators.pop();
//            num2 = numbers.pop();
//            num1 = numbers.pop();
//
            switch (operator) {
                case "+":

                    result = num1 + num2;

                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "/":
                    result = num1 / num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

            }
//        }
//        if(result!=0){
        numbers.push(result);
//    }
        return result;
    }


// TODO Make Scanner read one by one the parts of the operation !!
// Put each section in the correspondant Stack !!
// Read the Stacks and Calculate the operation
}

