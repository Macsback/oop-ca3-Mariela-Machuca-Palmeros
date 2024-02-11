
    public class DistanceTo implements Comparable<DistanceTo>
    {
        private final String target;
        private final int distance;
        public DistanceTo(String city, int dist)
        {
            target = city;
            distance = dist;
        }
        public String getTarget()
        {
            return target;
        }
        public int getDistance()
        {
            return distance;
        }
        public int compareTo(DistanceTo other)
        {
            return distance - other.distance;
        }

        @Override
        public String toString() {
            return "DistanceTo{" +
                    "target='" + target + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }

