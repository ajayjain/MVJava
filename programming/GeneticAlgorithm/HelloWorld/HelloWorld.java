// Ajay Jain
// September 24, 2012

import java.util.ArrayList;

public class HelloWorld {

	public static void main (String args[]) {
		String goal = "Hello, World!";
		
		Chromosome chromo1 = new Chromosome(12);
		Chromosome chromo2 = new Chromosome(12);
		chromo1.calcCost(goal);
		chromo2.calcCost(goal);
		System.out.printf("%s (%d)\n", chromo1.code, chromo1.cost);
		
		ArrayList children = chromo1.crossOver(chromo2);
		//System.out.printf("%s (%d)\n", children.get(0).code, children.get(0).cost);
		//System.out.printf("%s (%d)\n", children.get(1).code, children.get(1).cost);
	}
}
