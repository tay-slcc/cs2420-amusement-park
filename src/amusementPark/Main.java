package amusementPark;

import edu.princeton.cs.algs4.StdDraw;

public class Main {
    public static void main(String[] args) {
        ParkMap park = new ParkMap(20);

        park.addRide(new Ride("SkySlicer", 10, 0.10, 0.80), 0);
        park.addRide(new Ride("Mystic Mine", 5, 0.20, 0.65), 1);
        park.addRide(new Ride("Cyclone", 8, 0.30, 0.85), 2);
        park.addRide(new Ride("Bubble Bounce", 3, 0.40, 0.60), 3);
        park.addRide(new Ride("Inferno Loop", 7, 0.50, 0.90), 4);
        park.addRide(new Ride("Ghostlight Express", 4, 0.15, 0.40), 5);
        park.addRide(new Ride("Pharaoh’s Curse", 6, 0.25, 0.30), 6);
        park.addRide(new Ride("Log Flume", 9, 0.35, 0.45), 7);
        park.addRide(new Ride("TimeTwister", 4, 0.45, 0.25), 8);
        park.addRide(new Ride("Drop Zone", 7, 0.55, 0.40), 9);
        park.addRide(new Ride("Dragon’s Hollow", 6, 0.65, 0.60), 10);
        park.addRide(new Ride("Treetop Trek", 3, 0.75, 0.75), 11);
        park.addRide(new Ride("Giggly Galaxy", 2, 0.85, 0.55), 12);
        park.addRide(new Ride("Vortex X", 10, 0.70, 0.35), 13);
        park.addRide(new Ride("Apex Accelerator", 6, 0.60, 0.20), 14);
        park.addRide(new Ride("Whispering Woods", 5, 0.50, 0.10), 15);
        park.addRide(new Ride("SplashSprout", 4, 0.40, 0.15), 16);
        park.addRide(new Ride("Honeybee Carousel", 3, 0.30, 0.10), 17);
        park.addRide(new Ride("Jellybean Jet", 2, 0.20, 0.15), 18);
        park.addRide(new Ride("Starlight Skylift", 5, 0.10, 0.25), 19);


        park.connectRides("SkySlicer", "Mystic Mine", 3);
        park.connectRides("Mystic Mine", "Cyclone", 2);
        park.connectRides("Cyclone", "Inferno Loop", 3);
        park.connectRides("Inferno Loop", "Treetop Trek", 2);
        park.connectRides("Treetop Trek", "Dragon’s Hollow", 2);
        park.connectRides("Dragon’s Hollow", "Drop Zone", 3);
        park.connectRides("Drop Zone", "TimeTwister", 3);
        park.connectRides("TimeTwister", "Log Flume", 2);
        park.connectRides("Log Flume", "Pharaoh’s Curse", 3);
        park.connectRides("Pharaoh’s Curse", "Ghostlight Express", 2);
        park.connectRides("Ghostlight Express", "Bubble Bounce", 3);
        park.connectRides("Bubble Bounce", "SplashSprout", 2);
        park.connectRides("SplashSprout", "Honeybee Carousel", 2);
        park.connectRides("Honeybee Carousel", "Jellybean Jet", 2);
        park.connectRides("Jellybean Jet", "Starlight Skylift", 2);
        park.connectRides("Starlight Skylift", "SkySlicer", 4);
        park.connectRides("Giggly Galaxy", "Dragon’s Hollow", 3);
        park.connectRides("Vortex X", "Apex Accelerator", 2);
        park.connectRides("Apex Accelerator", "Whispering Woods", 3);
        park.connectRides("Whispering Woods", "SplashSprout", 3);


        RoutePlanner planner = new RoutePlanner(park);
        AmusementParkUI ui = new AmusementParkUI(park, planner);

        StdDraw.setCanvasSize(1000, 1000);
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
