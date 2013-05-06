// Ajay Jain
// November 30, 2012
// GCF.java
// This class finds the GCF of 2 numbers.

import java.util.Scanner;

public class GCF {
	// Numbers entered by user
	int x, y;
	public GCF() {}
	
	// Read input from user (first & second number)
	public void ReadInput() {
		Scanner kb = new Scanner(System.in);
		
		while (x <= 0) {
			System.out.print("Enter first positive integer (0 to exit)\t-> ");
			x = kb.nextInt();
			if (x == 0) System.exit(0);
		}
		
		while (y <= 0) {
			System.out.print("Enter second positive integer (0 to exit)\t-> ");
			y = kb.nextInt();
			if (y == 0) System.exit(0);
		}
	}
	
	// Calculates and returns the goods (GCF)
	public int FindGCF(int x, int y) {
		if (x == y) 		return x;
		else if (x > y) 	x = x - y;
		else 				y = y - x;
		
		return FindGCF(x, y);
	}
	
	// Prints out the GCF
	public void PrintGCF() {
		int g = FindGCF(x,y);
		if (g == 1) System.out.printf("%d and %d are relatively prime\n",x,y);
		else 		System.out.printf("The GCF of %d and %d is %d\n",x,y,g);
	}
	
	public static void main(String[] args) {
		GCF g = new GCF();
		g.ReadInput();
		g.PrintGCF();
	}
}
