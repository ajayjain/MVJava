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
		String[][] prev = read();
		PrintWriter out;
		try {
			out = new PrintWriter(missedFile);
			
			// Number of missed questions
			out.println(prev.length+1);
			// Write previous questions
			for (String[] q: prev)
				out.println(serializeArray(q));
			
			out.println(serializeArray(rowArray));
			out.close();
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file data/missed.txt for writing.");
			System.exit(1);
		}
	}
	
	public String serializeArray(String[] arr) {
		//String line = java.util.Arrays.toString(arr);	// looks like "["asdf", "asdf"]"
		//line = line.substring(1, line.length() - 1)	// Remove brackets
					//.replaceFirst(",", "::::");	// Remove first comma
		String line = arr[0]+"::::"+arr[1];
		line = line.replaceFirst(":::: ", "::::");
		System.out.println(line);
		return line;
	}
	
	// Read and return the questions from missed.csv
	public String[][] read() {
		try {
			Scanner in = new Scanner(missedFile);
			int numQuestions = Integer.decode(in.nextLine());
			String[][] questions = new String[numQuestions][2];
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
