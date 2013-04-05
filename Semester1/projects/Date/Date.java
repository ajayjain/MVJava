// Ajay Jain
// September 17, 2012
// Date.java
// This program calculates the cost of your date.

import java.util.Scanner;

public class Date {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the cost of a single entree       -> ");
		double ent = kb.nextDouble();
		System.out.print("Enter the cost of a single beverage     -> ");
		double bev = kb.nextDouble();
		System.out.print("Enter the cost of a single movie ticket -> ");
		double mov = kb.nextDouble();
		
		double esub = ent*2;
		System.out.printf("Entree subtotal =         $%6.2f\n", esub);
		double bsub = bev*2;
		System.out.printf("Beverage subtotal =       $%6.2f\n", bsub);
		double tax = (esub+bsub)*.0875;
		System.out.printf("Entree and Beverage Tax = $%6.2f\n", tax);
		double tip = (esub+bsub+tax)*.15;
		System.out.printf("Tip = \t\t\t  $%6.2f\n", tip);
		double mealTotal = esub+bsub+tax+tip;
		System.out.printf("Meal Total = \t\t  $%6.2f\n", mealTotal);
		double movie = mov*2;
		System.out.printf("Movie = \t\t  $%6.2f\n", movie);
		double movieTax = movie*.0875;
		System.out.printf("Movie Tax = \t\t  $%6.2f\n", movieTax);
		double movieTotal = movie+movieTax;
		System.out.printf("Movie Total = \t\t  $%6.2f\n", movieTotal);
		
		System.out.printf("You spent $%.2f on your date!\n", mealTotal+movieTotal);
		
	}
}
