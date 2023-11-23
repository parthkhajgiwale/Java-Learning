import java.util.Scanner;

// Base class
class Animal {
    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
    }
}

// Derived class (inherits from Animal)
class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age); // Call the constructor of the base class
        this.breed = breed;
    }

    // Getter method for breed
    public String getBreed() {
        return breed;
    }

    // Display method (overrides the displayInfo method in the base class)
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo method of the base class
        System.out.println("Breed: " + breed);
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the dog
        System.out.print("Enter dog's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter dog's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter dog's breed: ");
        String breed = scanner.nextLine();

        // Create a Dog object using user input
        Dog myDog = new Dog(name, age, breed);

        // Display information about the dog using the displayInfo method
        System.out.println("\nDog Information:");
        myDog.displayInfo();

        scanner.close();
    }
}
