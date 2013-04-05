// Ajay Jain
// November 5, 2012
// Transform.java
// This program modifies an input string one character at a time.

import java.util.Scanner;

public class Transform {
	private static String phrase;
	private static int index;
	private static boolean done = false;
	private static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("\nEnter a phrase -> ");
		phrase = kb.nextLine();
		
		while (!done) {
			ReadIndex();
			ReadNewChar();
			
			System.out.println("\nHere is the new phrase:\n\t"+phrase);
			
			PromptContinue();
		}
		
		System.out.println("Goodbye!");
	}
	
	private static void PromptContinue() {
		System.out.print("\nWould you like to replace another character? ( 'Y' for yes, 'N' for no ) ");
		char c = kb.nextLine().toUpperCase().charAt(0);
		if (c == 'N')
			done = true;
		else if (c != 'Y')
			PromptContinue();
	}
	
	private static void ReadIndex() {
		System.out.print("\nEnter an index value to change -> ");
		index = kb.nextInt();
		
		if (index < 0 || index > phrase.length()) {
			ReadIndex();
		}
	}
	
	private static void ReadNewChar() {
		kb.nextLine();
		System.out.print("\nEnter the new letter or character, to replace the '"+phrase.charAt(index)+"' -> ");
		char newChar = kb.nextLine().charAt(0);
		
		phrase = phrase.substring(0, index) + newChar + phrase.substring(index + 1);
		
		/*if (newChar < 32 || index > 126) { ReadNewChar(); }*/
	}
}
