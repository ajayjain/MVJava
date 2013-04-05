// Ajay Jain
// December 11, 2012
// InitArray.java
// This program initializes an array using a list of primitives

import java.util.Arrays;

public class InitArray {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) arr[i] = i + 1;
		
		String[] strArr = {"Alex", "Betty", "Charles", "Devon", "Zoe"};
		System.out.println(strArr[0]);
	}
}
