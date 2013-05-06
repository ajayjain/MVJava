// Ajay Jain
// December 11, 2012
// _.java
// Java library modeled after Underscore.js, mainly for array operations.

import java.util.Arrays;

public class _ {
	public static void PrintArray(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.printf("%-4d",a[i]);
			if ((i+1) % 20 == 0) n();
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,3};
		_.PrintArray(a);
	}
}
