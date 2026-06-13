package activities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Encapsulated Plane class
class Plane {

    private List<String> passengers;
    private int maxPassengers;
    private Date takeOffTime;
    private Date landingTime;

    // Constructor
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // Add passenger
    public void onboard(String name) {
        if (passengers.size() < maxPassengers) {
            passengers.add(name);
            System.out.println(name + " boarded successfully.");
        } else {
            System.out.println("Cannot board " + name + " - Plane is full!");
        }
    }

    // Take off
    public Date takeOff() {
        takeOffTime = new Date();
        return takeOffTime;
    }

    // Land plane
    public void land() {
        landingTime = new Date();
        passengers.clear(); // Clear passenger list after landing
    }

    // Get landing time
    public Date getLastTimeLanded() {
        return landingTime;
    }

    // Get passengers
    public List<String> getPassengers() {
        return new ArrayList<>(passengers); // Return copy for safety
    }
}

// Driver class
public class Activity6 {

    public static void main(String[] args) {

        try {
            Plane plane = new Plane(10);

            // Onboard passengers
            plane.onboard("Alice");
            plane.onboard("Bob");
            plane.onboard("Charlie");

            // Take off
            System.out.println("Takeoff Time: " + plane.takeOff());

            // Show passengers
            System.out.println("Passengers onboard: " + plane.getPassengers());

            // Simulate flight
            System.out.println("Plane is in flight...");
            Thread.sleep(5000);

            // Land
            plane.land();
            System.out.println("Landing Time: " + plane.getLastTimeLanded());

            // After landing
            System.out.println("Passengers after landing: " + plane.getPassengers());

        } catch (InterruptedException e) {
            System.out.println("Simulation interrupted.");
        }
    }
}