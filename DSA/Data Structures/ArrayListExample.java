/*
In Java, an ArrayList is a part of the java.util package and is a dynamic array implementation.
Unlike regular arrays in Java, ArrayLists can grow or shrink dynamically as elements are added or removed. 
This flexibility makes ArrayLists a popular choice when you need a dynamic, resizable collection of elements.

Here are some key characteristics of ArrayList:

1. Dynamic Sizing: ArrayList automatically grows or shrinks in size as elements are added or removed. You do not need to specify the size initially.

2. Random Access: Elements in an ArrayList can be directly accessed using an index, providing constant-time access.

3. Generic: ArrayList is a generic class, meaning you can use it to store elements of any data type (e.g., integers, strings, custom objects).

4. Methods: ArrayList provides various methods for adding, removing, and accessing elements. Some common methods include add(), remove(), get(), size(), and others.

5. Null Elements: ArrayList allows null elements, meaning you can store null values in the list.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an ArrayList to store integers
        ArrayList<Integer> numbersList = new ArrayList<>();

        // Get the number of elements to be added to the list
        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();

        // Prompt the user to enter each element and add it to the list
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int element = scanner.nextInt();
            numbersList.add(element);
        }

        // Display the elements in the list
        System.out.println("Elements in the list:");
        for (int i : numbersList) {
            System.out.println(i);
        }

        scanner.close();
    }
}
