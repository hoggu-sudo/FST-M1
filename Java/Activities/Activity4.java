package activities;

public class Activity4 {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];   // Current element to be placed correctly
            int j = i - 1;

            // Move elements that are greater than key
            // to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 3, 2, 10, 12, 1, 5, 6};

        System.out.println("Before Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        insertionSort(numbers);

        System.out.println("\nAfter Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
