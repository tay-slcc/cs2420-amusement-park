package amusementPark;

import java.util.Map;

import edu.princeton.cs.algs4.StdDraw;

public class AmusementParkUI {
    private ParkMap map;
    private RoutePlanner planner;

    public AmusementParkUI(ParkMap map, RoutePlanner planner) {
        this.map = map;
        this.planner = planner;
    }

    public void drawMap() {
        // loop through all rides in the park
            // draw a circle at each ride's (x, y) coordinate
            // draw the ride's name slightly above the circle
    }


    public void handleClick(double x, double y) {
        // loop through all rides to check if the click is near any ride's coordinates
            // claculate the distance between the click and the ride
            // if the click is within a small radius of the ride:
                // print or store the selected ride's name
                // call RoutePlanner to get total times from this ride
                // sort the results by total time
                // display the sorted ride names and total times
    }

}
