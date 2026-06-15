package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity12 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        System.out.println("Enter integers (type any non-integer to stop):");

        // Accept integers from user
        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        // Check if list is empty
        if (list.isEmpty()) {
            System.out.println("No valid integers were entered.");
        } else {
            // Convert list to array
            Integer[] numbers = list.toArray(new Integer[0]);

            // Generate random index
            int randomIndex = random.nextInt(numbers.length);

            // Print results
            System.out.println("Generated Index: " + randomIndex);
            System.out.println("Value at that index: " + numbers[randomIndex]);
        }

        scan.close();
    }
}