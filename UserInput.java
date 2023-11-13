// Import the Scanner class from the java.util package
import java.util.Scanner;

// Define a class named UserInputExample
public class UserInput{
	
	public static void main(String[] args){
		System.out.println("Enter Name:");
    //Object Creation: ClassName objectname = new ClassName();
    //Create Object of Scanner Class
		Scanner sc = new Scanner(System.in);
     // Read the user's input as a line of text
		String userinput = sc.nextLine();
		System.out.println("You Entered :" + userinput);
    //Closing scanner to free up resources
		sc.close();
	}
}
