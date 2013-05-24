// Ajay Jain
// May 7, 2013
// QuestionLoader.java
// Class to load questions from text files.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuestionLoader extends Thread {
	public String[][] em, machines, anatomy, vocab, spanish;
	
	public void run() {
		// Initialize arrays
		//physics = new String[199][0];
		em = new String[54][0];
		machines = new String[25][0];
		anatomy = new String[61][0];
		vocab = new String[156][0];
		spanish = new String[1241][0];
		
		//load("data/physics.txt", physics);
		load("data/em.txt", em);
		load("data/simplemachines.txt", machines);
		load("data/anatomy.txt", anatomy);
		load("data/sat.txt", vocab);
		load("data/spanish.txt", spanish);
	}
	
	private void load(String fileName, String[][] questions) {
		Scanner s = new Scanner(getClass().getResourceAsStream(fileName), "UTF8");
		for (int q = 0; q < questions.length; q++)
			if (s.hasNext())
				questions[q] = s.nextLine().split("::::");
		System.out.println("Loaded "+fileName);
	}
}
