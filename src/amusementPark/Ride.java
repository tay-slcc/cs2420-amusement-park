package amusementPark;

/**
 * Stores a ride object by name, wait time, coordinates, and an associated icon path.
 * 
 * @author Chantay Riggs & Raquel Montoya
 */
public class Ride implements Comparable<Ride> {
    private String name;
    private Integer waitTime;
    private Double x, y;
    private String iconPath;

    /**
     * Constructs a Ride with the given name, wait time, coordinates, and icon path.
     *
     * @param name      the ride's name
     * @param waitTime  the average wait time in minutes
     * @param x         the x-coordinate for drawing the ride
     * @param y         the y-coordinate for drawing the ride
     * @param iconPath  the file path to the ride's icon image
     */
    public Ride(String name, int waitTime, double x, double y, String iconPath) {
        this.name = name;
        this.waitTime = waitTime;
        this.x = x;
        this.y = y;
        this.iconPath = iconPath;
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

    public String getIconPath() {
        return iconPath;
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
