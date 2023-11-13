import java.util.Scanner;
public class ArrayInJava{
	public static void main(String[] args){
		System.out.println("Enter Array Size:");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
      // Create an array of the specified size
      // Explanation: 'int[]' declares an array of integers. 
      // 'new int[size]' creates a new array of integers with a specified size.
		int[] myArray = new int[size];
		for(int i=0; i<size; i++){
			System.out.println("Enter Element "+ (i+1) +" in Array");
			myArray[i]=sc.nextInt();
		}
		for(int i=0; i<size;i++){
			System.out.println("Element "+ (i+1) +" in Array: " + myArray[i]);
		}
		sc.close();
	}
}
