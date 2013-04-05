// Ajay Jain
// November 30, 2012
// Pascal.java
// This program

import java.util.Scanner;

public class Pascal {
	private int h;
	public Pascal() {}
	
	public void ReadInput() {
		Scanner kb = new Scanner(System.in);
		
		while (h <= 0) {
			System.out.print("Enter height of triangle (0 to exit)\t-> ");
			h = kb.nextInt();
			if (h == 0) System.exit(0);
		}
	}
	
	public void Run() {
		for (int n = 0; n < h; n++) {
			for (int r = 0; r <= n; r++)
				System.out.printf("%-3d",Fact(n)/(Fact(r)*Fact(n-r)));
			System.out.println();
		}
	}
	
	private int Fact(int x) {
		if (x <= 1) return 1;
		return x * Fact(x-1);
	}
	
	public static void main(String[] args) {
		Pascal p = new Pascal();
		p.ReadInput();
		p.Run();
	}
}
