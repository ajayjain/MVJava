// Ajay Jain
// October 29, 2012
// Kaching.java
// This class plays the game Kaching with two players.

// Class methods:
	// PlayGame		- This method is called in main, and calls the other methods to play the game.
	// ShowStatus	- Shows the status of the game, or the positions of the two players.
	// MoveIt		- Plays one turn, alternating between player A and player B.
	// AddRoll		- Add a roll to the proper player.
	// GetPosition	- Get the position of the current player.
	// SwitchTurn	- Simple method that switches to the next player's turn.

// Class variables:
	// Atotal, Btotal	- Stores the position for players A and B, respectively.
	// Aturn, done		- Booleans to determine if it is player A's turn, and if the game is done, respectively.
	// die				- A six-sided die (you can just use a random number generator, if you prefer).

import java.util.Scanner;

public class Kaching {
	private int Atotal, Btotal;
	private boolean Aturn, done;
	private Dice die;

	public Kaching() {
		Atotal = Btotal = 1;
		Aturn = true;
		done = false;
		die = new Dice();
	}
	
	
	public void PlayGame ( ) {
		ShowStatus();
		while (Atotal < 50 && Btotal < 50) {
			MoveIt();
			if (Atotal >= 50)
				System.out.println("A, you are the CHAMPION!!!\n");
			else if (Btotal >= 50)
				System.out.println("B, you are the CHAMPION!!!\n");
			ShowStatus();
		}
		done = true;
	}
	
	
	public void ShowStatus ( ) {
		System.out.println("A TOTAL IS:  "+Atotal);
		System.out.println("B TOTAL IS:  "+Btotal);
	}

	public void MoveIt ( ) {
		if (Aturn)
			System.out.println("PLAYER A, hit Enter to continue:");
		else
			System.out.println("PLAYER B, hit Enter to continue:");
		
		(new Scanner(System.in)).nextLine();
		
		int roll = die.Roll();
		//int roll = (int) Math.ceil(Math.random()*6);

		System.out.println(roll);
		
		// If a player rolls a 1, they lose their turn without moving.
		if (roll == 1)
			SwitchTurn();
		else {
			AddRoll(roll);
			// If the player rolls a value, moves, and the new position is divisible by the dice value, then the
			// player loses their turn, and must move back 2 * dice value (not less than position 1).
			if (GetPosition() % roll == 0) {
				AddRoll(-2 * roll);
				SwitchTurn();
			} else {
				// If a player lands on a prime number, they roll again. (do nothing)
				int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
				boolean landedOnPrime = false;
				for (int i = 0; i < primes.length; i++) {
					if (GetPosition() == primes[i]) {
						landedOnPrime = true;
					}
				}
				
				// If the player rolls a value, moves, and the new position is not divisible by the dice value (but
				// is not prime), they lose their turn, but remain in the new position.
				if (!landedOnPrime) {
					SwitchTurn();
				}
			}
		}
	}
	
	private void AddRoll(int roll) {
		if (Aturn) {
			Atotal += roll;
			if (Atotal < 1)
				Atotal = 1;
		} else {
			Btotal += roll;
			if (Btotal < 1)
				Btotal = 1;
		}
	}
	
	private int GetPosition() {
		if (Aturn)
			return Atotal;
		else
			return Btotal;
	}
	
	private void SwitchTurn() {
		Aturn = !Aturn;
	}
	
	public static void main ( String [] args ) {
		Kaching fun = new Kaching ( );
		fun.PlayGame ( );
	}
}
