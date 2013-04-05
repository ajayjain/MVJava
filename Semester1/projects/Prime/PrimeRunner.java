// Ajay Jain
// October 24, 2012
// Prime.java
// This program

import java.util.Scanner;
import java.util.ArrayList;

public class PrimeRunner {
	int low, high;
	ArrayList primes = new ArrayList();

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the low integer value  : ");
		low = kb.nextInt();
		
		System.out.print("Enter the high integer value : ");
		high = kb.nextInt();
		
		primes.add(2);
		for (int n = 3; n <= high; n++) {
			boolean prime = true;
			for (int i = 0; i < primes.size(); i++) {
				if (!(prime && n % prime == 0))
					prime = false;
			}
			if (prime)
				primes.add(n);
		}
		
		for (int i = low; i <= high; i++) {
			
		}
		
		System.out.println();
	}
	
	private int[] factors(int num) {
	
	}
	
	private boolean isPrime(int num) {
		
	}
}
