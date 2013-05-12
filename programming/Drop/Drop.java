<<<<<<< HEAD
// Ajay Jain
// Drop.java
// October 13, 2012

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
// import java.util.ArrayList;

public class Drop extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private final int pixelSize = 40;
	private Ball ball;
	public Image image;
	private Graphics graphics;
	private boolean ballLeft = false;
	private boolean ballRight = false;
	private boolean gameOver = false;
	// public int[][] map = new int[getWidth()/pixelSize][getHeight()/pixelSize];
	public int[][] map = {
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,1,1,0,0,0,0}, // initial setup
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0}
	};

	public Drop() {
		setTitle("Drop game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(pixelSize*10, pixelSize*15+22); // ~ 22 height top bar
		setBackground(Color.orange);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);

		ball = new Ball(getWidth()/2-10, 22, pixelSize/4, Color.darkGray);

		//for (int r = 0; r <= getHeight()/pixelSize; r++) {

		//}
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();

		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();
	}

	public void paintComponent(Graphics g) {
		ball.draw(g);
		ball.update(this);
	
		/*
		for (int row=0; row < map.length; row++) {
			for (int col=0; col < map[row].length; col++)
			{
				int tile = map[row][col];
				if (tile == 1) {
					// Draw a platform
					//new Platform();
				}
			}
		}
		*/

		if (gameOver) {
			// g.clearRect
			g.drawString("GAME OVER", getWidth()/2-35, getHeight()/2);
		}
	}

	@Override
	
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed: "+key(e));
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ballLeft = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ballRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased: "+key(e));
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ballLeft = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ballRight = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	private String key(KeyEvent e) {
		return KeyEvent.getKeyText(e.getKeyCode());
	}

	public void endGame() {
		gameOver = true;
	}

	public Ball getBall() { return ball; }
	public void setBall(final Ball b) { ball = b; }
	public boolean getBallRight() { return ballRight; }
	public void setBallRight(final boolean b) { ballRight = b; }
	public boolean getBallLeft() { return ballLeft; }
	public void setBallLeft(final boolean b) { ballLeft = b; }
	// public boolean getGameOver() { return gameOver; }

	public static void main(String[] args) {
		new Drop();
	}
}
=======
// Ajay Jain
// Drop.java
// October 13, 2012

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
// import java.util.ArrayList;

public class Drop extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private final int pixelSize = 40;
	private Ball ball;
	public Image image;
	private Graphics graphics;
	private boolean ballLeft = false;
	private boolean ballRight = false;
	private boolean gameOver = false;
	// public int[][] map = new int[getWidth()/pixelSize][getHeight()/pixelSize];
	public int[][] map = {
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,1,1,0,0,0,0}, // initial setup
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0}
	};

	public Drop() {
		setTitle("Drop game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(pixelSize*10, pixelSize*15+22); // ~ 22 height top bar
		setBackground(Color.orange);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);

		ball = new Ball(getWidth()/2-10, 22, pixelSize/4, Color.darkGray);

		//for (int r = 0; r <= getHeight()/pixelSize; r++) {

		//}
	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();

		paintComponent(graphics);
		g.drawImage(image, 0, 0, null);
		repaint();
	}

	public void paintComponent(Graphics g) {
		ball.draw(g);
		ball.update(this);
	
		/*
		for (int row=0; row < map.length; row++) {
			for (int col=0; col < map[row].length; col++)
			{
				int tile = map[row][col];
				if (tile == 1) {
					// Draw a platform
					//new Platform();
				}
			}
		}
		*/

		if (gameOver) {
			// g.clearRect
			g.drawString("GAME OVER", getWidth()/2-35, getHeight()/2);
		}
	}

	@Override
	
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed: "+key(e));
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ballLeft = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ballRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased: "+key(e));
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ballLeft = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ballRight = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	private String key(KeyEvent e) {
		return KeyEvent.getKeyText(e.getKeyCode());
	}

	public void endGame() {
		gameOver = true;
	}

	public Ball getBall() { return ball; }
	public void setBall(final Ball b) { ball = b; }
	public boolean getBallRight() { return ballRight; }
	public void setBallRight(final boolean b) { ballRight = b; }
	public boolean getBallLeft() { return ballLeft; }
	public void setBallLeft(final boolean b) { ballLeft = b; }
	// public boolean getGameOver() { return gameOver; }

	public static void main(String[] args) {
		new Drop();
	}
}
>>>>>>> b16349f797fd59c83655a224675cf6586946181b
