// Ajay Jain
// September 28, 2012
// CylinderTester.java
// This program calculates the volume and surface area of a cylinder, using the radius and height as input.

public class CylinderTester {
	public static void main(String[] args) {
		
		Cylinder mycan = new Cylinder()
							.getDimension() // input radius and height
							.findSandV() // calculates surface area and volume
							.printToScreen();
		
		Cylinder myothercan = new Cylinder(2.0, 5.0);
		myothercan.findSandV();
		myothercan.printToScreen();
		
	}
}
