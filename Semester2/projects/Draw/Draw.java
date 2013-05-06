// Ajay Jain
// February 8, 2013
// Draw.java
// This class allows users to draw colored lines. Pressing backspace removes the last line and the clear button clears everything.

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Draw extends JFrame implements KeyListener {
	private JFrame frame;			// JFrame and JPanel must be global object instances
	private CanvasPanel cpanel;		// Panel that is drawn on frame
	
	public static void main(String[] args) {
		Draw app = new Draw();
		app.run();
	}
	
	// Launch program by setting up JFrame, ButtonPanel and CanvasPanel
	public void run() {
		setTitle("Draw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);		// explicitly set size in pixels
		setResizable(false);
		
		// Create CanvasPanel and add to frame in center
		cpanel = new CanvasPanel();
		getContentPane().add(cpanel, BorderLayout.CENTER);	// add canvas to frame
		
		addKeyListener(this);
		addMouseListener(cpanel);
		addMouseMotionListener(cpanel);
		setVisible(true);		// set to false to make invisible
	}
	
	// If backspace is pressed, call the undo method
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			cpanel.undo();
	}

	@Override public void keyTyped(KeyEvent e) {}
	@Override public void keyReleased(KeyEvent e) {}
}

// Panel with buttons and canvas for drawing
class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {
	private int width, height;			// Width and height of CanvasPanel
	private Color ink = Color.red;		// Color for future lines
	private ArrayList<Line2D.Float> lines = new ArrayList<Line2D.Float>();	// Contains coordinates of line endpoints
	private ArrayList<Color> colors = new ArrayList<Color>();				// Colors associated with each line in liness
	private boolean dragging = false;	// Is the user currently drawing a line?
	
	// Draw buttons and call drawLines
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	// execute the superclass method first
		width = getWidth();			// width of JPanel
		height = getHeight();		// height of JPanel
		
		// Set background color
		setBackground(Color.white);
		
		// Draw rectangles
		int w = width/5;
		g.setColor(Color.black);
		g.fillRect(2, 2, w-2, 80);
		g.setColor(Color.red);
		g.fillRect(w+2, 2, w-2, 80);
		g.setColor(Color.blue);
		g.fillRect(2*w+2, 2, w-2, 80);
		g.setColor(Color.gray);
		g.fillRect(3*w+2, 2, w-2, 80);
		g.setColor(Color.green);
		g.fillRect(4*w+2, 2, w-2, 80);
		
		// Write text
		g.setColor(Color.white);
		int ol = w/2-20, // offset of text from left of button
			ot = 50;	 // top offset
			
		g.setFont(g.getFont().deriveFont(20f));
		g.drawString("Reset", ol-5, ot);
		g.drawString("Red", ol+w, ot);
		g.drawString("Blue", ol+2*w, ot);
		g.drawString("Gray", ol+3*w, ot);
		g.drawString("Green", ol+4*w-8, ot);
		
		drawLines(g);
		
	}	// end paintComponent
	
	// Empty line and color arrays
	public void clear() {
		lines.clear();
		colors.clear();
	}
	
	// Undo last line by removing last elements from lines and colors arrays
	public void undo() {
		if (!lines.isEmpty()) {
			lines.remove(lines.size()-1);
			colors.remove(colors.size()-1);
			repaint();
		}
	}
	
	// Draws lines from lines ArrayList
	public void drawLines(Graphics g) {
		for (Line2D.Float l: lines) {
			g.setColor(colors.get(lines.indexOf(l)));
			g.drawLine((int) l.getX1(), (int) l.getY1(), (int) l.getX2(), (int) l.getY2());
		}
	}
	
	// Called when mouse is pressed down, finds which button was clicked based off x and y coords
	@Override
	public void mousePressed(MouseEvent e) {
		// Coords of click
		int x = e.getX(),
			y = e.getY();
			
		if (y <= 110) {
			int button = (x-8)/(width/5);
			Color c; // New color for future lines
			System.out.printf("mousePressed x = %d y = %d button = %d\n", x, y, button);
			switch (button) {
				case 0: clear(); break;
				case 1: ink = Color.red; break;
				case 2: ink = Color.blue; break;
				case 3: ink = Color.gray; break;
				case 4: ink = Color.green; break;
			}
		} else {
			// Started dragging, add a line
			dragging = true;
			lines.add(new Line2D.Float(x-5, y-25, x-5, y-25));
			colors.add(ink);
		}
		repaint();
	}
	
	// Stopped dragging, set 'dragging' variable to false
	@Override
	public void mouseReleased(MouseEvent e) {
		dragging = false;
	}
	
	// Called when mouse is dragged at least 1 pixel
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX(),
			y = e.getY();
		if (y > 106 && dragging == true) {
			// Update last line in array to represent new endpoint
			int lastIndex = lines.size()-1;
			Line2D.Float oldLine = lines.get(lastIndex),
						 newLine = new Line2D.Float((float) oldLine.getX1(), (float) oldLine.getY1(), x-5, y-25);
			lines.set(lastIndex, newLine);
			repaint();
		}
	}
	
	@Override public void mouseMoved(MouseEvent e) {}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}	// end class ButtonPanel
