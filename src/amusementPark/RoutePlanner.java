package amusementPark;

import java.util.*;
import edu.princeton.cs.algs4.DijkstraSP;

public class RoutePlanner {
    private ParkMap map;

    public RoutePlanner(ParkMap map) {
        this.map = map;
    }

    public Map<String, Double> getTotalTimes(String startRide) {
        // create a map to store total times to each ride
        // get the graph index of the starting ride
        // run Dijkstra's algorithm from the starting ride index
        // for each ride in the park:
            // get the ride's graph index
            // if there is a path to that ride:
                // get the walk time from Dijkstra
                // add the ride's wait time
                // store the total time in the result map

        // return the map of ride names to total times
    	
    }

}
