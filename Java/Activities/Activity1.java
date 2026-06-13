package activities;

public class Activity1 {

    public static void main(String[] args) {

        // Create Car object
        Car myCar = new Car("Black", "Manual", 2014);

        // Display details
        myCar.displayCharacteristics();

        // Perform actions
        myCar.accelerate();
        myCar.brake();
    }
}