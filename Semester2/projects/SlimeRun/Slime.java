// Ajay Jain
// February 23, 2013
// Slime.java
// Main character for SlimeRun

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.ImageObserver;

public class Slime extends GameObject {
	public String[] frameNames;	// File paths of frames
	public Image imageRun;
	private boolean jumping, ducking;
	
	public Slime() {
		init();
	}
	
	public Slime(int x, int y) {
		super(x, y);
		init();
	}
	
	public void init() {
		jumping = ducking = false;
		x = 5;
		y = 1;
		w = h = 32;	// Block size of 16 px
		max_x = 1.25;
		
		// Load images of the slime
		loadFrames();
	}
	
	public void move() {
		super.move();
		
		// if the slime hit the ground
		if (y >= 32*2) {
			// begin sliding (only needed for the first time he falls
			if (accel_x != .25) accel_x = .25;
			
			// allow player to jump, since vel_y = 0 stops the jump
			if (jumping)
				jumping = false;
			else
				vel_y = 0;
			
			// slime is slightly lower while ducking
			if (ducking)
				y = 32*2+10;
			else
				y = 32*2;
		}
		
		// if the slime hit the top
		if (y < 0) vel_y *= -1;
	}
	
	public void duck() {
		//if (!jumping) {
			ducking = true;
			h = 22;
			w = 42;
			y += 10;
		//}
	}
	
	public void stand() {
		if (ducking) {
			ducking = false;
			h = w = 32;
			y -= 10;
		}
	}
	
	public void jump() {
		jumping = true;
		vel_y = -2.25;
	}
	
	public void loadFrames() {
		try {
			imageRun = ImageIO.read(new File("images/green/main.png"));
			System.out.println("Loaded ./images/green/main.png");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void drawSlime(Graphics g, ImageObserver observe) {
		g.drawImage(imageRun, (int) Math.floor(x), y, w, h, observe);
	}
}
