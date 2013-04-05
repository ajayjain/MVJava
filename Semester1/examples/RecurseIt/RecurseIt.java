// Ajay Jain
// November 30, 2012
// RecurseIt.java
// This program provides examples of recursion.

public class RecurseIt {
	public static void main(String[] args) {
		CountDown(4);
		System.out.println();
		CountUp(4);
		System.out.println();
		System.out.println("Sum(4000) = "+Sum(4000));
	}
	
	public static void CountDown(int i) {
		System.out.print(i + " ");
		if (i > 1)
			CountDown(--i);
	}
	
	public static void CountUp(int i) {
		if (i > 1) CountUp(i - 1);
		System.out.print(i + " ");
	}
	
	public static int Sum(int i) {
		if (i > 1)
			return i + Sum(--i);
		else
			return 1;
	}
}
