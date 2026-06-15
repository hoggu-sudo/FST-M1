package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity10 {

    public static void main(String[] args) {

        // Create Map
        Map<Integer, String> colours = new HashMap<>();

        // Add 5 colours
        colours.put(101, "Red");
        colours.put(102, "Blue");
        colours.put(103, "Green");
        colours.put(104, "Yellow");
        colours.put(105, "Purple");

        // Print the Map
        System.out.println("Initial Map: " + colours);

        // Remove one colour (by key)
        String removedColor = colours.remove(104);
        System.out.println("Removed Colour: " + removedColor);

        // Check if "Green" exists
        if (colours.containsValue("Green")) {
            System.out.println("Green is present in the Map");
        } else {
            System.out.println("Green is not present in the Map");
        }

        // Print size
        System.out.println("Total number of entries: " + colours.size());

        // Print updated Map
        System.out.println("Updated Map: " + colours);
    }
}
