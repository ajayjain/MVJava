// Ajay Jain
// December 4 through 14, 2012
// Swap.java
// This program orders a list of random numbers.

import java.util.Scanner;

public class Swap {
	private static byte[] a,		// Array of random numbers
						  ind;		// Array of indicies + 1 (numbers from 1 to 8)
	private static byte count = 0;	// Counter of swaps
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		a 	= new byte[8];
		ind = new byte[8];
		for (byte i = 0; i < 8; ++i) {
			a[i] = (byte) Math.ceil(Math.random()*100);
			ind[i] = (byte) (i+1);
		}
		System.out.println("Welcome to the Game of SWAP! Here is your array of 8 integers:");
		Print();
		while (!isSorted()) {
			byte x, y;
			x = y = 0;
			while (x > 8 || x < 1) {
				System.out.print("Enter an index value to swap:\t\t");
				x = kb.nextByte();
			}
			while (y > 8 || y < 1) {
				System.out.print("Enter another index value to swap:\t");
				y = kb.nextByte();
			}
			SwapValues(x,y);
			++count;
			Print();
		}
		System.out.printf("Good work! Your array is in order, and it took %d swaps.\n", count);
	}
	
	// Prints out the array and it's indicies (+1)
	private static void Print() {
		n();
		PrintArray(ind);
		PrintArray(a);
		n();
	}
	
	// Prints out a byte array
	private static void PrintArray(byte[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.printf("%-4d",a[i]);
			if ((i+1) % 20 == 0) n();
		}
		n();
	}
	
	// Swaps values in the class variable *a* given 2 indicies
	private static void SwapValues(byte i, byte j) {
		--i; --j;
		byte x = a[i];
		byte y = a[i] = a[j];
		a[j] = x;
	}
	
	// Checks if array is sorted
	private static boolean isSorted() {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i-1]) return false;
		return true;
	}
	
	// Prints a new line
	private static void n() {
		System.out.println();
	}
}
