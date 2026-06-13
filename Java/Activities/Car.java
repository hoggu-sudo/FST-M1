package activities;

public class Car {

    // Instance variables
    private String color;
    private String transmission;
    private int makeYear;
    private int tyres;
    private int doors;

    // Constructor
    public Car(String color, String transmission, int makeYear) {
        this.color = color;
        this.transmission = transmission;
        this.makeYear = makeYear;
        this.tyres = 4;
        this.doors = 4;
    }

    // Method to display characteristics
    public void displayCharacteristics() {
        System.out.println("---- Car Details ----");
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make Year: " + makeYear);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }

    // Accelerate method
    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    // Brake method
    public void brake() {
        System.out.println("Car has stopped.");
    }
}