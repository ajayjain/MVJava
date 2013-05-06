// Ajay Jain
// September 20, 2012
// Fraction.java
// This program calculates the cost of your date

import java.util.Scanner;

public class Fraction {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter your full name           -> ");
		String name = kb.nextLine();
		System.out.print("Enter the first numerator      -> ");
		int a = kb.nextInt();
		System.out.print("Enter the first demoninator    -> ");
		int b = kb.nextInt();
		System.out.print("Enter the second numerator     -> ");
		int c = kb.nextInt();
		System.out.print("Enter the second demoninator   -> ");
		int d = kb.nextInt();

		int ac = a*c;
		int ad = a*d;
		int bc = b*c;
		int bd = b*d;

		System.out.printf("Nice job, %s, here are the results for your two fractions:\n",name);
		System.out.printf("            %d        %d        %d\n",a,c,ac);
		System.out.printf("Product     --   x   --   =   ---   =%10.3f\n",ac/(float) (bd));
		System.out.printf("            %d        %d        %d\n",b,d,bd);
		System.out.println();
		System.out.printf("            %d        %d        %d\n",a,c,ad);
		System.out.printf("Quotient    --   /   --   =   ---   =%10.3f\n",ad/(float) (bc));
		System.out.printf("            %d        %d        %d\n",b,d,bc);
		System.out.println();
		System.out.printf("            %d        %d        %d\n",a,c,ad+bc);
		System.out.printf("Sum         --   +   --   =   ---   =%10.3f\n",(ad+bc)/(float) (bd));
		System.out.printf("            %d        %d        %d\n",b,d,bd);
		System.out.println();
		System.out.printf("            %d        %d        %d\n",a,c,ad-bc);
		System.out.printf("Difference  --   -   --   =   ---   =%10.3f\n",(ad-bc)/(float) (bd));
		System.out.printf("            %d        %d        %d\n",b,d,bd);
		System.out.println();
	}
}
