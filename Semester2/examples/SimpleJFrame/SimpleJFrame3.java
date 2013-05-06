// Ajay Jain
// February 4, 2013 
// SimpleJFrame3.java
// An example of adding mouse events.

// Topics:	Mouse Events
//	1. implement a MouseListener
//	2. implement a mousePressed event
//	3. implement a mouseEntered event

import java.awt.*;
////////////////////////////////////////////////
// >>> MANDATORY: import the event library
//
import java.awt.event.*;
import javax.swing.*;

public class SimpleJFrame3 {

	JFrame frame;			// JFrame and JPanel must be global object instances
	MyPanel panel;
	
	public static void main(String[] args) {
		SimpleJFrame3 sjf = new SimpleJFrame3();
		sjf.Run();
	}

	public void Run() {
		frame = new JFrame("My Third JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel and add to frame
		
		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);	// add panel to frame
		
		//////////////////////////////////////////////
		// >>> MANDATORY: must addMouseListener to JPanel
		frame.addMouseListener(panel);
		frame.setSize(500, 500);		// explicitly set size in pixels
		frame.setVisible(true);		// set to false to make invisible
		
	}

}	// end class SimpleJFrame2

// Create a JPanel class
////////////////////////////////////////////////
// >>> MANDATORY: implement a MouseListener
//
class MyPanel extends JPanel implements MouseListener {

	private int xloc, yloc;		// x and y locations of oval
	private int width, height;	// width and height of JPanel
	private Color cOval;		// color of oval
	private int colorCount;		// color counter for oval
	
	public MyPanel() {
		xloc = yloc = 100;
		cOval = Color.red;
		colorCount = 0;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	// execute the superclass method first
		width = getWidth();			// width of JPanel
		height = getHeight();		// height of JPanel
		
		// Set background color
		setBackground(Color.white);
		
		// Draw blue rectangle
		g.setColor(Color.blue);
		g.fillRect(10, 10, width-20, height-20);
		
		// Draw red oval
		g.setColor(cOval);
		g.fillOval(xloc, yloc, xloc+60, yloc+60);
		
		// Draw Label
		g.setColor(Color.green);
		g.setFont(new Font("Arial", Font.BOLD, 28));	// font name, style, size
		g.drawString("Click here", width/2-70, height/2-10);
	}	// end paintComponent
	
	////////////////////////////////////////
	// >>>>>>>>> MANDATORY: MouseListener requires five methods
	// 		mousePressed (MouseEvent e)	- Most used event
	//		mouseClicked (MouseEvent e)
	//		mouseReleased (MouseEvent e)
	//		mouseEntered (MouseEvent e)
	//		mouseExited (MouseEvent e)
	//
	
	public void mousePressed(MouseEvent e) {
		System.out.println(e.toString());
		xloc = (int)(Math.random() * width/2);
		yloc = (int)(Math.random() * height/2);
		if (xloc > width) xloc = width - 60;
		if (xloc < 0) xloc = 0;
		if (yloc > height) yloc = height - 60;
		if (yloc < 0) yloc = 0;
		repaint();		// Calls paintComponent
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {
		colorCount++;
		switch (colorCount % 5) {
			case 0: cOval = Color.red; break;
			case 1: cOval = Color.black; break;
			case 2: cOval = Color.yellow; break;
			case 3: cOval = Color.magenta; break;
			case 4: cOval = Color.orange; break;
		}
		repaint();
	}
	
	public void mouseExited(MouseEvent e) {
		cOval = new Color(rand255(), rand255(), rand255());
		repaint();
	}
	
	private int rand255() {
		return (int) (Math.random()*255);
	}


}	// end class MyPanel

// Exercises:
//	1. Use e.getX() and e.getY() in mousePressed to position the oval
//	2. Implement more colors from package java.awt and class Color
