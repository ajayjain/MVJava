// Ajay Jain
// January 7, 2013
// ASCIIToText.java
// This class converts an input ASCII code input file into English and prints it to a file.

import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ASCIIToText {
	private PrintWriter output; // PrintWriter object to print text
	private Scanner input;		// Scanner to read text
	private String out = "";	// Translated string
	
	// Reads input from ASCII.txt and translates ascii code
	public void input() {
		try {
			input = new Scanner(new File("ASCII.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot open file ASCII.txt");
			System.exit(1);
		}
		while (input.hasNext())
			out += (char) input.nextByte();
	}
	
	// Writes output to output.txt
	public void output() {
		try {
			output = new PrintWriter(new File("output.txt"), "UTF-8");
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(1);
		}
		output.print(out);
		output.close();
	}
	
	public static void main(String[] args) {
		ASCIIToText at = new ASCIIToText();
		at.input();
		at.output();
	}
}
