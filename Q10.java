//Question answered with the help of Aleksandra Kail
//https://github.com/Al3x-K/Programming_CA3/blob/main/src/main/java/CA3_Question10.java


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Q10 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(new File("map.txt"));
        String sTown = "Pittsburgh";

        Map<String, Set<DistanceTo>> connections = new HashMap<>();

        while(read.hasNext()) {

            String line = read.nextLine();
            String[] data = line.split(" ");
            String city1 = data[0];
            String city2 = data[1];
            String distance = data[2];

            int dis = Integer.parseInt(distance);

            if (!connections.containsKey(city1)) {
                connections.put(city1, new HashSet<>());
            }
            connections.get(city1).add(new DistanceTo(city2, dis));

            if (!connections.containsKey(city2)) {
                connections.put(city2, new HashSet<>());
            }
            connections.get(city2).add(new DistanceTo(city1, dis));


        }
        Map<String, Integer> shortestDistance = new HashMap<>();
        PriorityQueue<DistanceTo> pQueue = new PriorityQueue<>();
        pQueue.add(new DistanceTo(sTown,0));


        while(!pQueue.isEmpty())
        {
            DistanceTo current = pQueue.poll(); //get city with the shortest known distance
            String curCity = current.getTarget(); //get name of the current city
            int currDist = current.getDistance();

            if(!shortestDistance.containsKey(curCity))
            {
                shortestDistance.put(curCity,currDist);

                //check direct connections from the current city and update the queue
                Set<DistanceTo> directConn = connections.get(curCity);


                for (DistanceTo conn : directConn)
                {
                    int newDist = currDist + conn.getDistance(); //calculate new distance
                    pQueue.offer(new DistanceTo(conn.getTarget(),newDist)); //adds connection to the queue
                }
            }
        }
        for(Map.Entry<String,Integer> entry : shortestDistance.entrySet())
        {
            System.out.println("Shortest distance from " + sTown + " to " + entry.getKey() + ": " + entry.getValue());
        }

        }
}
