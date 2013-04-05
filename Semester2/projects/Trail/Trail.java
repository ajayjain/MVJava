// Ajay Jain
// February 26, 2013
// Trail.java
// Control a slowly fading, snake-like trail with the keyboard/numpad.

import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Trail {
	JFrame frame;	// frame/window for the game
	JPanel panel;	// panel containing content
	ArrayList<Point> pts = new ArrayList<Point>();	// Upper left coords of boxes
	
	public static void main(String[] args) {
		Trail game = new Trail();
		game.run();
	}
	
	// Starting point to launch game
	public void run() {
		frame = new JFrame("Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new GamePanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	// Content of JFrame, listens for KeyEvents
	class GamePanel extends JPanel implements KeyListener {
		public GamePanel() {
			super();
			// Start off in the center of the screen
			pts.add(new Point(225, 225));
			frame.addKeyListener(this);
		}
		
		// Draws content of pane (rectangles)
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int alpha = 255;
			// Loop through pts backwards
			for (int counter = pts.size()-1; counter >= 0; counter--) {
				if (alpha > 0) {
					Point p = pts.get(counter);
					g.setColor(new Color(0, 0, 0, alpha));
					g.fillRect((int) p.getX(), (int) p.getY(), 5, 5);
					// Decrement transparency
					alpha -= 2;
				}
			}
		}
		
		// Calls addPoint with coords depending on which key is pressed
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			switch (c) {
				case 'w': case '8': addPoint(0, -5); break;
				case 'a': case '4': addPoint(-5, 0); break;
				case 'x': case '2': addPoint(0, 5); break;
				case 'd': case '6': addPoint(5, 0); break;
				case 'q': case '7': addPoint(-5, -5); break;
				case 'e': case '9': addPoint(5, -5); break;
				case 'z': case '1': addPoint(-5, 5); break;
				case 'c': case '3': addPoint(5, 5); break;
			}
		}
		
		// Adds new point and ensures it is within the boundarys of the screen
		// dx = difference in x from last point
		// dy = difference in y from last point
		private void addPoint(int dx, int dy) {
			Point lastpt = pts.get(pts.size()-1);
			double nx = lastpt.getX()+dx,
				   ny = lastpt.getY()+dy;
			
			if (nx > -5 && ny > -5 && nx <= 485 && ny <= 465) {
				Point newpt = new Point((int) nx, (int) ny);
				pts.add(newpt);
				repaint();
			}
		}
		
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}
}
