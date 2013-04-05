// Ajay Jain
// October 24, 2012
// Armstrong.java
// 

// Class methods:
// Class variables:

public class Armstrong {
	private int number;
	
	public Armstrong() {
		number = 1;
	}
	
	public void Calculate() {
		for (number = 1; number <= 99999; number++) {
			String numString = ""+number;
			int arm = 0;
			for (int i = 0; i < numString.length(); i++)
				arm += Math.pow(numString.charAt(i)-48,3);
			if (number == arm)
				System.out.println(arm);
		}
	}

	public static void main ( String [] args ) {
		Armstrong loop = new Armstrong ( );
		loop.Calculate ( );
	}
}
