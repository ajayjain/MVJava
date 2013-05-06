// Ajay Jain
// October 22, 2012
// Add.java
// This class calculates and prints an addition table.

// Class methods:
		// GetRows
			// Prompt the user to enter the number of rows in their addition table.
			// This value should be chosen from 2 to 30, and if the user enters a value
			// outside of this range, they should be prompted again.
		// GetColumns
			// Prompt the user to enter the number of columns in their addition table.
			// This value should be chosen from 2 to 12, and if the user enters a value
			// outside of this range, they should be prompted again.
		// PrintAddTable
			// Print out the addition table with the user-defined number of rows and
			// columns. Your table should have row and column headings.

// Class variables:
		// row		- The number of rows for the addition table.
		// column	- The number of columns for the addition table.

import java.util.Scanner;

public class Add {
	private int row;    // The number of rows for the addition table.
	private int column; // The number of columns for the addition table.
	private Scanner kb = new Scanner(System.in);

	public Add() {
		row = column = 0;
	}
	
	public void GetRows ( ) {
		System.out.print("Enter the number of rows to be shown ( 2 - 30 )    ->\t");
		row = kb.nextInt();
		if (!(row >= 2 && row <= 30)) {
			GetRows();
			return;
		}
	}
	
	public void GetColumns ( ) {
		System.out.print("Enter the number of columns to be shown ( 2 - 12 ) ->\t");
		column = kb.nextInt();
		if (!(column >= 2 && column <= 12)) {
			GetColumns();
			return;
		}
	}
	
	public void PrintAddTable ( ) {
		System.out.println("\nHere is your table:\n");
		
		System.out.print("\t|\t");
		int curCol = 1;
		while (curCol <= column) {
			System.out.printf("%-8d", curCol);
			curCol++;
		}
		
		System.out.println();
		
		int currDash = 1;
		do {
			System.out.print('-');
			currDash++;
		} while (currDash <= (column + 2) * 8 - 6);
		
		System.out.println();
		
		for(int r = 1; r <= row; r++) {
			System.out.printf("%-8d|\t",r);
			for(int c = 1; c <= column; c++) {
				System.out.printf("%-8d", c+r);
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void main ( String [] args ) {
       Add table = new Add ( );
       table.GetRows( );
       table.GetColumns( );
       table.PrintAddTable( );
	}


}
