// Ajay Jain
// September 28, 2012
// Cylinder.java
// This class of methods calculates the volume and surface area
// of a cylinder using the radius and height as inputs.

// Class variables:
// 		radius		- radius of the cylinder
// 		height		- height of the cylinder
// 		surfacearea	- surface area of the cylinder

// Class methods:
// 		getDimension()	- inputs radius and height of the cylinder
// 		findSandV()		- calculates the surface area and volume of cylinder
// 		printToScreen()	- print results to the screen

import java.util.Scanner;

public class Cylinder {
	private double radius, height, volume, surfacearea;
	
	public Cylinder() {} // constructor
	public Cylinder(double r, double h) { // overloaded constructor
		radius = r;
		height = h;
	}
	
	public Cylinder getDimension() {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("\nEnter the radius (a double)\t->  ");
		radius = kb.nextDouble();
		System.out.print("Enter the height (a double)\t->  ");
		height = kb.nextDouble();
		
		return this;
	}
	
	private double calculateSA() {
		return 2.0 * Math.PI * radius * height +
			   2.0 * Math.PI * Math.pow(radius, 2);
	}
	
	private double calculateArea() {
		return Math.PI * Math.pow(radius, 2) * height;
	}
	
	public Cylinder findSandV() {
		volume = calculateArea();
		surfacearea = calculateSA();
		
		return this;
	}
	
	public Cylinder printToScreen() {
		System.out.println("\nCylinder information:");
		System.out.printf("\nradius\t= %10.4f", radius);
		System.out.printf("\nheight\t= %10.4f", height);
		System.out.printf("\nvolume\t= %10.4f", volume);
		System.out.printf("\nsurface area\t= %10.4f", surfacearea);
		System.out.println("\n\n");
		
		return this;
	}
	
}
