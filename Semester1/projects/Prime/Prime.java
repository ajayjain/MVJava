// Ajay Jain
// October 24, 2012
// Prime.java
// This program

import java.util.Scanner;
import java.util.ArrayList;

public class Prime {
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public Prime() {
		
	}
	
	public Prime(int high) {
		GeneratePrimes(high);
	}
	
	public void GeneratePrimes(int high) {
		primes.clear();
		primes.add(2);
		for (int n = 3; n <= high; n++) {
			if (isPrime(n))
				primes.add(n);
		}
	}
	
	public int[] GetPrimes() {
		int[] arr = new int[primes.size()];
		for (int i = 0; i < primes.size(); i++) {
			arr[i] = primes.get(i);
		}
		
		return arr;
	}
	
	public boolean isPrime(int num) {
		boolean prime = true;
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0)
				prime = false;
		}
		return prime;
	}
	
	public static void main(String[] args) {
		Prime p = new Prime(50);
		int[] pa = p.GetPrimes();
		for (int i = 0; i < pa.length; i++) {
			System.out.println(pa[i]);
		}
	}
	
}
