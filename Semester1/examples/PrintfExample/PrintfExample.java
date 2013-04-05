// Ajay Jain
// September 18, 2012
// PrintfExample.java
// This program shows different ways to format using printf.

public class PrintfExample {
	public static void main(String[] args) {
		double d1 = 1234.56789;
		int i = 987654321;
		int j = 21;
		char ch = 'A';
		String str = "This class is awesome!";
		
		System.out.printf("My integer is %d\n", i);
		System.out.printf("My integer is %12d\n", i);
		System.out.printf("My integer is %-,20d\n", i);
		
		System.out.printf("My float is %f\n", d1);
		System.out.printf("My float is %9.2f\n", d1);
		System.out.printf("My float is %,9.2f\n", d1);
		
		System.out.printf("My character is %c\n", ch);
		
		System.out.printf("My string is %30s\n", str);
		
		System.out.printf("My integers are %d and %d\n", i, j);
	}
}
