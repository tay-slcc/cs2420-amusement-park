package amusementPark;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Handles ui for the amusement park map.
 * 
 * Displays all rides on a canvas and handles user interaction.
 * When a ride is clicked, it calculates the total time (walk + wait)
 * from that ride to all others and then updates each ride's label to show the total time,
 * and highlights the five rides with the shortest total times.
 */
public class AmusementParkUI {
    private ParkMap map;
    private RoutePlanner planner;
    private Ride selectedRide = null;

    /**
     * Constructs a UI controller for the amusement park map.
     *
     * @param map     the ParkMap containing ride data and layout
     * @param planner the RoutePlanner for computing shortest paths
     */
    public AmusementParkUI(ParkMap map, RoutePlanner planner) {
        this.map = map;
        this.planner = planner;
    }

    /**
     * Draws all rides on the canvas.
     * 
     * Rides are shown with dot labels positioned by their coordinates.
     * The selected ride is shown in red. The five rides with the shortest
     * total times are outlined with a circle around that. Each ride displays
     * its name and total time from the selected ride, if available.
     */
    public void drawMap() {
        for (Ride ride : map.getAllRides()) {
            double x = ride.getX();
            double y = ride.getY();
            String name = ride.getName();

            // TODO: highlight top 5 rides

            if (ride == selectedRide) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(x, y, 0.015);
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledCircle(x, y, 0.01);
            }

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(x, y + 0.02, name);
            // TODO: include time in label
        }
    }

    /**
     * Handles mouse click.
     * 
     * If the click occurs near a ride, program calculates the total time
     * (walk + wait) from that ride to all others, updates the labels to display
     * these times, and highlights the five rides with the shortest total times.
     *
     * @param x the x coordinate of the click
     * @param y the y coordinate of the click
     */
    public void handleClick(double x, double y) {
        final double RADIUS = 0.02;

        for (Ride ride : map.getAllRides()) {
            double dx = x - ride.getX();
            double dy = y - ride.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            
            if (distance < RADIUS) {
                ST<String, Double> totalTimes = planner.getTotalTimes(ride.getName());

                //sort all rides by total time
                MinPQ<String> pq = new MinPQ<>((s1, s2) -> {
                    double t1 = totalTimes.get(s1);
                    double t2 = totalTimes.get(s2);
                    return Double.compare(t1, t2);
                });

                for (String name : totalTimes.keys()) {
                    pq.insert(name);
                }
                
                // TODO: instead of printing, display all times visually

                System.out.println("\nRides from " + ride.getName() + " (sorted by total time):");
                while (!pq.isEmpty()) {
                    String name = pq.delMin();
                    double time = totalTimes.get(name);
                    System.out.printf("%s: %.2f mins\n", name, time);
                }

                break;
            }
        }
    }
}
