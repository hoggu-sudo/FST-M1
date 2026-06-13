package activities;


//Interface for parts
interface BicycleParts {
 int tyres = 2;
 int maxSpeed = 40;
}

//Interface for operations
interface BicycleOperations {
 void applyBrake(int value);
 void speedUp(int value);
}

//Base class
class Bicycle implements BicycleParts, BicycleOperations {

 private int gears;
 private int currentSpeed;

 // Constructor
 public Bicycle(int gears, int currentSpeed) {
     this.gears = gears;
     this.currentSpeed = currentSpeed;
 }

 // Apply brake
 public void applyBrake(int value) {
     currentSpeed -= value;
     if (currentSpeed < 0) currentSpeed = 0;
     System.out.println("Speed after brake: " + currentSpeed);
 }

 // Increase speed
 public void speedUp(int value) {
     currentSpeed += value;
     if (currentSpeed > maxSpeed) currentSpeed = maxSpeed;
     System.out.println("Speed after acceleration: " + currentSpeed);
 }

 // Description
 public String bicycleDesc() {
     return "No of Gears are: " + gears +
            "\nMax Speed of bicycle is: " + maxSpeed;
 }

 // Getter
 public int getCurrentSpeed() {
     return currentSpeed;
 }
}

//Derived class
class MountainBike extends Bicycle {

 private int seatHeight;

 public MountainBike(int gears, int speed, int height) {
     super(gears, speed);
     this.seatHeight = height;
 }

 // Setter
 public void setHeight(int height) {
     this.seatHeight = height;
 }

 // Override method
 @Override
 public String bicycleDesc() {
     return super.bicycleDesc() + 
            "\nSeat Height: " + seatHeight;
 }
}

//Driver class
public class Activity7 {
 public static void main(String[] args) {

     MountainBike bike = new MountainBike(4, 5, 18);

     System.out.println("Bike Info:\n" + bike.bicycleDesc());

     bike.speedUp(20);
     bike.applyBrake(7);

     bike.setHeight(22);
     System.out.println("\nUpdated Bike Info:\n" + bike.bicycleDesc());
 }
}
