// Ajay Jain
// May 13, 2013
// MissedIO.java
// Class to write and read missed questions to and from data/missed.txt

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

public class MissedIO {
	private File missedFile;
	
	public MissedIO() {
		missedFile = new File("data/missed.txt");
	}
	
	// Write a question to disk
	public void write(String[] rowArray) {
		PrintWriter out;
		try {
			out = new PrintWriter(missedFile);
			String nextLine = rowArray.toString();	// looks like "["asdf", "asdf", "asdf"]"
			nextLine = nextLine.substring(1, nextLine.length() - 1)	// Remove brackeks
							   .replaceAll(",", "::::");	// Remove commas
			out.println(nextLine);
			out.close();
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file data/missed.txt for writing.");
			System.exit(1);
		}
	}
	
	// Read and return the questions from missed.csv
	public String[][] read() {
		try {
			Scanner in = new Scanner(missedFile);
			int numQuestions = in.nextInt();
			String[][] questions = new String[numQuestions][3];
			for (int q = 0; q < numQuestions; q++)
				questions[q] = in.nextLine().split("::::");
			return questions;
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot open file data/missed.txt");
			System.exit(1);
		}
		return new String[0][0];
	}
}
