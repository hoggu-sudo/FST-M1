package activities;

public class Activity1 {

    public static void main(String[] args) {

        // Create Car Object
        Car myCar = new Car();

        // Initialize values
        myCar.make = 2014;
        myCar.color = "Black";
        myCar.transmission = "Manual";

        // Display characteristics
        myCar.displayCharacteristics();

        System.out.println();

        // Accelerate
        myCar.accelerate();

        // Brake
        myCar.brake();
    }
}