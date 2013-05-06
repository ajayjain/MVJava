// Ajay Jain
// January 10, 2013
// Bingo.java
// This program generates and prints a random 5 by 5 bingo board with no duplicate numbers.

import java.util.ArrayList;
import java.util.Random;

public class Bingo {
	private static int n = 5;	// Number of columns and rows
	private static int[][] board = new int[n][n];	// The bingo board
	private static ArrayList<ArrayList<Integer>> avail = new ArrayList<ArrayList<Integer>>(5);	// Array of arrays containing available bingo numbers
	
	// Run the program
	public static void main(String[] args) {
		// Fill board
		for (int col = 0; col < n; col++) {
			ArrayList<Integer> rowarr = new ArrayList<Integer>();
			avail.add(rowarr);
			for (int el = 1+col*15; el <= 15+col*15; el++) rowarr.add(el);
			for (int row = 0; row < n; row++) {
				int index = (new Random()).nextInt(14-row);
				board[row][col] = rowarr.get(index);
				rowarr.remove(index);
			}
		}
		
		PrintTable();
	}
	
	// Print table header and body
	private static void PrintTable() {
		System.out.println("-----------------------------\n"+
						   "|   B    I    N    G    O   |\n"+
						   "-----------------------------");
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++)
				// Print FREE space and fix alignment of other columns
				if (row == n/2 && col == n/2)
					System.out.print("  FREE");
				else if (row == n/2 && col == n/2+1)
					System.out.printf("%4d", board[row][col]);
				else
					System.out.printf("%5d", board[row][col]);
			System.out.println();
		}
	}
}
