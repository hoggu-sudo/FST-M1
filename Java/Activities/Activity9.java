package activities;

import java.util.HashSet;

public class Activity9 {

    public static void main(String[] args) {

        // Create HashSet
        HashSet<String> hs = new HashSet<>();

        // Add 6 elements
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Cherry");
        hs.add("Date");
        hs.add("Apple");   // duplicate (will not be added)
        hs.add("Mango");

        // Display set
        System.out.println("Initial Set: " + hs);

        // Print size
        System.out.println("Size of Set: " + hs.size());

        // Remove an existing element
        boolean removed = hs.remove("Banana");
        System.out.println("Removed Banana: " + removed);

        // Try removing an element not present
        if (!hs.remove("Orange")) {
            System.out.println("Orange not found in the set");
        }

        // Check if element exists
        System.out.println("Contains Mango? " + hs.contains("Mango"));

        // Final updated set
        System.out.println("Final Set: " + hs);
    }
}