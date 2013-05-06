// Ajay Jain
// January 8, 2013
// TextToASCII.java
// This program

import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TextToASCII {
	private PrintWriter output; // PrintWriter object to print text
	private Scanner input;		// Scanner to read text
	private String out = "";	// Translated string
	
	// Reads input from ASCII.txt and translates ascii code
	public void input() {
		try {
			input = new Scanner(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(1);
		}
		while (input.hasNext())
			for (char c: input.next().toCharArray())
				out += (int) c+" ";
	}
	
	// Writes output to output.txt
	public void output() {
		try {
			output = new PrintWriter(new File("outputASCII.txt"), "UTF-8");
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file outputASCII.txt");
			System.exit(1);
		}
		output.println(out);
		output.close();
	}
	
	public static void main(String[] args) {
		TextToASCII at = new TextToASCII();
		at.input();
		at.output();
	}
}
