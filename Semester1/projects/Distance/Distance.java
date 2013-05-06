// Ajay Jain
// 9/28/2012
// Distance.java
// This class gives methods for finding distance between points.

// Class variables:
// 		x1, y1, x2, y2 - x and y coordinates of points

// Class methods:
// 		DisplayPoints()	- prints cartesian points
// 		Vertical()		- calculates the vertical distance between points
// 		Horizontal()	- calculates the horizontal distance between points
// 		ShowDistance()	- prints distance between points

public class Distance {
	private double x1, y1, x2, y2;
	
	Distance(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void DisplayPoints() {
		System.out.printf("( %.2f, %.2f ), ( %.2f, %.2f )", x1, y1, x2, y2);
	}
	
	public double Vertical() {
		return Math.abs(y1-y2);
	}
	
	public double Horizontal() {
		return Math.abs(x1-x2);
	}
	
	public void ShowDistance() {
		System.out.printf("Total distance = %.2f\n",
			Math.sqrt(Math.pow(Vertical(),2) + Math.pow(Horizontal(),2)));
	}
}
