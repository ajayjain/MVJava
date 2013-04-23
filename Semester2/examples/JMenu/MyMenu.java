// Mr Greenstein
// April 14, 2013
// MyMenu.java
// This program is an example of swing menus.


// Topics:
//	1. Create a menu


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMenu {
	private JFrame frame;
	private MyDrawingPanel canvas;
	private String color, shape, fillOutline;
	
	public MyMenu() {
		color = "Blue";
		shape = "Square";
	}
	
	public static void main (String[] args) {
		MyMenu mm = new MyMenu();
		mm.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(440, 470);

		// Initialize the drawing canvas
		canvas = new MyDrawingPanel();
		
		//////////////////////////////////////////////////////////////
		// Set up color menu and menu items
		JMenu menu = new JMenu("COLOR");
		JMenuItem blue = new JMenuItem("Blue");
		JMenuItem red = new JMenuItem("Red");
		JMenuItem green = new JMenuItem("Green");
		menu.add(blue);
		menu.add(red);
		menu.add(green);
		
		ChangeColor ccListener = new ChangeColor();
		blue.addActionListener(ccListener);
		red.addActionListener(ccListener);
		green.addActionListener(ccListener);
		
		// Set up shape menu and items
		
		JMenu menu2 = new JMenu("SHAPE");
		JMenuItem square = new JMenuItem("Square");
		JMenuItem circle = new JMenuItem("Circle");
		JMenuItem oval = new JMenuItem("Oval");
		menu2.add(square);
		menu2.add(circle);
		menu2.add(oval);
		
		ChangeShape scListener = new ChangeShape();
		square.addActionListener(scListener);
		circle.addActionListener(scListener);
		oval.addActionListener(scListener);
		
		//////////////////////////////////////////////////////////////
		// Set up menu bar
		JMenuBar menus = new JMenuBar();
		menus.add(menu);
		menus.add(menu2);
		
		//////////////////////////////////////////////////////////////
		// add the menu bar to the frame
		frame.getContentPane().add(menus, BorderLayout.NORTH);

		// add the JPanel to the frame
		frame.getContentPane().add(canvas, BorderLayout.CENTER);

		// make the frame visible
		frame.setVisible(true);
	}
	
	class MyDrawingPanel extends JPanel {
		public MyDrawingPanel() {
			setBackground(Color.white);
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (color.equals("Blue")) g.setColor(Color.blue);
			else if (color.equals("Red")) g.setColor(Color.red);
			else g.setColor(Color.green);	// color is "Green"
			
			switch (shape.charAt(0)) {
				case 'S':
					g.fillRect(40, 35, 350, 350);
					break;
				case 'C':
					g.fillOval(40, 35, 350, 350);
					break;
				case 'O':
					g.fillOval(40, 60, 350, 300);
			}
		}
	}	// end class MyDrawingPanel
	
	class ChangeColor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			color = e.getActionCommand();
			canvas.repaint();
		}
	}
	
	class ChangeShape implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			shape = e.getActionCommand();
			canvas.repaint();
		}
	}

}

// Extra:
//	- Add a menu to change shape to circle and oval
