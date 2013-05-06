// Ajay Jain
// January 24, 2013
// SimpleJFrame2.java
// An example of adding a JPanel to a JFrame and painting inside the JPanel.

// Topics: JPanel and paintComponet()
//		1. How to create a class extending JPanel
//		2. Paint inside the JPanel

import java.awt.*;
import javax.swing.*;

public class SimpleJFrame2 {
	
	JFrame frame;
	MyPanel panel;
	
	public static void main(String[] args) {
		SimpleJFrame2 sjf = new SimpleJFrame2();
		sjf.Run();
	}
	
	public void Run() {
		// Create JFrame object
		frame = new JFrame("1337 JFrame!");
		
		// Set the parameters on the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create JPanel
		panel = new MyPanel();
		
		// Add JPanel to JFrame
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Size the frame and put in specific location
		frame.setSize(500, 500);	// Explicitly sets size of JFrame
		frame.setLocation(200, 300);
		
		frame.setVisible(true);		// false -> hidden
	}
}

class MyPanel extends JPanel {
	//public MyPanel() { super(); }
	int size = 50;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int w = getWidth(),
			h = getHeight();
			
		setBackground(Color.gray);
		
		if (size < 300) size++;
		//else size--;
		System.out.println(size);
		
		g.setColor(Color.orange);
		g.fillRect(10, 10, w-20, h-20);
		//g.fillRect(10, 10, size, size);
		
		g.setColor(Color.green);
		g.drawString("Click here", w/2-25, h/2-25);
		
		g.setColor(Color.red);
		g.fillOval(30, 30, w-60, h-60);
	}
}
