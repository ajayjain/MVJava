// Ajay Jain
// FileScanner.java
// November 15, 2012

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileScanner {
	private File file;
	private Scanner scan;
	
	public FileScanner(String path) {
		file = new File(path);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
	
	public Scanner getScanner() {
		return scan;
	}
}
