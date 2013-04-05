// Ajay Jain
// January 13, 2013
// RPN.java
// RPN (Reverse Polish Notation) calculator

import java.util.Stack;

public class RPN extends Stack<Double> {
	public double add() throws Exception {
		if (size() >= 2) {
			double res = pop() + pop();
			push(res);
			return res;
		} else
			throw new Exception("Less than 2 items on stack");
	}
	
	public double subtract() throws Exception {
		if (size() >= 2) {
			double res = -1*pop() + pop();
			push(res);
			return res;
		} else
			throw new Exception("Less than 2 items on stack");
	}
	
	public double multiply() throws Exception {
		if (size() >= 2) {
			double res = pop() * pop();
			push(res);
			return res;
		} else
			throw new Exception("Less than 2 items on stack");
	}
	
	public double divide() throws Exception {
		if (size() >= 2) {
			double res = 1.0 / pop() * pop();
			push(res);
			return res;
		} else
			throw new Exception("Less than 2 items on stack");
	}
	
	public String toString() {
		String arr = super.toString();
		return arr.substring(1,arr.length()-1);
	}
}
