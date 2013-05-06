// Ajay Jain
// January 11, 2013
// TwoDArray.java
// This program will demonstrate the declaration, memory allocation and initialization of 2D arrays.

import java.util.Arrays;

public class TwoDArray {
	int [] [] table;	// declare 2d array
	int [] [] table2 = { { 0, 1, 2, 3, 4},
						 { 5, 6, 7, 8, 9,10,11},
						 {12,13,14,15,16} };
	
	public void Run() {
		Runtime inst = Runtime.getRuntime();
		System.out.println(inst.freeMemory()/1024/1024+"/"+inst.maxMemory()/1024/1024);
		
		table = new int [5][4];
		//table[0] = new int[10]; // does work
		
		for (int row = 0; row < 5; row++)
			for (int col = 0; col < 4; col++)
				table[row][col] = row + col;
				
		PrintTable( table );
		PrintTable( table2);
	}
	
	public void PrintTable(int [] [] t) {
		System.out.println("\nUsing nested fors to print: ");
		for (int row = 0; row < t.length; row++) {
			for (int col = 0; col < t[row].length; col++)
				System.out.printf("%4d",t[row][col]);
			System.out.println();
		}
		System.out.println("\nUsing Arrays deepToString to print:\n"+Arrays.deepToString(t)+"\n");
	}
	
	public static void main(String[] args) {
		TwoDArray thisprog = new TwoDArray();
		thisprog.Run();
	}
}
