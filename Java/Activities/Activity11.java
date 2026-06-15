package activities;

//Functional Interface
interface Addable {
 int add(int x, int y);
}

public class Activity11 {

 public static void main(String[] args) {

     // Lambda expression without explicit return
     Addable addition1 = (x, y) -> x + y;

     // Lambda with block body
     Addable addition2 = (x, y) -> {
         int result = x + y;
         return result;
     };

     // Using the lambdas
     int result1 = addition1.add(15, 25);
     int result2 = addition2.add(50, 75);

     System.out.println("Result 1: " + result1);
     System.out.println("Result 2: " + result2);
 }
}
