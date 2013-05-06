// Mr Greenstein
// February 10, 2013
// TimerExample.java
// This program demonstrates a simple timer animation with a bouncing ball.

// Topics:
//	1. Create an ActionListener class
//	2. Implement timer for JPanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerExample {
	JFrame frame;
	DrawPanel panel;
	
	public static void main (String[] args) {
		TimerExample te = new TimerExample();
		te.Run();
	}
	
	public void Run() {
		frame = new JFrame("Timer Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel and add to frame
		
		panel = new DrawPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);	// add panel to frame
				
		frame.setSize(500, 600);		// explicitly set size in pixels
		frame.setVisible(true);		// set to false to make invisible
		
	}
	
}	// end class TimerExample

// JPanel with a private ActionListener class called "Mover"
class DrawPanel extends JPanel {

	private int x, y;
	private boolean left, up;

	
	///////////////////////////////////////////////////
	//	Create a class that implements ActionListener
	//
	/*private class Mover implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}*/
	
	// The JPanel's constructor
	public DrawPanel () {
		x = 0; y = 30;			// initial upper left corner location of red ball
		left = up = false;		// initialize ball going right and down
		////////////////////////////////////////////////
		//	Declare and initialize
		//	- an ActionListener object
		//	- a Timer
		//Mover mover = new Mover();
		Timer timer = new Timer(20, new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();
		
		////////////////////////////////////////////////
		//	Start the timer
		
	}
	
	// paintComponent() draws the circle and increments the location.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setSize(500, 600);
		setBackground(Color.white);
		g.setColor(Color.red);
		g.fillOval(x, y, 50, 50);
		if (!left && x < getWidth()-50) x++;
		else { left = true; x--; }
		if ( left && x > 0 ) x--;
		else { left = false; x++; }
		if (!up && y < getHeight()-70) y++;
		else { up = true; y--; }
		if ( up && y > 0 ) y--;
		else { up = false; y++; }
	}
}	// end class DrawPanel

// Extra:
//	1. Implement a KeyListener to redirect the movement of the ball.
