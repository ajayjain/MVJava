// Ajay Jain
// December 10, 2012
// PascalRecursive.java
// This program

import java.util.Scanner;

public class PascalRecursive {
	private int h, c = 0;
	public PascalRecursive() {}
	
	public void ReadInput() {
		Scanner kb = new Scanner(System.in);
		
		while (h <= 0) {
			System.out.print("Enter height of triangle (0 to exit)\t-> ");
			h = kb.nextInt();
			if (h == 0) System.exit(0);
		}
	}
	
	public void NextRow(int[] r) {
		if (c == 0) PrintArray(r);
		c++;
		int len = r.length+1;
		int[] n = new int[len];
		n[0] = n[len-1] = 1;
		for (int i = 1; i < len-1; i++)
			n[i] = r[i-1] + r[i];	
		PrintArray(n);
		if (c == h) return; else NextRow(n);
	}
	
	// Prints out an int array
	private void PrintArray(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.printf("%-10d",a[i]);
			if ((i+1) % 20 == 0) n();
		}
		n();
	}
	
	// Prints a new line
	private static void n() {
		System.out.println();
	}
	
	public static void main(String[] args) {
		PascalRecursive p = new PascalRecursive();
		p.ReadInput();
		int[] zeroth = {1};
		p.NextRow(zeroth);
	}
}
