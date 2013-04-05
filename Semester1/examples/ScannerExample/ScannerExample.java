// Ajay Jain
// September 17, 2012
// ScannerExample.java
// This program gives a sample of using the Scanner class

import java.util.Scanner;
// import java.util.InputMismatchException;

public class ScannerExample {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Input an integer -> ");
		int i = kb.nextInt();
		System.out.println("Your integer is " + i);
		// throw new InputMismatchException("hi");
		
		kb.nextLine();
		String str = kb.nextLine();
		System.out.println(str);
	}
}
