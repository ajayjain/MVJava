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
	
	public QuestionWriter() {
		missedFile = new File("data/missed.txt");
	}
	
	// Write a question to disk
	public void write(String[] rowArray) {
		PrintWriter out;
		try {
			out = new PrintWriter(missedFile);
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file data/missed.txt for writing.");
			System.exit(1);
		}
	}
	
	// Read and return the questions from missed.csv
	public String[][] read() {
		try {
			Scanner in = new Scanner(missedFile);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot open file data/missed.txt");
			System.exit(1);
		}
		int numQuestions = in.nextInt();
		String[][] questions = new String[numQuestions][3];
		for (int q = 0; q < numQuestions; q++) {
			
		}
	}
}
