// Ajay Jain
// FileTest.java
// November 15, 2012

import java.util.Scanner;

public class FileTest {
	public static void main (String args[]) {		
		FileScanner f = new FileScanner("hellasdfo.txt");
		Scanner s = f.getScanner();
		System.out.println(s.nextLine());
	}
}
