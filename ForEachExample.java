import java.util.ArrayList;

// Student class representing a simple object with name and age attributes
class Student {
    private String name;
    private int age;

    // Constructor to initialize the Student object with name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method to retrieve the name of the student
    public String getName() {
        return name;
    }

    // Getter method to retrieve the age of the student
    public int getAge() {
        return age;
    }
}

public class ForEachExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Student objects
        ArrayList<Student> studentList = new ArrayList<>();

        // Adding Student objects to the ArrayList
        studentList.add(new Student("Alice", 20));
        studentList.add(new Student("Bob", 22));
        studentList.add(new Student("Charlie", 21));

        // Using the for-each loop to iterate over the ArrayList
        System.out.println("Student Information:");

        // Iterating over each Student object in the ArrayList
      //student is a variable that represents each Student object in the studentList
        for (Student student : studentList) {
            // Accessing the name and age attributes using getter methods
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge());
        }
    }
}
