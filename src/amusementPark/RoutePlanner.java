package amusementPark;

import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.ST;

/**
 * 
 * Allows user to input a ride name and see all the other rides on the map by a value
 * calculated by the weighted edge and the ride's average wait time. 
 * 
 * @author Chantay Riggs & Raquel Montoya
 */
public class RoutePlanner {
    private ParkMap map;

    public RoutePlanner(ParkMap map) {
        this.map = map;
    }

    /**
     * Calculates total time (walk time + wait time) from the given ride to all other rides,
     * excluding the starting ride itself.
     *
     * @param startRide the name of the starting ride
     * @return a symbol table mapping ride names to total travel+wait time
     */
    public ST<String, Double> getTotalTimes(String startRide) {
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
    	
        // map.getIndex(startRide); //gets index from name
    	
        ST<String, Double> tTime = new ST<>();
        int startIndex = map.getIndex(startRide);
        DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(map.getGraph(), startIndex);

        for (int i = 0; i < map.rNames.size(); i++) {
            if (i == startIndex) continue; // skip the starting ride :)

            String nextRide = map.indexToRide.get(i).getName();
            double walkTime = dsp.distTo(i);
            double waitTime = map.indexToRide.get(i).getWaitTime();
            double totalTime = walkTime + waitTime;
            tTime.put(nextRide, totalTime);
        }

        return tTime;
    }

    //get top shortest times
    public MinPQ getTopTimes() {
        // TODO
        return null;
    }
}
