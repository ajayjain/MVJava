// Ajay Jain
// February 4, 2013 
// Web.java
// This class uses MouseEvents to control the actions in the JPanel of a JFrame to display a web of vertices.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Web {
	JFrame frame;			// JFrame and JPanel must be global object instances
	ButtonPanel bpanel;		// Top panel containing buttons
	CanvasPanel cpanel;		// Bottom panel that is drawn
	
	public static void main(String[] args) {
		Web web = new Web();
		web.Run();
	}
	
	// Launch program by setting up JFrame, ButtonPanel and CanvasPanel
	public void Run() {
		frame = new JFrame("Web");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);		// explicitly set size in pixels
		
		// Create ButtonPanel and add to frame
		bpanel = new ButtonPanel();
		bpanel.setPreferredSize(new Dimension(600, 100));
		frame.getContentPane().add(bpanel, BorderLayout.NORTH);		// add button panel to frame
		
		// Create CanvasPanel and add to frame in center
		cpanel = new CanvasPanel();
		frame.getContentPane().add(cpanel, BorderLayout.CENTER);	// add canvas to frame
		
		bpanel.canvas = cpanel;		// Set instance variable of bpanel (ButtonPanel)
		
		frame.addMouseListener(bpanel);
		frame.setVisible(true);		// set to false to make invisible
	}
}

// JPanel of 5 buttons
class ButtonPanel extends JPanel implements MouseListener {
	private int width, height;		// Width and height of ButtonPanel instance
	protected CanvasPanel canvas;	// Reference to bottom panel to initiate web generation
	
	// Draw buttons on ButtonPanel
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	// execute the superclass method first
		width = getWidth();			// width of JPanel
		height = getHeight();		// height of JPanel
		
		// Set background color and size
		setBackground(Color.white);
		//setSize(width, 100);
		
		// Draw rectangles
		g.setColor(Color.blue);
		int w = width/5;
		g.fillRect(2, 2, w-2, 96);
		g.fillRect(w+2, 2, w-2, 96);
		g.fillRect(2*w+2, 2, w-2, 96);
		g.fillRect(3*w+2, 2, w-2, 96);
		g.fillRect(4*w+2, 2, w-2, 96);
		
		// Write text
		g.setColor(Color.red);
		int off = w/2-10; // offset of text from left of button
		g.setFont(g.getFont().deriveFont(40f));
		g.drawString("4", off, 65);
		g.drawString("8", off+w, 65);
		g.drawString("12", off+2*w-15, 65);
		g.drawString("16", off+3*w-15, 65);
		g.drawString("20", off+4*w-15, 65);
		
	}	// end paintComponent
	
	// Called when mouse is pressed down, finds which button was clicked based off x and y coords
	public void mousePressed(MouseEvent e) {
		// Coords of click
		int x = e.getX(),
			y = e.getY();
			
		if (y <= 125) {
			int vert = 4*((x-8)/(width/5)+1);
			System.out.printf("mousePressed x = %d y = %d vertices = %d\n", x, y, vert);
			canvas.vertices = vert;
			canvas.repaint();
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}	// end class ButtonPanel

// Canvas for drawing web
class CanvasPanel extends JPanel {
	private int width, height;		// Width and height of CanvasPanel
	protected int vertices = 12;	// Default number of vertices, set based off which button is clicked
	
	// Draw web
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.black);
		
		width = getWidth();
		height = getHeight();
		
		g.setColor(Color.white);
		generate(vertices, g);		// Draw lines for first time
	}
	
	/*
	 * @method	generate    Generates random vertices and draws lines
	 * @param	int n		Number of vertices
	 * @param	Graphics g	Graphics object to draw on
	 */
	public void generate(int n, Graphics g) {
		Random rand = new Random();
		int[][] pts = new int[n][2];
		
		// Generate random points
		for (int p = 0; p < n; p++) {
			pts[p][0] = rand.nextInt(width);
			pts[p][1] = rand.nextInt(height);
		}
		
		// Loop through pts
		for (int p1 = 0; p1 < n; p1++) {
			for (int p2 = 0; p2 < n; p2++) {
				if (p1 != p2) {
					// Draw line
					g.drawLine(pts[p1][0], pts[p1][1], pts[p2][0], pts[p2][1]);
				}
			}
		}
	}
}
