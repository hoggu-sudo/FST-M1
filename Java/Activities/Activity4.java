package activities;

import java.util.Arrays;

public class Activity4 {

    // Insertion Sort Method
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int position = i;

            // Shift elements to the right to make space
            while (position > 0 && arr[position - 1] > current) {
                arr[position] = arr[position - 1];
                position--;
            }

            // Insert element at correct position
            arr[position] = current;
        }
    }

    public static void main(String[] args) {

        int[] numbers = {12, 4, 7, 3, 9, 1};

        // Before sorting
        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(numbers));

        // Perform sorting
        insertionSort(numbers);

        // After sorting
        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(numbers));
    }
}