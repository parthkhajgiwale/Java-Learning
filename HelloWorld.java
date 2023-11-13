public class HelloWorld{
	// The main method is the entry point of a Java program.
// When you run your Java application, the Java Virtual Machine (JVM) looks for this method
// to start the execution of your program.

// The main method has a specific signature that must be followed for the JVM to recognize it:
// - It's declared as 'public', which means it can be accessed from outside the class.
// - It's declared as 'static', indicating that the method belongs to the class rather than an instance.
// - It has a 'void' return type, meaning it doesn't return any value.

// The name of the method is 'main'. This is a standardized name; the JVM looks for a method with
// exactly this name when starting the program.

// The 'String[] args' parameter allows you to receive command-line arguments.
// For example, if you run your program with 'java YourClassName arg1 arg2', the 'args' array will
// contain ['arg1', 'arg2'].

// Putting it all together, this method is where the execution of your program begins.
	public static void main(String[] args){
		System.out.println("Hello World!");
	}
}
