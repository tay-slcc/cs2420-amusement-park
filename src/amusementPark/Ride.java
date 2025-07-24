package amusementPark;

/**
 * Stores a ride object by name, wait time, and (x, y) coordinates.
 * 
 * @author Chantay Riggs & Raquel Montoya
 */
public class Ride implements Comparable<Ride> {
    private String name;
    private Integer waitTime;
    private Double x, y;

    /**
     * Constructs a Ride with the given name, wait time, and coordinates.
     *
     * @param name      the ride's name
     * @param waitTime  the average wait time in minutes
     * @param x         the x-coordinate for drawing the ride
     * @param y         the y-coordinate for drawing the ride
     */
    public Ride(String name, int waitTime, double x, double y) {
        this.name = name;
        this.waitTime = waitTime;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Ride getRide() {
        return this;
    }

    @Override
    public int compareTo(Ride o) {
        int cmp = this.waitTime.compareTo(o.waitTime);
        if (cmp != 0) return cmp;

        cmp = this.y.compareTo(o.y);
        if (cmp != 0) return cmp;

        cmp = this.x.compareTo(o.x);
        if (cmp != 0) return cmp;

        return this.name.compareTo(o.name);
    }
}
