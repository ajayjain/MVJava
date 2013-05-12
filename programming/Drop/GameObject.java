<<<<<<< HEAD
// Ajay Jain
// GameObject.java
// October 13, 2012

import java.awt.Graphics;
import java.awt.Color;

public abstract class GameObject {
	protected int x, y, width, height, vel, accel;
	protected Color color;

	abstract void draw(Graphics g);

	abstract void update(Drop game);

	public int getX() { return x; }

	public void setX(final int pos) { x = pos; }

	public int getY() { return y; }

	public void setY(final int pos) { y = pos; }

	public int getWidth() { return width; }

	public void setWidth(final int w) { width = w; }

	public int getHeight() { return height; }

	public void setHeight(final int h) { height = h; }
}
=======
// Ajay Jain
// GameObject.java
// October 13, 2012

import java.awt.Graphics;
import java.awt.Color;

public abstract class GameObject {
	protected int x, y, width, height, vel, accel;
	protected Color color;

	abstract void draw(Graphics g);

	abstract void update(Drop game);

	public int getX() { return x; }

	public void setX(final int pos) { x = pos; }

	public int getY() { return y; }

	public void setY(final int pos) { y = pos; }

	public int getWidth() { return width; }

	public void setWidth(final int w) { width = w; }

	public int getHeight() { return height; }

	public void setHeight(final int h) { height = h; }
}
>>>>>>> b16349f797fd59c83655a224675cf6586946181b
