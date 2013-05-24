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
		w = h = 64;	// Block size of 16 px
		max_x = 2;
		accel_x = .05;
		
		// Load images of the slime
		loadFrames();
	}
	
	public void move() {
		super.move();
		
		// if the slime hit the ground
		if (y >= 64*2) {
			// begin sliding (only needed for the first time he falls
			if (accel_x != .25) accel_x = .25;
			
			// allow player to jump, since vel_y = 0 stops the jump
			if (jumping)
				jumping = false;
			else
				vel_y = 0;
			
			// slime is slightly lower while ducking
			if (ducking)
				y = 64*2+20;
			else
				y = 64*2;
		}
		
		// if the slime hit the top
		if (y < 0) vel_y *= -1;
	}
	
	public void duck() {
		ducking = true;
		max_x -= 0.5;	// Slow slime
		h = 64-20;
		w = 64+20;
		y += 20;
	}
	
	public void stand() {
		if (ducking) {
			ducking = false;
			max_x += 0.5;	// Restore speed
			h = w = 64;	// Adjust size
			y -= 20;	// Adjust position
		}
	}
	
	public void jump() {
		jumping = true;
		vel_y = -3.3;
	}
	
	public int getColumn() {
		return (int) (x/64)+1;
	}
	
	public void loadFrames() {
		try {
			InputStream is = getClass().getResourceAsStream("images/green/slime.png");
			imageRun = ImageIO.read(is);
			System.out.println("Loaded ./images/green/slime.png");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void drawSlime(Graphics g, ImageObserver observe) {
		// if (ducking)
			// g.drawImage(imageDuck, (int) Math.floor(x), y, w, h, observe);
		// else
			g.drawImage(imageRun, (int) Math.floor(x), y, w, h, observe);
	}

	public boolean isDucking() { return ducking; }
}
