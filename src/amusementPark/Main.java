package amusementPark;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 
 * Allows user to display a park map and displays closest ride by time to walk and wait time.  
 * User must upload a file with Amusement Park rides. 
 * Each file row should contain the ride name, average wait time, x-coordinate, y-coordinate,
 * connecting ride and time to get to connecting ride. 
 * 
 * @author Chantay Riggs & Raquel Montoya
 */
public class Main {
    public static void main(String[] args) {
    	String file = "resources/parkMap.txt";
    	ParkMap park = new ParkMap(file,",");
        RoutePlanner planner = new RoutePlanner(park);
        
        AmusementParkUI ui = new AmusementParkUI(park, planner);

        StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setXscale(0, 1); 
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();

        while (true) {
            StdDraw.clear();
            ui.drawMap();
            StdDraw.show();
            StdDraw.pause(20);

            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                ui.handleClick(x, y);
                StdDraw.pause(300);
            }
        }
    }
}
