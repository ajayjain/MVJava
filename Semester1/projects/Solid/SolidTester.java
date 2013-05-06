// Ajay Jain
// November 27, 2012
// Solid.java
// This program models a Cylinder by calculating the volume and surface area, which extends a general Solid class.

// Solid Class Methods:
	// setSurfaceArea:	Set the Solid's Surface Area
	// SetVolume:		Set the Solid's Volume
	// GetSurfaceArea:	Returns the Solid's Surface Area
	// GetVolume:		Returns the Solid's Volume
// Solid Class Variables:
	// surfaceArea:		surface area of solid
	// volume:			volume of solid

// Cylinder Class Methods:
	// SetRadius:		Sets the radius value of the Cylinder's base
	// SetHeight:		Sets the height value of the Cylinder
	// CalcSurfaceArea:	Calculates the Cylinder's surface area
	// CalcVolume:		Calculates the Cylinder's volume
// Cylinder Class Variables:
	// radius:			base radius of cylinder
	// height:			height of cylinder



public class SolidTester {
	public static void main (String[] args) {
		// Cylinder 1
		Cylinder cyl1 = new Cylinder();
		int r1 = 34, h1 = 5;
		cyl1.SetRadius( r1 );
		cyl1.SetHeight( h1 );
		cyl1.CalcSurfaceArea();
		cyl1.CalcVolume();
		System.out.println("First Cylinder:");
		System.out.printf("\tradius\t= %4d\n", r1);
		System.out.printf("\theight\t= %4d\n", h1);
		System.out.printf("\tsurface area\t= %10.2f\n",
				cyl1.GetSurfaceArea());
		System.out.printf("\tvolume\t\t= %10.2f\n\n",
				cyl1.GetVolume());
		// Cylinder 2
		Cylinder cyl2 = new Cylinder();
		double r2 = 24.34, h2 = 12.32;
		cyl2.SetRadius( r2 );
		cyl2.SetHeight( h2 );
		cyl2.CalcSurfaceArea();
		cyl2.CalcVolume();
		System.out.println("Second Cylinder:");
		System.out.printf("\tradius\t= %6.2f\n", r2);
		System.out.printf("\theight\t= %6.2f\n", h2);
		System.out.printf("\tsurface area\t= %10.2f\n",
				cyl2.GetSurfaceArea());
		System.out.printf("\tvolume\t\t= %10.2f\n\n",
				cyl2.GetVolume());
				
		Sphere s = new Sphere();
		double r3 = 10;
		s.SetRadius( r3 );
		s.CalcSurfaceArea();
		s.CalcVolume();
		System.out.println("Sphere:");
		System.out.printf("\tradius\t= %6.2f\n", r3);
		System.out.printf("\tsurface area\t= %10.2f\n",
				s.GetSurfaceArea());
		System.out.printf("\tvolume\t\t= %10.2f\n\n",
				s.GetVolume());
				
		Prism p = new Prism();
		double l = 10, w = 10.1, h = 22;
		p.SetDimensions(l,w,h);
		p.CalcSurfaceArea();
		p.CalcVolume();
		System.out.println("Prism:");
		System.out.printf("\tlength\t= %6.2f\n", l);
		System.out.printf("\twidth\t= %6.2f\n", w);
		System.out.printf("\theight\t= %6.2f\n", h);
		System.out.printf("\tsurface area\t= %10.2f\n",
				p.GetSurfaceArea());
		System.out.printf("\tvolume\t\t= %10.2f\n\n",
				p.GetVolume());
	}
}


abstract class Solid {
	private double surfaceArea, volume;
	
	public Solid() {
		surfaceArea = volume = 0;	
	}
	
	public void SetSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	public void SetVolume(double volume) {
		this.volume = volume;
	}
	
	public double GetSurfaceArea() {
		return surfaceArea;
	}
	
	public double GetVolume() {
		return volume;
	}
}

class Cylinder extends Solid {
	private double radius, height;
	
	public Cylinder() {
		super();
		radius = height = 0;
	}
	
	public void SetRadius(int radius) {
		this.radius = radius;
	}
	
	public void SetRadius(double radius) {
		this.radius = radius;
	}
	
	public void SetHeight(int height) {
		this.height = height;
	}
	
	public void SetHeight(double height) {
		this.height = height;
	}
	
	public void CalcSurfaceArea() {
		SetSurfaceArea(2*Math.PI*Math.pow(radius, 2) + 2*Math.PI*radius*height);
	}
	
	public void CalcVolume() {
		SetVolume(Math.PI*Math.pow(radius, 2)*height);
	}
}


class Prism extends Solid {
	private double l, w, h;
	
	public Prism() {
		super();
		l = w = h = 0;
	}
	
	public void SetDimensions(int l, int w, int h) {
		this.l = l;
		this.w = w;
		this.h = h;
	}
	
	public void SetDimensions(double l, double w, double h) {
		this.l = l;
		this.w = w;
		this.h = h;
	}
	
	public void CalcSurfaceArea() {
		SetSurfaceArea(2*(l*w+w*h+l*h));
	}
	
	public void CalcVolume() {
		SetVolume(l*w*h);
	}
}

class Sphere extends Solid {
	private double radius;
	
	public Sphere() {
		super();
		radius = 0;
	}
	
	public void SetRadius(int radius) {
		this.radius = radius;
	}
	
	public void SetRadius(double radius) {
		this.radius = radius;
	}
	
	public void CalcSurfaceArea() {
		SetSurfaceArea(4*Math.PI*Math.pow(radius, 2));
	}
	
	public void CalcVolume() {
		SetVolume(4.0/3*Math.PI*Math.pow(radius, 3));
	}
}
