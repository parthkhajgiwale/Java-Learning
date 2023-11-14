import java.util.LinkedList;
import java.util.Scanner;

public class LinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an element");
            System.out.println("2. Display elements");
            System.out.println("3. Add at a specific index");
            System.out.println("4. Remove an element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    String elementToAdd = scanner.nextLine();
                    linkedList.add(elementToAdd);
                    System.out.println("Element added successfully.");
                    break;

                case 2:
                    System.out.println("Elements in the LinkedList:");
                    displayLinkedList(linkedList);
                    break;

                case 3:
                    System.out.print("Enter the index to add at: ");
                    int indexToAdd = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the element to add: ");
                    String elementAtIndex = scanner.nextLine();
                    linkedList.add(indexToAdd, elementAtIndex);
                    System.out.println("Element added at index " + indexToAdd + " successfully.");
                    break;

                case 4:
                    System.out.print("Enter the element to remove: ");
                    String elementToRemove = scanner.nextLine();
                    boolean removed = linkedList.remove(elementToRemove);
                    if (removed) {
                        System.out.println("Element removed successfully.");
                    } else {
                        System.out.println("Element not found in the LinkedList.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display LinkedList in linked list style
    private static void displayLinkedList(LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
