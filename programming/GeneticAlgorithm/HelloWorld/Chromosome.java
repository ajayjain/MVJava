// Ajay Jain
// September 24, 2012
// Chromosome.java
// Chromosome for genetic algorithm

import java.util.ArrayList;

public class Chromosome {
	public String code;
	public int cost = 9999;
	
	public String random(int length) {
		while (length>0) {
			int rand = (int) (Math.random()*128);
			this.code += (char) (rand >= 32 ? rand : rand+32);
			length--;
		}
		this.code = this.code.substring(4); // null shows up at the start for some reason
		return this.code;
	}
	
	public int calcCost(String str) {
		// if (compareTo.length() < this.code.length()) throw new Error("calcCost param compareTo is too short "+this.code+" vs "+compareTo);
		int total = 0;
		for (int i = 0, _len = this.code.length(); i < _len; i++) {
			total += this.code.compareTo(str);
		}
		this.cost = total;
		return this.cost;
	}
	
	public ArrayList crossOver(Chromosome chromo) {
		ArrayList children = new ArrayList(2);
		int pivot = Math.abs(this.code.length()/2);
		Chromosome child1 = new Chromosome(this.code.substring(0, pivot) + chromo.code.substring(pivot));
		Chromosome child2 = new Chromosome(chromo.code.substring(0, pivot) + this.code.substring(pivot));
		
		children.add(0, child1);
		children.add(1, child2);
		return children;
	}
	
	public Chromosome mutate(Chromosome chromo) {
		return chromo;
	}
	
	Chromosome(String code) {
		this.code = code;
	}
	Chromosome(int length) {
		this.code = this.random(length);
	}
}
