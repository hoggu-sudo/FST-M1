package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] numbers = {10, 77, 10, 54, -11, 10};
        int sum = 0;

        // Find all 10's and add them
        for (int num : numbers) {
            if (num == 10) {
                sum += num;
            }
        }

        // Check if the sum is equal to 30
        if (sum == 30) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
