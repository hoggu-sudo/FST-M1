package activities;

import java.util.ArrayList;

public class Activity8 {

    public static void main(String[] args) {

        // Create ArrayList
        ArrayList<String> myList = new ArrayList<>();

        // Add 5 names
        myList.add("John");
        myList.add("Sara");
        myList.add("David");
        myList.add("Emma");
        myList.add("Liam");

        // Print all names using for loop
        System.out.println("All Names:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Get 3rd name (index 2)
        System.out.println("\n3rd name: " + myList.get(2));

        // Check if name exists
        String searchName = "Emma";
        System.out.println("\nIs " + searchName + " present? " + myList.contains(searchName));

        // Print size
        System.out.println("\nTotal names: " + myList.size());

        // Remove a name by index
        myList.remove(1); // removes "Sara"

        // Print size after removal
        System.out.println("Size after removal: " + myList.size());

        // Updated list
        System.out.println("\nUpdated List:");
        for (String name : myList) {
            System.out.println(name);
        }
    }
}