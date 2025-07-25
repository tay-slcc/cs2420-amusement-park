package amusementPark;

import java.awt.Color;
import java.awt.Font;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Handles ui for the amusement park map.
 * 
 * Displays all rides on a canvas and handles user interaction.
 * When a ride is clicked, it calculates the total time (walk + wait)
 * from that ride to all others and then updates each ride's label to show the total time,
 * and highlights the five rides with the shortest total times.
 * 
 * @author Chantay Riggs & Raquel Montoya
 */
public class AmusementParkUI {
    private ParkMap map;
    private RoutePlanner planner;
    private Ride selectedRide = null;
    private ST<String, Double> currentTimes = new ST<>();
    private SET<String> topRides = new SET<>();

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
    	
    	String font = "Comic Sans MS";
    	StdDraw.picture(0.5, 0.5, "resources/background_faint.png", 1.0, 1.0);
    	Font regular = new Font(font, Font.PLAIN, 14);
    	Font bold = new Font(font, Font.BOLD, 11);
    	Font boldTitle = new Font(font, Font.BOLD, 14);
    	
    	Color darkRed = new Color(178, 34, 34);      
    	Color mutedBlue = new Color(70, 130, 180);   
    	Color softGreen = new Color(60, 179, 113);   
    	Color darkGray = new Color(50, 50, 50);      
    	
    	// title 
        StdDraw.setFont(new Font(font, Font.BOLD, 28));
        StdDraw.setPenColor(darkGray);
        StdDraw.text(0.5, 0.95, "Amusement Park Guide");

        StdDraw.setFont(regular);
    	
        for (Ride ride : map.getAllRides()) {
            double x = ride.getX();
            double y = ride.getY();
            String name = ride.getName();

            // Ride label dot
            if (ride == selectedRide) {
                StdDraw.setPenColor(darkRed);
                drawRideIcon(ride);
                StdDraw.setPenColor(darkRed);
                StdDraw.circle(x, y, 0.08);
            } else if (topRides.contains(name)) {
                StdDraw.setPenColor(softGreen);
                drawRideIcon(ride);
            } else {
                StdDraw.setPenColor(mutedBlue);
                drawRideIcon(ride);
            }

            // Label
            StdDraw.setPenColor(darkGray);
            if (currentTimes.contains(name)) {
                double time = currentTimes.get(name);

                StdDraw.setFont(regular);
                StdDraw.text(x, y + 0.04, name);

                StdDraw.setFont(bold);
                if (topRides.contains(name)) {
                	StdDraw.setPenColor(softGreen);
                }
                StdDraw.text(x, y + 0.023, String.format("(%d min)", Math.round(time)));
            } else {
            	if (selectedRide != null) {
            		StdDraw.setFont(boldTitle);
                    StdDraw.setPenColor(darkRed);
            	}
                StdDraw.text(x, y + 0.025, name);
            	if (selectedRide != null) {
            		StdDraw.setFont(bold);
                    StdDraw.text(x, y - 0.03, "You are here");
            	}
            }
        }
    }

    /**
     * Handles mouse click.
     * 
     * If the click occurs near a ride, program finds the total time
     * (walk + wait) from that ride to all others, updates the labels to display
     * these times, and highlights the five rides with the shortest total times.
     *
     * @param x the x coordinate of the click
     * @param y the y coordinate of the click
     */
    public void handleClick(double x, double y) {
        final double RADIUS = 0.06;

        for (Ride ride : map.getAllRides()) {
            double dx = x - ride.getX();
            double dy = y - ride.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance < RADIUS) {
                selectedRide = ride;
                currentTimes = planner.getTotalTimes(ride.getName());

                MinPQ<String> pq = new MinPQ<>((s1, s2) -> {
                    double t1 = currentTimes.get(s1);
                    double t2 = currentTimes.get(s2);
                    return Double.compare(t1, t2);
                });

                for (String name : currentTimes.keys()) {
                    pq.insert(name);
                }

                topRides = new SET<>();
                int count = 0;
                while (!pq.isEmpty() && count < 5) {
                    topRides.add(pq.delMin());
                    count++;
                }

                break;
            }
        }
    }
    
    private void drawRideIcon(Ride ride) {
    	String icon = ride.getIconPath();
        StdDraw.picture(ride.getX(), ride.getY(), icon, 0.06, 0.06);
    }


}
