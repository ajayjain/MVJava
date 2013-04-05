// Ajay Jain
// March 19, 2013
// Me.java
// An album of my life with pictures and descriptions. Click to change the page.

import java.awt.*;			// for classes Image, Graphics, Color
import java.awt.event.*;	// for classes KeyListener, MouseListener
import javax.swing.*;		// for class JFrame
import java.io.*;
import javax.imageio.*;

public class Me { 
	private JFrame frame;	// Program window
	private DrawingPanel canvas;		// JPanel to draw images
	private CaptionPanel caption;		// JPanel for caption
	private JTextArea textArea;			// Text area for description
	
	private Image[] images;		// Array to store loaded images
	// File names for images
	private String[] imageNames = {"", "images/family.jpg", "images/grad.jpg", "images/foosball.jpg", "images/sciencebowl.jpg", "images/debate.jpg"};
	// Value of captions at the bottom of the frame
	private String[] imageCaptions = {
		"The album of Ajay Jain",
		"Hiking in SF on my mom's birthday",
		"Kennedy Graduation",
		"Foosball with my brother at PhotoHackDay 3",
		"Science Bowl 2012",
		"Debate Team"
	};
	// Descriptions for pages
	private String[] imageDescriptions = {
			"AJAY JAIN",
			"Hello! I'm Ajay Jain, and this is an album capturing some moments of my life. "+
				"My family and I often go hiking, and this photo was taken after an arduous climb.",
			"I attended Kennedy Middle School from 6th to 8th grade and made many great friends. Some friends and I took a picture at the sunny graduation ceremony.",
			"Here, Paras (my brother) and I are playing foosball at the Dropbox headquarters in San Francisco during a hackathon.",
			"I love learning about science and how the world works, and since 6th grade, I've been competing in the DOE Science Bowl."+
				"Last year, we won 3rd place at NASA AMES.",
			"At the beginning of my freshmen year, I joined Monta Vista's Speech and Debate club. "+
				"Daniel Li and I compete as a team in the extemporaneous parlimentary debate. This picture is from League 2 at the beginning of 2013.",
		};
	private Color[] boxColors = {
		Colors.lightRed,
		Color.yellow,
		Colors.white,
		Colors.lightBlue,
		Colors.orange,
		Colors.lightBlue
	};
	private short[][] descLocs = {
	  //{x, y, width},
		{412, 300, 75},
		{30, 30, 250},
		{450, 60, 250},
		{360, 30, 250},
		{620, 30, 200},
		{650, 400, 200}
	};
	
	private byte currentPage = 0;	// Page of album to draw
	private short height = 700, width = 900;
	
	public Me() {
		images = new Image[imageNames.length];
	}
	
	public static void main(String[] args) {
		Me album = new Me();
		album.run();
	}
 	
 	// Initialization code for program
	public void run() {
		// Launch thread to load images into memory
		ImageLoader imload = new ImageLoader();
		imload.start();
	
		// Create the JPanel canvas
		canvas = new DrawingPanel();
		canvas.setLayout(null);
		
		caption = new CaptionPanel();
		caption.setPreferredSize(new Dimension(width, 30));

		textArea = new JTextArea();
		textArea.setFont(new Font("Helvetica", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		canvas.add(textArea);

		// Create the JFrame and add the JPanel
		frame = new JFrame("Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		frame.getContentPane().add(caption, BorderLayout.SOUTH);
		frame.setSize(width, height);
		// frame.setResizable(false);
		frame.setLocation(300, 0);
		frame.setVisible(true);
	}
	
	// Canvas for drawing JTextAreas and Images
	class DrawingPanel extends JPanel implements MouseListener {
		public DrawingPanel() {
			addMouseListener(this);
		}
		
		// Draw everything
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			width = (short) getWidth();
			height = (short) getHeight();
			setBackground(Color.gray);

			// Draw the image
			g.drawImage(images[currentPage], 10, 10, width-22, height-25, this);
			
			Color bgColor = boxColors[currentPage];
			// Calculate the complementary rgb color as background
			Color textColor = new Color(
						255-bgColor.getRed(),
                        255-bgColor.getGreen(),
                        255-bgColor.getBlue());

			// Configure JTextArea textArea
			textArea.setBackground(bgColor);
			textArea.setForeground(textColor);
			textArea.setText(imageDescriptions[currentPage]);

			// Position and size textArea
			short[] bounds = descLocs[currentPage];
			textArea.setBounds(bounds[0], bounds[1], bounds[2], textArea.getPreferredSize().height);
		}
		
		// Change the page of the album
		public void mousePressed(MouseEvent e){
			byte nextPage = (byte) ((currentPage + 1) % imageNames.length);	// Loop back to start once end is reached
			// if next image is loaded, then flip the page
			if (images[nextPage] != null || nextPage == 0) {
				currentPage = nextPage;
				caption.repaint();
				repaint();
			}
		}

		// Other mouse methods
		public void mouseClicked(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	// Panel containing caption at bottom of JFrame
	private class CaptionPanel extends JPanel {
		// Draw the string
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.white);
			g.setColor(Color.black);
			g.drawString(imageCaptions[currentPage], 10, 20);
		}
	}

	// Run in a thread to prevent a high startup time
	private class ImageLoader extends Thread {
		// Load images from files into memory.
		public void run() {
			if (images == null)
				images = new Image[imageNames.length];
			int imageIndex = 0;
			for (String imageName: imageNames) {
				// try-catch block for loading the image
				if (imageIndex != 0 && images[imageIndex] == null)
					try {
						images[imageIndex] = ImageIO.read(new File(imageName));
						System.out.printf("ImageLoader (Thread): Loaded %s into images[%d]\n", imageName, imageIndex);
					} catch (IOException e) {
						System.err.println("ERROR: File not found - "+imageName);
						System.exit(1);
					}
				imageIndex++;
			}
		}
	}
}

// Class containing custom semitransparent colors
class Colors {
	public static Color lightRed = new Color(255, 0, 0, 150);
	public static Color lightBlue = new Color(105, 204, 255, 150);
	public static Color lightOrange = new Color(255, 51, 0, 150);
	public static Color orange = new Color(255, 51, 0, 200);
	public static Color white = new Color(Color.white.getRed(), Color.white.getGreen(), Color.white.getBlue(), 150);
}
