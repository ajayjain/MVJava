// Ajay Jain
// December 4, 2012
// BigArrayExample.java
// This program provides insights into arrays.

// import java.util.Scanner;

public class BigArrayExample {
	public static void main(String[] args) {
		BigArrayExample ae = new BigArrayExample();
		ae.Run();
	}
	
	public void Run() {
		// 1) Declaring arrrays and Memory allocation
		char[] alphabet;			// declare array
		alphabet = new char[26];	// allocate 26 storage locations
		int numInt = 100;
		int[] integers = new int[numInt];	// declares and allocates memory
		
		// 2) initializing arrays
		for (int i = 0; i < 26; i++)
			alphabet[i] = (char)('A'+i);
		for (int i = 0; i < numInt; i++)
			integers[i] = i + 1;
		
		// 3) length of array
		for (int i = 0; i < alphabet.length; i++)
			System.out.print(alphabet[i]);
		n();
		for (int i = 0; i < numInt; i++)
			System.out.print(integers[i]);
		n();
		
		// 4) Passing array as parameter
		PrintArray(integers);
		ChangeIndex(19, -1, integers);
		ChangeIndex(39, -1, integers);
		ChangeIndex(59, -1, integers);
		PrintArray(integers);
		
		//	A) Use String method "toCharArray()" and convert a string into an array of characters
		char[] doop = "Hello there".toCharArray();
		//	B) Print out the array of characters from A) backwards
		for (int i = doop.length-1; i >= 0; i--)
			System.out.print(doop[i]);

	}
	
	public void PrintArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%4d",a[i]);
			if ((i+1) % 20 == 0) n();
		}
		n();
	}
	
	public void PrintArray(char[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%c",a[i]);
			if ((i+1) % 20 == 0) n();
		}
		n();
	}
	
	public void ChangeIndex(int index, int value, int[] arr) {
		arr[index] = value;
	}
	
	private void n() {
		System.out.println();
	}
}
