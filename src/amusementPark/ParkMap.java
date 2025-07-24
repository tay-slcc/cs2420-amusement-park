package amusementPark;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Edge;

/**
 * 
 * Builds park map by inputing a parkMap file. 
 * Symbol tables are used to associate ride names with Ride objects and index values.
 * An edge weighted graph is used to represented the ride and the connecting rides. 
 * 
 * @author Chantay Riggs & Raquel Montoya
 */
public class ParkMap {
    ST<String, Integer> rNames;
    private ST<Ride, Integer> rideToIndex = new ST<>(); 
    ST<Integer, Ride> indexToRide = new ST<>(); 
    private String[] keys;           // index  -> string          
    private EdgeWeightedGraph graph; // the underlying graph
    private ST<String, Double> rideWait = new ST<>();
    
    /**
     * Initializes the ride map from file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by an adjacent vertex, 
     * and the weight of the edge, separated by the delimiter.
     * @param filename the name of the file
     * @param delimiter the delimiter between fields
     */
    public ParkMap(String file, String delimiter) {
    	rideToIndex = new ST<Ride, Integer>();
    	rNames = new ST<String, Integer>();
    	// associates ride names to index
        In in = new In(file);
        while (!in.isEmpty()) {
        	String[] r = in.readLine().split(delimiter);
        	for (int i = 0; i < r.length; i++) {
        		String name = r[0];
        		int waitTime = Integer.parseInt(r[1]);
        		double x = Double.parseDouble(r[2]);
        		double y = Double.parseDouble(r[3]);
        		Ride ride = new Ride(name, waitTime, x, y);
        		 if (!rideToIndex.contains(ride)) {
        			 int index = rideToIndex.size();
        			 rideToIndex.put(ride, index);
        			 indexToRide.put(index, ride);
        			 rNames.put(name, rNames.size());
        			 //rideWait.put(name, waitTime);
        		 }
        		
                }
            }
        
        // inverted index to get string keys in an array
        keys = new String[rNames.size()];
        for (String name : rNames.keys()) {
            keys[rNames.get(name)] = name;
    
        }
        System.out.println();
    	
        //builds the graph by connecting vertices with weighted edges
        graph = new EdgeWeightedGraph(rNames.size());
        in = new In(file);
        while (in.hasNextLine()) {
            String[] dist = in.readLine().split(delimiter);
            int v = rNames.get(dist[0]); //gets first column vertex
            int w = rNames.get(dist[4]); //gets connected vertex column
            double d = Double.parseDouble(dist[5]);
            Edge e = new Edge(v, w, d);
            graph.addEdge(e);            
        }

    }

    /**
     * Returns ride object based on ride name provided.
     * @param name
     * @return Ride
     */
    public Ride getRide(String name) { 
    	return indexToRide.get(rNames.get(name));
   }

    /**
     * Returns an iterable collection of all rides in the park.
     * This allows external classes, such as the UI, to loop through
     * and access each Ride object currently stored in the map.
     *
     * @return an Iterable of Ride objects representing all rides in the park
     */
    public Iterable<Ride> getAllRides() {
        return rideToIndex.keys();
    }
	 
    /**
     * Returns the index based on the ride name provided.
     * @param rideName
     * @return Ride Index
     */
    public int getIndex(String rideName) { 
    	return rNames.get(rideName); 
	}
    
    /**
     * Returns the ride name based on index provided.
     * @param index
     * @return Ride name
     */
    public String getRideName(int index) { 
    	return indexToRide.get(index).getName();
	}
    
    /**
     * Returns the graph associated with the park map.
     * @return graph
     */
    public EdgeWeightedGraph getGraph() { 
    	return graph; 
	}
  
    
}
