// Ajay Jain
// January 24, 2013
// Calvin.java
// This program draws (duh duh DUH) ... Calvin from Calvin and Hobbes

import java.awt.*;
import javax.swing.*;

public class Calvin {
	
	JFrame frame;
	MyPanel panel;
	
	public static void main(String[] args) {
		Calvin c = new Calvin();
		c.Run();
	}
	
	public void Run() {
		// Create JFrame object
		frame = new JFrame("Calvin");
		
		// Set the parameters on the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel
		panel = new MyPanel();
		
		// Add JPanel to JFrame
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Size the frame and put in specific location
		frame.setSize(400, 550);	// Explicitly sets size of JFrame
		frame.setLocation(20, 30);
		
		frame.setVisible(true);		// false -> hidden
	}
}

class MyPanel extends JPanel {
	int w, h;			// Height and width of frame
	byte un = 9;		// Size of grid unit in pixels
	byte[][] lines = {{2,27,6,27},
					 {3,23,6,27},
					 {7,13,9,21},
					 {3,20,7,24},
					 {12,7,12,17},
					 {13,7,17,15},
					 {18,41,21,42}	// Mouth
					};
			
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		w = getWidth();
		h = getHeight();
			
		setBackground(Color.white);
		drawGrid(g);
		
		// Face
		g.setColor(Color.pink);
		g.fillArc(6*un, 15*un, 27*un, 30*un, 5, -190);
		
		// Eyes
		g.setColor(Color.white);
		g.fillOval(13*un, 21*un, 8*un, 13*un);
		g.fillOval(21*un, 20*un, 8*un, 14*un);
		
		// Pupils
		g.setColor(Color.black);
		g.fillOval(18*un, 27*un, 2*un, 3*un);
		g.fillOval(22*un, 27*un, 2*un, 3*un);
		
		// Ear fill
		g.setColor(Color.pink);
		g.fillOval(4*un, 33*un, 5*un, 6*un);
		g.fillOval(30*un, 33*un, 5*un, 6*un);
		
		// Shirt
		g.setColor(Color.black);
		for (int i = 0; i < 5; i++)
			g.drawRoundRect(16*un-i, 45*un+2*un*i, 7*un+2*i, 2*un, 5, 5);
		
		// Sleeves
		
		// Hair, mouth
		drawLines(g);
	}
	
	private void drawGrid(Graphics g) {
		for (int r = 0; r < h; r += un) {
			if (r % (5*un) == 0)
				g.setColor(Color.red);
			else
				g.setColor(Color.lightGray);
			g.drawLine(0, r, w, r);	
		}
		for (int c = 0; c < w; c += un) {
			if (c % (5*un) == 0)
				g.setColor(Color.red);
			else
				g.setColor(Color.lightGray);
			g.drawLine(c, 0, c, h);
		}
	}
	
	private void drawLines(Graphics g) {
		for (byte[] l: lines)
			//System.out.println(l[0]*un);//, l[1]*un l[2]*un, l[3]*un);
			g.drawLine(l[0]*un, l[1]*un, l[2]*un, l[3]*un);
	}
}

