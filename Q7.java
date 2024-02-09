import java.util.*;

// Copied Q6 and added modifications
public class Q7 {

    public static void main(String[] args) {
        String command = "";
        Scanner kbrd = new Scanner(System.in);
//       Q6 Queue<Block> bag = new LinkedList<Block>();
        Map<String, Queue<Block>> map = new TreeMap<>();
        double gain = 0;
        int quantity = 0;
        String key = " ";
        double price = 0;

        do{
            System.out.println("What do you want to do?: Buy *Company* *Quantity* *Price*, Sell *Company* *Quantity* *Price*, quit");
            command = kbrd.next().toLowerCase(Locale.ROOT);
            if(!command.equalsIgnoreCase("quit")){
            key = kbrd.next();
            quantity = kbrd.nextInt();
            price = kbrd.nextDouble();}
            //System.out.println(command);

            if(command.equalsIgnoreCase("buy")){
                Block shares = new Block(quantity, price);
                if(!map.containsKey(key))
                {
                    map.put(key,new LinkedList<>());
                    map.get(key).add(shares);
                }
                else {
                    map.get(key).add(shares);
                }



                //  System.out.println("Block: " + shares.getQuantity() + " " + shares.getPrice());
            } else if (command.equalsIgnoreCase("sell")) {
                Block shares = new Block(quantity, price);
                if(!map.containsKey(key))
                {
                    System.out.println("You don´t have any shares of this company to sell");
                }
                else {
                    gain = sellShares(map, key, quantity, price);
                    System.out.println("You sold "+ quantity + " shares of company "+ key + " whith a gain of: " + gain);
                }
            }


          //  System.out.println(bag.peek().getQuantity() + " " + bag.peek().getPrice());

        } while (!command.contains("quit"));
    }

    public static double sellShares(Map<String, Queue<Block>> map, String key, int quantity, double price){

        double gain = 0;

        for(Map.Entry<String, Queue<Block>> entry : map.entrySet()) {

            Block stash = entry.getValue().peek();
            int avaShares = stash.getQuantity();
            double boughtPrice = 0 ;
            Queue<Block> bag = entry.getValue();
            while (quantity > 0 && !bag.isEmpty())
                if (avaShares < quantity) {
                    //while(avaShares < quantity && !bag.isEmpty()){
                    boughtPrice = stash.getPrice();
                    ;
                    gain += (price - boughtPrice) * avaShares;
                    ;
                    quantity = quantity - avaShares;
                    bag.remove();
                   stash = bag.peek();
                    avaShares = stash.getQuantity(); // Its breaking
                    //  }
//            gain += (price - boughtPrice) * quantity;;
//            stash.setQuantity(avaShares - quantity);
                } else if (avaShares == quantity) {
                    boughtPrice = stash.getPrice();
                    ;
                    gain += (price - boughtPrice) * avaShares;
                    bag.remove();
                } else if (avaShares > quantity) {
                    boughtPrice = stash.getPrice();
                    ;
                    gain += (price - boughtPrice) * quantity;
                    stash.setQuantity(avaShares - quantity);
                    quantity = 0;
                }
        }
        return gain;

    }
}
