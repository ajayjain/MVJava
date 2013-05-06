// Ajay Jain
// October 16, 2012
// LoopExample.java
// An example of counting 

public class LoopExample {
	public static void main(String[] args) {
		int count;
		
		count = 0;
		System.out.println("before the while loop, count = " + count);
		while(count < 10) {
			System.out.println("inside the while loop, count = " + count);
			++count;
		}
		System.out.println("after the while loop, count = " + count);
		
		count = 0;
		System.out.println("\nbefore the do while loop, count = " + count);
		do {
			System.out.println("inside the do while loop, count = " + count);
			++count;
		} while(count < 10);
		System.out.println("after the do while loop, count = " + count);
	}
}
