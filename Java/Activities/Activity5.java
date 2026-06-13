package activities;


//Abstract class
abstract class Book {
 private String title;

 // Abstract method
 abstract void setTitle(String title);

 // Concrete method
 public String getTitle() {
     return title;
 }

 // Protected setter helper (optional design improvement)
 protected void assignTitle(String title) {
     this.title = title;
 }
}

//Derived class
class MyBook extends Book {

 @Override
 public void setTitle(String title) {
     // Use helper method to assign value
     assignTitle(title);
 }
}

//Driver class
public class Activity5 {
 public static void main(String[] args) {

     // Create object
     MyBook newNovel = new MyBook();

     // Initialize title
     String bookTitle = "AI and the Future";

     // Set title
     newNovel.setTitle(bookTitle);

     // Display result
     System.out.println("The title is: " + newNovel.getTitle());
 }
}