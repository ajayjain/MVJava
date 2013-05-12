// Ajay Jain
// February 23, 2013
// GameObject.java
// General Object (eg blocks, slime) for SlimeRun

import java.awt.Image;
import java.awt.Graphics;

public abstract class GameObject {
	// Object codes
	public static final int
		AIR = 0,
		BUMP = 1,
		SPIKES = 2,
		OVERHANG = 3;
	
	public double x;	// x pos is fractional to allow for granular accelleration
	public int w, h, y;	// width, height, y pos
	
	public double accel_y = .09;
	public double vel_y = 0;	// Stationary at start
	public double max_y = 10;	// Terminal velocity
	
	public double accel_x = 0;
	public double vel_x = 0;	// Stationary at start
	public double max_x = 0;	// Stationary FOREVER (by default)
	
	public Image[] frames;	// All frames
	public int currFrame = 0;	// Index of next image to draw
	
	public GameObject() {}
	public GameObject(int x, int y) { this.x = x; this.y = y; }
	
	// Update velocity and position of object
	public void move() {
		vel_y += accel_y;	// Boost velocity
		//if (vel_y > max_y) vel_y = max_y;	// Ensure object isn't speeding
		y += vel_y;	// Update position (I LIKE TO MOVE IT MOVE IT!)
		
		// Same tasks for for horizontal movement
		vel_x += accel_x;
		if (vel_x > max_x) vel_x = max_x;
		x += vel_x;
	}
}
