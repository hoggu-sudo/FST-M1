package activities;

import java.util.Scanner;

public class Activity13 {

    // Method to register user
    public void registerUser(String inputAge) {

        try {
            // Convert String to int
            int age = Integer.parseInt(inputAge);

            // Validate age
            if (age < 18) {
                throw new IllegalArgumentException("Users must be at least 18 years old.");
            }

            // Success message
            System.out.println("Registration successful! Welcome aboard.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Age must be a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        String ageInput = sc.nextLine();

        // Create object and call method
        Activity13 obj = new Activity13();
        obj.registerUser(ageInput);

        sc.close();
    }
}
