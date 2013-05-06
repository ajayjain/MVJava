// Ajay Jain
// January 7, 2013
// HelloWorldWriteRead.java
// This program writes "Hello World!" to a text file then reads it.

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloWorldWriteRead {
	private File iofile;		// File object for object.txt
	private PrintWriter output; // PrintWriter object to print text
	private Scanner input;		// Scanner to read text
	
	// Opens output.txt and prints "Hello world!" to it;
	public void WriteIt() {
		iofile = new File("output.txt");
		try {
			output = new PrintWriter(iofile, "UTF-8");
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(1);
		}
		output.println("Hello world!");
		output.close();
	}
	
	public void ReadIt() {
		try {
			input = new Scanner(iofile);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(1);
		}
		while (input.hasNext())
			System.out.println(input.nextLine());
		input.close();
	}
	
	public static void main(String[] args) {
		HelloWorldWriteRead hww = new HelloWorldWriteRead();
		hww.WriteIt();
		hww.ReadIt();
	}
}
