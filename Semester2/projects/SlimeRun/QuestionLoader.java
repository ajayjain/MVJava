// Ajay Jain
// May 7, 2013
// QuestionLoader.java
// Class to load questions from text files.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuestionLoader extends Thread {
	public String[][] physics;
	
	public void run() {
		physics = new String[199][0];
		load("data/physics.txt", physics);
	}
	
	private void load(String fileName, String[][] questions) {
		try {
			Scanner s = new Scanner(new File(fileName));
			for (int q = 0; q < questions.length; q++)
				if (s.hasNext())
					questions[q] = s.nextLine().split("::::");
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: File not found - "+fileName);
		}
	}
}
