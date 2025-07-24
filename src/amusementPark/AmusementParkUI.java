package amusementPark;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;

public class AmusementParkUI {
    private ParkMap map;
    private RoutePlanner planner;
    private Ride selectedRide = null;

    public AmusementParkUI(ParkMap map, RoutePlanner planner) {
        this.map = map;
        this.planner = planner;
    }

    public void drawMap() {
        for (Ride ride : map.getAllRides()) {
            double x = ride.getX();
            double y = ride.getY();

            if (ride == selectedRide) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(x, y, 0.015);
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledCircle(x, y, 0.01);
            }

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(x, y + 0.02, ride.getName());
        }
    }

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
