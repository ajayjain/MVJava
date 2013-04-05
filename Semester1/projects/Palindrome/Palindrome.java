// Ajay Jain
// November 19, 2012
// Palindrome.java
// This program

import java.util.Scanner;

public class Palindrome {
	private static String input;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Palindrome Program!\n");
		while (true) {
			readInput();
			if (testForPalindrome())
				System.out.println("Yes, the string you entered is a palindrome!");
			else
				System.out.println("No, the string you entered is not a palindrome.");
		}
	}
	
	private static void readInput() {
		System.out.print("Enter a string: ");
		input = new Scanner(System.in).nextLine().trim();
		if (input.equalsIgnoreCase("q"))
			System.exit(0);
	}
	
	private static boolean testForPalindrome() {
		String s1 = clean(input);
		String s2 = new String();
		for (int i = s1.length()-1; i >= 0; i--)
			s2 += s1.charAt(i);
		
		return s1.equalsIgnoreCase(s2);
	}
	
	private static String clean(String s) {
		String f = new String();
		for (char c: s.toCharArray())
			if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122)
				f += c;
		return f;
	}
}
