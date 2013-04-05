// Ajay Jain
// September 6, 2012
// PrimitiveTypes.java
// This program initializes a series of variables, use them in expressions, and print the results.

public class PrimitiveTypes {
	public static void main(String[] args) {
		// Variable declarations
		byte b = 21;
		short sh = 3;
		int i = -34;
		long el = 287;
		float f = (float) -2.315;
		double d = 345.123;
		char s = 's', t = 't', a = 'a', r = 'r', m = 'm', n = 'n';
		boolean bool = true;
		
		long ans1 = (sh-i)*b;
		long ans2 = sh-i*el;
		long ans3 = el/(sh+i);
		double ans4 = f/d;
		double ans5 = d/(f-2.13);
		double ans6 = (i+ans2*(ans1/(i+1)-ans3+(ans4/f-1)))/d;
		
		System.out.println("ans1 = " + ans1);
		System.out.println("ans2 = " + ans2);
		System.out.println("ans3 = " + ans3);
		System.out.println("ans4 = " + ans4);
		System.out.println("ans5 = " + ans5);
		System.out.println("ans6 = " + ans6);
		
		System.out.println("mighty "+s+t+a+r+m+a+n);

	}
}
