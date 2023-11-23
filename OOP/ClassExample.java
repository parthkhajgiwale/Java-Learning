// Importing a package to use the Scanner class for user input
import java.util.Scanner;

// Define the Person class
class Person {
    // Attributes or fields of the Person class
    String name;
    int age;

    // Constructor to initialize the object with a name and age
    public Person(String name, int age) {
        // Using 'this' to refer to the current object's attributes
        this.name = name;
        this.age = age;
    }

    // Method to introduce the person
    public void introduce() {
        // Printing a simple introduction message
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

// Main class to demonstrate the example
public class ClassExample {
    public static void main(String[] args) {
        // Creating a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter a name
        System.out.print("Enter your name: ");
        // Reading the name input from the user
        String userName = scanner.next();

        // Prompting the user to enter an age
        System.out.print("Enter your age: ");
        // Reading the age input from the user
        int userAge = scanner.nextInt();

        // Creating an instance (object) of the Person class using user input
        Person userPerson = new Person(userName, userAge);

        // Calling the introduce method to display the user's introduction
        userPerson.introduce();

        // Closing the scanner to free up resources
        scanner.close();
    }
}
