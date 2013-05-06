// Ajay Jain
// January 31, 2013
// REPL.java
// Command line interface for RPN calc

import java.util.Scanner;

public class REPL {
	RPN calc;
	private Scanner kb;
	
	public REPL() {
		calc = new RPN();
		kb = new Scanner(System.in);
	}
	
	public void launch() {
		System.out.println("Welcome to the Java RPN calculator. +, -, /, * are supported. \"exit\" or Control-C to exit.");
		while (true) {
			System.out.print("> ");
			String in = kb.next();
			try {
				double num = Double.parseDouble(in);
				calc.push(num);
			} catch (NumberFormatException nfe) {
				try {
					// basic operation
					if (in.length() == 1)
						switch (in.charAt(0)) {
							case '+':
								System.out.println(calc.add());
								break;
							case '-':
								System.out.println(calc.subtract());
								break;
							case '*':
								System.out.println(calc.multiply());
								break;
							case '/':
								System.out.println(calc.divide());
								break;
						}
					else if (in.equals("exit")) {
						System.out.println("Goodbye!");
						return;
					}// else if (in.equals("sqr
					else {
						System.out.println("ERROR: Unrecognized operation");
					}
				} catch (Exception e) {
					System.out.println("ERROR: "+e.getMessage());
				}
			}
			System.out.println("\nStack: "+calc.toString());
		}
	}
	
	public static void main(String[] args) {
		REPL repl = new REPL();
		repl.launch();
	}
}
