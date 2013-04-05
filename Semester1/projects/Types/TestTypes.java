// Ajay Jain
// September 6, 2012
// TestTypes.java
// This program will exercise primitive data types, println, and print.

public class TestTypes {
	public static void main(String[] args) {
				
		byte b = -120; // -128 to 127 (1 byte)
		System.out.println(b);
		System.out.println("b = " + b);
		System.out.print("b = " + b);
		System.out.println();
		
		short sh = 3; 		// from -32768 to 32767 (2 bytes)
		int i    = 213; 	// (4 bytes)
		long l   = 3080231; // (8 bytes)

		long ans = sh * i + l;
		System.out.println("ans = " + ans);
		
		char ch; 			// ASCII characters (1 byte)
		ch = 'A';
		System.out.println("ch = " + ch);
		
		boolean bool;		// true or false
		bool = true;
		System.out.println("bool = " + bool);
		
		float f;			// has decimal (4 bytes)
		double d;			// (8 bytes)	
		f = (float) 3.1415926;
		d = -23.2345e-4;
		double q = f / d;
		System.out.println("q = " + q);
		
	} // end main
} // end class TestTypes
