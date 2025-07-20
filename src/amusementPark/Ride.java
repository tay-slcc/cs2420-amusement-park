package amusementPark;

public class Ride {
    private String name;
    private int waitTime;
    private double x, y;

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
    public void setWaitTime(int waitTime) { 
    	this.waitTime = waitTime; 
	}
    public double getX() { 
    	return x; 
	}
    public double getY() { 
    	return y; 
	}
}
