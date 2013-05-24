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
	String origFileName = "data/missed.txt",
		modFileName = ".slimerun_missed";
	private File origMissedFile, modMissedFile;
	
	public MissedIO() {
		origMissedFile = new File(origFileName);
		modMissedFile = new File(modFileName);
	}
	
	// Write a question to disk
	public void write(String[] rowArray) {
		String[][] prev = read();
		try {
			PrintWriter out = new PrintWriter(modMissedFile, "UTF8");
			
			// Number of missed questions
			out.println(prev.length+1);
			// Write previous questions
			for (String[] q: prev)
				out.println(serializeArray(q));
			
			out.println(serializeArray(rowArray));
			out.close();
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file "+modFileName+" for writing.");
			System.exit(1);
		}
	}
	
	// Turn String array into CSV deliminated by "::::"
	public String serializeArray(String[] arr) {
		//String line = java.util.Arrays.toString(arr);	// looks like "["asdf", "asdf"]"
		//line = line.substring(1, line.length() - 1)	// Remove brackets
					//.replaceFirst(",", "::::");	// Remove first comma

		String line = arr[0]+"::::"+arr[1];
		line = line.replaceFirst(":::: ", "::::");
		System.out.println(line);
		return line;
	}
	
	// Read and return the questions from the missed file
	public String[][] read() {
		Scanner in = new Scanner(getClass().getResourceAsStream(origFileName), "UTF8");
		if (modMissedFile.exists())
			try {
				in = new Scanner(modMissedFile);
			} catch (FileNotFoundException e) {
				System.err.println("ERROR: FileNotFound - "+modFileName);
			}

		int numQuestions = Integer.decode(in.nextLine());
		String[][] questions = new String[numQuestions][2];
		for (int q = 0; q < numQuestions; q++)
			questions[q] = in.nextLine().split("::::");
		return questions;
	}
}
