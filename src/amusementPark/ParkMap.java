package amusementPark;

import java.util.*;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;

public class ParkMap {
    private Map<String, Ride> rides = new HashMap<>();
    private Map<String, Integer> rideToIndex = new HashMap<>();
    private Map<Integer, String> indexToRide = new HashMap<>();
    private EdgeWeightedDigraph graph;

    public ParkMap(int numRides) {
        // init the EdgeWeightedDigraph with the given number of rides
    }


    public void addRide(Ride ride, int index) {
        // add the ride to the rides map
        // store the ride's name and corresponding index in rideToIndex
        // store the inxed and ride name in indexToRide
    }


    public void connectRides(String from, String to, double walkTime) {
        // look up the graph indices for the 'from' and 'to' ride names
        // create a DirectedEdge from 'from' to 'to' with the walk time
        // add the edge to the graph
    }


    public Ride getRide(String name) { 
    	return rides.get(name); 
	}
    public Collection<Ride> getAllRides() { 
    	return rides.values(); 
	}
    public int getIndex(String rideName) { 
    	return rideToIndex.get(rideName); 
	}
    public String getRideName(int index) { 
    	return indexToRide.get(index); 
	}
    public EdgeWeightedDigraph getGraph() { 
    	return graph; 
	}
}
