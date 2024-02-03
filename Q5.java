import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
//        System.out.println("Please introduce your command with the following format");
//        System.out.println("Command + flight Symbol (only if required)");
        System.out.println("The Runway is ready for operation");
        Scanner kbrd = new Scanner(System.in);
        String command = "";
        String flightCode = "";
        Queue<String> takeoffs = new LinkedList<>();
        Queue<String> landings = new LinkedList<>();

        do {

             command = kbrd.nextLine().toLowerCase(Locale.ROOT);
            
            if (command.contains("takeoff")) {
                flightCode = getFlightNo(8, command);
                System.out.println("Flight " + flightCode + " is queued for takeoff");
//            takeoff(flightCode);
                takeoffs.add(flightCode);
            } else if (command.contains("land")) {
                flightCode = getFlightNo(5, command);
//            land(flightCode, landings);
                System.out.println("Flight " + flightCode + " is queued for landing");
                landings.add(flightCode);

            } else if (command.contains("next")) {
                String nextFlight = " ";
                if(landings.isEmpty() && !takeoffs.isEmpty()){
                    nextFlight = takeoffs.remove();
                    System.out.println("Flight " + nextFlight + " has taken off");
                }

                else if (!landings.isEmpty()) {
                    nextFlight = landings.remove();
                    System.out.println("Flight " + nextFlight + " has landed");
                }
                else{
                    System.out.println("No Flights are queued");
                }
            }
        } while(!command.contains("quit"));

        System.out.println("The Runway has closed for Operation");

    }

    public static String getFlightNo(int index, String Command){
        String flightCode = Command.substring(index);
        flightCode = flightCode.toUpperCase();

        return flightCode;
    }
//    public static void land(String command, Queue landings) {
//    }
//
//    public static void takeoff(String command) {
//    }
}
