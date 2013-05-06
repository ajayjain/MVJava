// Ajay Jain
// October 26, 2012
// College.java
// This program invites the user to come up with a class schedule.

import java.util.Scanner;

public class College {
	public static void main(String[] args) {
		System.out.println("\nWelcome to SCHEDULE CHOOSER\n");
		
		byte eng = getClass('e', "English");
		byte math = getClass('m', "Math");
		byte science = getClass('s', "Science");
				
		System.out.println("\n\nTHANK YOU, HERE IS YOUR CLASS SCHEDULE:\n");
		System.out.println(classes('e', eng));
		System.out.println(classes('m', math));
		System.out.println(classes('s', science));
		System.out.println();
	}
	
	private static String classes(char type, byte c) {
		String print = "";
		switch (type) {
			case 'e': // English
				switch (c) {
					case 1: print = "Grammer for Gorillas"; break;
					case 2: print = "Literary Adventures"; break;
					case 3: print = "Lingustic Leamurs"; break;
					case 4: print = "Studies of Shakespeare"; break;
					default: print = "Error";
				}
				break;
			case 'm': // Math
				switch (c) {
					case 1: print = "Calm Down, it's Just Calculus"; break;
					case 2: print = "Algebraic Acrobatics"; break;
					case 3: print = "Don't be a Square - Geometry"; break;
					case 4: print = "Fortune Telling with Statistics"; break;
					default: print = "Error";
				}
				break;
			case 's': // Science
				switch (c) {
					case 1: print = "Camping with Chemistry"; break;
					case 2: print = "Physics with Pie"; break;
					case 3: print = "Biology with a Helping of Bacon"; break;
					case 4: print = "Counting the Stars"; break;
					default: print = "Error";
				}
				break;
		}
		
		return print;
	}
	
	private static byte getClass(char c, String full) {
		Scanner kb = new Scanner(System.in);
		
		System.out.printf("Here are four possible %s classes:\n", full);
		for (byte i = 1; i <= 4; i++) {
			System.out.printf("\t(%d) %s\n",i,classes(c, i));
		}
		System.out.print("Choose One Class (1-4) -> ");
		char chosen = kb.next().charAt(0);
		return (byte) (chosen - 48);
		
	}
	
}
