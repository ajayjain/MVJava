// Ajay Jain
// January 24, 2013
// Calvin.java
// This class draws (duh duh DUH) ... Calvin from Calvin and Hobbes.

import java.awt.*;
import javax.swing.*;

public class Calvin {
	public static void main(String[] args) {
		Calvin c = new Calvin();
		c.Run();
	}
	
	// Launch program & draw Calvin
	public void Run() {
		JFrame frame = new JFrame("Calvin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel panel = new MyPanel();
		
		// Add JPanel to JFrame
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		// Size the frame and put in specific location
		frame.setSize(400, 550);	// Explicitly sets size of JFrame
		frame.setLocation(300, 200);
		frame.setVisible(true);
	}
}

class MyPanel extends JPanel {
	int w, h;			// Height and width of frame
	byte un = 9;		// Size of grid unit in pixels
	// Coordinates of lines. Rows in format {x1, x2, y1, y2}.
	byte[][] lines = {
						// Hair
						{2,27,6,27},
						{3,23,6,27},
						{7,13,9,21},
						{3,20,7,24},
						{12,7,12,17},
						{13,7,17,15},
						{18,14,22,4},
						{22,4,23,14},
						{27,4,24,14},
						{27,15,30,7},
						{31,18,36,14},
						{31,19,38,20},
						{33,23,36,23},
						{33,28,37,27},
						// Arm
						{17,53,17,55},
						{19,53,19,55},
						// Mouth
						{18,41,21,42}
					};
	
	// Paints elements to the JPanel	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		w = getWidth();
		h = getHeight();
			
		setBackground(Color.white);
		drawGrid(g);
		g.setColor(Color.black);
		
		// Face
		g.drawArc(6*un, 15*un, 27*un, 30*un, 10, -200);
		
		// Eyes
		g.drawOval(13*un, 21*un, 8*un, 13*un);
		g.drawOval(21*un, 20*un, 8*un, 14*un);
		// Pupils
		g.setColor(Color.black);
		g.fillOval(18*un, 27*un, 2*un, 3*un);
		g.fillOval(22*un, 27*un, 2*un, 3*un);
		
		// Eyebrows
		g.drawArc(16*un, (int) (16.5*un), 5*un, 4*un, 125, -65);
		g.drawArc(22*un, (int) (16.5*un), 5*un, 4*un, 110, -85);
		
		// Nose
		g.drawArc(18*un, 33*un, 5*un, 4*un, 135, 270);
		
		// Ear fill
		g.setColor(Color.white);
		g.fillOval(4*un, 33*un, 5*un, 6*un);
		g.fillOval(30*un, 33*un, 5*un, 6*un);
		// Ear outline
		g.setColor(Color.black);
		g.drawArc(4*un, 33*un, 5*un, 6*un, 100, 215);
		g.drawArc(30*un, 33*un, 5*un, 6*un, 80, -212);
		
		
		// Shirt
		g.setColor(Color.black);
		for (int i = 0; i < 5; i++)
			g.drawRoundRect(16*un-i, 45*un+2*un*i, 7*un+2*i, 2*un, 5, 5);
		// Sleeves
		g.setColor(Color.white);
		for (int i = 0; i < 4; i++)
			g.fillRoundRect(16*un-i, 45*un+2*un*i, 4*un+2*i, 2*un, 5, 5);
		g.setColor(Color.black);
		for (int i = 0; i < 4; i++)
			g.drawRoundRect(16*un-i, 45*un+2*un*i, 4*un+2*i, 2*un, 5, 5);
		
		// 	Hair, mouth, arm drawing from lines int[][]
		for (byte[] l: lines)
			g.drawLine(l[0]*un, l[1]*un, l[2]*un, l[3]*un);
	}
	
	// Draw the red and black grid
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
}

