// Ajay Jain
// Platform.java
// October 13, 2012

import java.awt.Graphics;
import java.awt.Color;

public class Platform extends GameObject {

	public Platform(final int xPos, final int yPos, final int w, final int h, final Color c) {
		x = xPos;
		y = yPos;
		width = w;
		height = h;
		color = c;
		vel = 0;
		accel = 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void update(Drop game) {
		
	}

}
