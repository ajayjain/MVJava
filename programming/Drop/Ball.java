// Ajay Jain
// Ball.java
// October 13, 2012

import java.awt.Graphics;
import java.awt.Color;

public class Ball extends GameObject {

	public Ball(final int xPos, final int yPos, final int r, final Color c) {
		x = xPos;
		y = yPos;
		width = 2*r;
		height = 2*r;
		color = c;
		vel = 0;
		accel = 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	@Override
	public void update(Drop game) {
		if (game.getBallLeft())
			x--;
		else if (game.getBallRight())
			x++;

		if (y < game.getHeight()) {
			y += vel;
			vel += accel;
		} else {
			vel = 0;
			accel = 0;
			y = game.getHeight();
			game.endGame();
		}

	}

}
