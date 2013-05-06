// Ajay Jain
// January 8, 2013
// AveMinMax.java
// 

import java.util.ArrayList;

import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class AveMinMax {
	private PrintWriter output; // PrintWriter object to print text
	private Scanner input;		// Scanner to read text
	private ArrayList<Byte> nums = new ArrayList<Byte>();
	private double ave;
	private byte min, max;
	
	public AveMinMax() {
		min = 100;
		max = 0;
	}
	
	// Reads input from ASCII.txt and translates ascii code
	public void input() {
		try {
			input = new Scanner(new File("numbers.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Cannot open file numbers.txt");
			System.exit(1);
		}
		while (input.hasNext())
			nums.add(input.nextByte());
	}
	
	public void calculate() {
		long sum = 0;
		for (byte n: nums) {
			if (n < min) min = n;
			if (n > max) max = n;
			sum += n;
		}
		ave = (double) sum/nums.size();
	}
	
	// Writes output to output.txt
	public void output() {
		String out = String.format("Average:\t%.3f\nMaximum:\t%d\nMinumum:\t%d", ave, max, min);
		System.out.println(out);
		
		try {
			output = new PrintWriter(new File("output.txt"), "UTF-8");
		} catch (IOException e) {
			System.err.println("ERROR: Cannot open file output.txt");
			System.exit(1);
		}
		output.println(out);
		output.close();
	}
	
	public static void main(String[] args) {
		(new FillWithIntegers()).PlaceNumbers();
		AveMinMax amm = new AveMinMax();
		amm.input();
		amm.calculate();
		amm.output();
	}
}
