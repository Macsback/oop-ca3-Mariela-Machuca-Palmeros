import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        String command = "";
        Scanner kbrd = new Scanner(System.in);
        Queue<Block> bag = new LinkedList<Block>();
        double gain = 0;
        int quantity = 0;
        double price = 0;

        do{
            System.out.println("What do you want to do?: Buy *Quantity* *Price*, Sell *Quantity* *Price*, quit");
            command = kbrd.next().toLowerCase(Locale.ROOT);
            quantity = kbrd.nextInt();
            price = kbrd.nextDouble();
            //System.out.println(command);




            if(command.equalsIgnoreCase("buy")){
                Block shares = new Block(quantity, price);
                bag.add(shares);
                //  System.out.println("Block: " + shares.getQuantity() + " " + shares.getPrice());
            } else if (command.equalsIgnoreCase("sell")) {
                gain = sellShares(bag, quantity, price);
                System.out.println(gain);
            }

          //  System.out.println(bag.peek().getQuantity() + " " + bag.peek().getPrice());

        } while (!command.contains("quit"));
    }

    public static double sellShares(Queue<Block> bag, int quantity, double price){
        double gain = 0;
        Block stash = bag.peek();
        int avaShares = stash.getQuantity();
        double boughtPrice = 0 ;
        while(quantity > 0 && !bag.isEmpty())
        if(avaShares < quantity){
            //while(avaShares < quantity && !bag.isEmpty()){
                 boughtPrice = stash.getPrice(); ;
            gain += (price - boughtPrice) * avaShares;;
            quantity = quantity-avaShares;
            bag.remove();
            stash = bag.peek();
            avaShares = stash.getQuantity();
          //  }
//            gain += (price - boughtPrice) * quantity;;
//            stash.setQuantity(avaShares - quantity);
       }
        else if(avaShares == quantity){
            boughtPrice = stash.getPrice(); ;
            gain += (price - boughtPrice) * avaShares;
            bag.remove();
        }
        else if(avaShares> quantity){
            boughtPrice = stash.getPrice(); ;
            gain += (price - boughtPrice) * quantity;
            stash.setQuantity(avaShares - quantity);
            quantity = 0 ;
        }

        return gain;

    }
}
