// Ajay Jain
// October 16, 2012
// Rolls.java
// 

// Class Methods:
// GetInfo     - reads input from the user
// RollTheDice - roll the dice based off the inputs
// ShowResults - print the results of the rolls

// Class Variables:
// count       - how many times the dice has been rolled
// target      - the target value.
// targetcount - how many times the target has been hit.
// numsides    - number of sides for the dice.
// dicevalue   - the number rolled (dice value).
// numrolls    - the number of times the dice will be rolled (where to stop).
// max, min    - the maximum and minimum value rolled.

import java.util.Scanner;

public class Rolls {
	private int count, target; // These values represent how many times the
							   // dice has been rolled and the target value.
	private int targetcount;   // How many times the target has been hit.
	private int numsides;      // The number of sides for the dice.
	private int dicevalue;     // The number rolled (dice value).
	private int numrolls;      // Represents the number of times the dice
							   // will be rolled (where to stop).
	private int max, min;      // The maximum and minimum value rolled.

	public Rolls() {
		targetcount = max = 0;
		min = 101;
	}
	
	// Prompt the user to enter the desired information.
	public void GetInfo ( ) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the number of sides for your dice (2-100) \t\t   -> ");
		numsides = kb.nextInt();
		System.out.print("Enter the number of times you would like to roll the dice(1-10000) -> ");
		numrolls = kb.nextInt();
		System.out.print("Enter the target value(1-number of sides) \t\t\t   -> ");
		target = kb.nextInt();
	}
	
	// Roll the dice the desired number of times, looking for the target,
	// keeping track of how many times the target is hit, and keeping track
	// of the max and min values rolled.
	public void RollTheDice ( ) {
		Dice d = new Dice(numsides);
		while (count < numrolls) {
			dicevalue = d.Roll();
			if (dicevalue == target)
				targetcount++;
				
			if (dicevalue < min) min = dicevalue;
			if (dicevalue > max) max = dicevalue; 
				
			if (count % 10 == 0)
				System.out.println("");
			
			System.out.print(dicevalue+"\t");
			count++;
		}
		System.out.println();
	}
	
	// Print a table showing the results.
	public void ShowResults ( ) {
		System.out.printf("\nThe target of %d was rolled %d times.\n", target, targetcount);
		System.out.printf("Minimum value     ->   %d\n", min);
		System.out.printf("Maximum value     ->   %d\n", max);

	}

	public static void main ( String [] args ) {
	   Rolls loop = new Rolls ( );
	   loop.GetInfo ( );
	   loop.RollTheDice ( );
	   loop.ShowResults ( );
	}

}
