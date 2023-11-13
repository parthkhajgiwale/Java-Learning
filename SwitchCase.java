import java.util.Scanner;

class Person {
    String name;
    int age;

    // Constructor to initialize the person's name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to introduce the person
    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }

    // Method to update the age of the person
    public void updateAge(int newAge) {
        this.age = newAge;
        System.out.println("Age updated to " + age + " years.");
    }
}

public class SwitchCase {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Get the user's name
        System.out.print("Enter your name: ");
        String userName = scanner.next();

        // Get the user's age
        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();

        // Create a Person object with the user's name and age
        Person userPerson = new Person(userName, userAge);

        // Menu for user to choose actions
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Introduce");
            System.out.println("2. Update Age");
            System.out.println("3. Exit");

            // Read the user's choice
            int choice = scanner.nextInt();

            // Switch statement for different actions based on user's choice
            switch (choice) {
                case 1:
                    // Introduce the person
                    userPerson.introduce();
                    break;

                case 2:
                    // Update the age
                    System.out.print("Enter the new age: ");
                    int newAge = scanner.nextInt();
                    userPerson.updateAge(newAge);
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Goodbye!");
                    // Close the scanner before exiting
                    scanner.close();
                    // Exit the program
                    System.exit(0);

                default:
                    // Inform the user about an invalid choice
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}
