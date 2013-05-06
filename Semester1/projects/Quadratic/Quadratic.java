// Ajay Jain
// September 25, 2012
// Quadratic.java
// This program will solve the quadratic equation.

import java.util.Scanner;
import java.util.regex.Pattern;

public class Quadratic {

	public static void main (String args[]) {		
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter a --> ");
		double a = s.nextDouble();
		
		System.out.print("Please enter b --> ");
		double b = s.nextDouble();
		
		System.out.print("Please enter c --> ");
		double c = s.nextDouble();
		
		String eq = String.format("%.4fx^2 + %.4fbx + %.4fc = 0",a,b,c);
		eq.replaceAll(Pattern.quote("+ -"), "- ");
		System.out.println(eq);
		
		// Test for no solution (imaginary roots, prime)
		if (Math.pow(b,2)-4*a*c < 0) {
			System.out.printf("Math.pow(b,2)-4*a*c = %f. NO SOLUTION (or dare to enter imaginary land).\n",(Math.pow(b,2)-4*a*c));
			return;
		}
		
		double x1 = (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
		double x2 = (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
		
		// Test for 1 vs 2 roots
		if (x1 != x2) {
			System.out.printf("x = (%.4f,%.4f)\n",x1,x2);
		} else {
			System.out.printf("x = %.4f\n",x1);
		}
		
	}
}
