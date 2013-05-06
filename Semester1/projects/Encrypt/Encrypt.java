// Ajay Jain
// November 9, 2012
// Encrypt.java
// This program encrypts a string with a Ceasar cypher.

// Class variables:
	// phrase  -		phrase entered by the user being modified.
	
// Class methods:
	// input   -		read input from user
	// output  -		print output of current encryption step
	// encrypt -		encrypt phrase one time

import java.util.Scanner;

public class Encrypt {
	private static String phrase;
	
	public static void main(String[] args) {
		input();
		for (int i = 1; i <= 13; i++) {
			encrypt();
			output(i);
		}
	}
	
	private static void input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Encrypt.java. Please enter a word, phrase, or sentence.");
		System.out.print("\n->	");
		phrase = kb.nextLine();
	}
	
	private static void output(int i) {
		System.out.printf("Encryption %d:\n", i);
		System.out.println(phrase+"\n");
	}
	
	private static void encrypt() {
		char[] arr = phrase.toCharArray();
		//char[] newArr = new char[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			int p = c-64;

			// Capital letter
			if (p >= 1 && p <= 26) {
				p = (p + 2) % 26;
				if (p == 0)
					p = 26;
			} else if (p >= 33 && p <= 58) {
				p -= 32;
				p = (p + 2) % 26;
				if (p == 0)
					p = 26;
				p += 32;
			}
			
			c = (char) (p + 64);
			arr[i] = c;
		}
		
		//arr = newArr;
		phrase = new String(arr);
	}
}
