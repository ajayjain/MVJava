// Ajay Jain
// October 22, 2012
// LoopExample2.java
// An example of for loops and nested loops.

public class LoopExample2 {
	public static void main(String[] args) {
		
		for (int col = 1; col < 10; col++) {
			System.out.print(col);
		}
		System.out.println();
		
		for (int row = 1; row <= 9; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print(col);
			}
			System.out.println();
		}
		
		
	}
}
