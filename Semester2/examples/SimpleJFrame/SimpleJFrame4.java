// Ajay Jain
// February 11, 2012
// SimpleJFrame4.java
// An example of adding mouse motion events.

// Topics:	Mouse Motion Events
//	1. implement a MouseMotionListener
//	2. implement a mouseDragged event
//	3. use the Rectangle class to define an area

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleJFrame4 {

	JFrame frame;			// JFrame and JPanel must be global object instances
	MyPanel panel;
	
	public SimpleJFrame4 () {
	}
	
	public static void main(String[] args) {
		SimpleJFrame4 sjf = new SimpleJFrame4();
		sjf.Run();
	}

	public void Run() {
		frame = new JFrame("My Fourth JFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel and add to frame
		
		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);	// add panel to frame
		
		//////////////////////////////////////////////
		// >>> MANDATORY: must addMouseMotion Listener to JPanel
		frame.addMouseListener(panel);
		frame.addMouseMotionListener(panel);
		
		frame.setSize(500, 500);		// explicitly set size in pixels
		frame.setVisible(true);		// set to false to make invisible
		
	}

}	// end class SimpleJFrame2

// Create a JPanel class
////////////////////////////////////////////////
// >>> MANDATORY: implement a MouseMotionListener
//
class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

	private int xloc, yloc;		// x and y location of oval
	private int width, height;	// width and height of JPanel
	////////////////////////////////////////
	// Create variable to determine dragging
	private boolean dragging;
	
	private int xMouse, yMouse;		// location of mouse
	////////////////////////////////////////////////
	// New Rectangle class
	private Rectangle rect;
	
	public MyPanel() {
		xloc = yloc = 100;
		////////////////////////////////////////
		// Set default for dragging
		dragging = false;

		xMouse = yMouse = 0;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	// execute the superclass method first
		width = getWidth();			// width of JPanel
		height = getHeight();		// height of JPanel
		
		// Set background color
		setBackground(Color.white);
		
		// Draw blue rectangle
		g.setColor(Color.blue);
		g.fillRect(xloc, yloc, 50, 50);
		////////////////////////////////////////////////
		// Create Rectangle around drawn rectangle
		rect = new Rectangle(xloc, yloc+30, 50, 50);
		
	}	// end paintComponent
	
	// MouseListener methods
	public void mousePressed (MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
		////////////////////////////////////////
		// determine if mouse is pressed inside drawn rectangle
		if (rect.contains(xMouse, yMouse))
			dragging = true;
	}
	public void mouseReleased (MouseEvent e) {
		////////////////////////////////////////
		// Stop dragging
		dragging = false;
	}
	public void mouseClicked (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
	////////////////////////////////////////
	// >>>>>>>>> MANDATORY: MouseMotionListener requires two methods
	public void mouseDragged (MouseEvent e) {
		//System.out.println("mouseDragged");
		if (dragging) {
			xloc = xloc + (e.getX() - xMouse);
			yloc = yloc + (e.getY() - yMouse);
			xMouse = e.getX();
			yMouse = e.getY();
			repaint();
		}
	}
	public void mouseMoved (MouseEvent e) {}
	
}	// end class MyPanel

// Exercises:
//	1. Paint several objects and allow dragging of any one
