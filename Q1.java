

import java.io.*;
import java.util.*;

public class Q1 {


    public static void actions(Stack<Integer> park, Stack<Integer> street){
        Scanner kbrd = new Scanner(System.in);
        System.out.println("Input license No.");
        int selection;

        do{
            selection = kbrd.nextInt();
            if(selection>0){
                push(park, selection);
            } else if (selection<0) {
                pop(park, street, selection);
            }
        }
        while(selection != 0);

    }

    public static void main(String[] args) {
        Stack<Integer> park = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        actions(park, street);
    }

    static void push(Stack<Integer> park, int car)
    {
        park.push(car);
        System.out.println("Cars in the parking\n"+ park);

    }

    static void pop(Stack<Integer> park, Stack<Integer> street, int car)
    {
        car= car*(-1);

        if (park.contains(car)){

            int tempCar;
            if(park.indexOf(car)<park.size()-1 && park.contains(car)){
                while(park.size()!=park.indexOf(car)+1){
                    tempCar = park.pop();
                    street.push(tempCar);
                }
                park.pop();
                while (!street.empty()){
                    tempCar = street.pop();
                    park.push(tempCar);
                }


            }
            else{
                park.pop();
            }
            System.out.println("Cars in the parking:");

            System.out.println(park);

        }

    }
}