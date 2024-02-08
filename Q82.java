//Question corrected with the help of Aleksandra Kail
//https://github.com/Al3x-K/Programming_CA3/blob/main/src/main/java/CA3_Question8.java

import java.util.Scanner;
import java.util.Stack;

public class Q82 {
    public static void main(String[] args) {
        Stack<Double> numbers = new Stack<Double>();
        Stack<Character> operators = new Stack<Character>();

        Scanner kbrd = new Scanner(System.in);
        String function = "";

        System.out.print("Please Enter your equation: ");

        function = kbrd.nextLine().trim();
        double result = 0;

        result = evaluate(function);
        System.out.println(result);
    }

    public static double evaluate(String equation) {
        //stack for numbers and operators
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        //runs through the whole equation evaluating each character
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            //skipping white spaces
            if (ch == ' ') {
                continue;
            }
            //handling opening brackets
            else if (ch == '(') {
                operators.push(ch);
            }
            //handling numbers
            else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder(); //it reads the whole number, including the decimal part
                while (i < equation.length() && (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.')) {
                    sb.append(equation.charAt(i++));
                }
                i--; //adjusts the index so the next character is handled properly
                numbers.push(Double.parseDouble(sb.toString())); //pushes the number onto the stack
            }
            //handling closing brackets
            else if (ch == ')') {
                //check for the "("
                while (operators.peek() != '(') {
                    calculate(numbers, operators);
                }
                operators.pop(); //removes '(' from the stack
            }
            //handling the (+,-,*,/) operators
            else {
                //process operators based on their order in math
                while (!operators.isEmpty() && priority(operators.peek()) >= priority(ch)) {
                    calculate(numbers, operators);
                }
                operators.push(ch); //push the current operator onto the stack
            }
        }
        //remaining operators
        while(!operators.isEmpty())
        {
            calculate(numbers,operators);
        }
        return numbers.pop();
    }



    public static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == 'x' || operator == '/') {
            return 2;
        } else {
            return 0;
        }

    }


    public static void calculate(Stack<Double> numbers, Stack<Character> operators) {


        //Stack<String> tempOperators = new Stack<String>();
        double num2 = numbers.pop(); //pop the 2nd number
        double num1 = numbers.pop(); //pop the 1st number
        char operator = operators.pop(); //pop the operator
        double result = 0.0;

//        System.out.println(numbers);

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case 'x':
                result = num1 * num2;
                break;
            case'/':
                result = num1 / num2;
                break;
        }
        numbers.push(result);
    }

}

