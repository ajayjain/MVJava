// Ajay Jain
// September 4, 2012
// HelloWorld.java
// This program will print a greeting based on user input to the output stream (screen).

import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("What is your name?");
		System.out.println("Yo, "+new Scanner(System.in).nextLine());
	} // end main
} // end class HelloWorld
