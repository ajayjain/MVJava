// Ajay Jain
// 1 April 2013
// GamePrep.java
// This program provides an example of different layouts:
// BorderLayout, FlowLayout, GridLayout, and CardLayout.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePrep {
	private ControlPanel controls;
	private ButtonPanel buttons;
	private LeadTablePanel leadTable;
	private JFrame frame;
	
	public static void main (String[] args) {
		GamePrep gpa = new GamePrep();
		gpa.run();
	}
	
	public void run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 640);

		// Create the colors panel and buttons panel
		JPanel colorPicker = new JPanel();
		colorPicker.setLayout(new BorderLayout());

		JPanel colorPickerHeader = new JPanel();
		colorPickerHeader.setLayout(null);
		colorPickerHeader.add(new JLabel("Choose a colored card"));
		colorPickerHeader.add(new JButton("Select"));

		colorPicker.add(colorPickerHeader, BorderLayout.NORTH);

		ColorPanel colors = new ColorPanel();
		buttons = new ButtonPanel();
		controls = new ControlPanel();
		leadTable = new LeadTablePanel();
		
		
		// add the JPanels to the frame
		frame.getContentPane().add(controls, BorderLayout.NORTH);
		frame.getContentPane().add(leadTable, BorderLayout.CENTER);
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);

		// make the frame visible
		frame.setVisible(true);
	}
	
	class ControlPanel extends JPanel implements ActionListener {
		private JButton launch, lead;
		private JTextField nameField;
		
		public ControlPanel() {
			// FlowLayout (default)
			launch = new JButton("NEW GAME");
			launch.addActionListener(this);
			add(launch);
			nameField = new JTextField("Username", 9);
			add(nameField);
			lead = new JButton("LEADERBOARD");
			lead.addActionListener(this);
			add(lead);
		}
		
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().remove(colors);
			frame.getContentPane().add(leadTable, BorderLayout.CENTER);
			colors.setVisible(false);
			leadTable.setVisible(true);
			if (e.getActionCommand().equals("NEW GAME")) {
				// if (!launched) {
					frame.getContentPane().remove(leadTable);
					frame.getContentPane().add(colors, BorderLayout.CENTER);
					leadTable.setVisible(false);
					colors.setVisible(true);
				// }
			}
			if (e.getActionCommand().equals("LEADERBOARD")) {
				// if (launched) {

				// }
			}
		}
	}
	
	class LeadTablePanel extends JPanel {
		private String[] columnNames = {"Username", "Date", "Score", "Color"};
		private Object[][] data = {
			{"Ajay", "4 April 2013", new Integer(1000), "Orange"},
			{"Daniel", "3 April 2013", new Integer(10), "Blue"},
			{"Alan", "4 April 2013", new Integer(10), "Red"}
		};
		
		public LeadTablePanel() {
			// setLayout(new GridLayout(10,3));
			// add(new JLabel("Ajay"));
			JTable table = new JTable(data, columnNames);
			add(table);
		}
	}
	
	class FillPanel extends JPanel    {
       JPanel panel1, panel2, panel3;
       Drawer drawer1;
       JTextArea area;
       JTextField field;
       JScrollBar bar;
       JButton button1, button2;
       
       public FillPanel ( ) {
	       this.setLayout(new GridLayout(2,1));
	       panel1 = new JPanel();
	       panel1.setLayout(new GridLayout(2,1));
	       
	       panel2 = new JPanel();
	       area = new JTextArea(8,8);
	       field = new JTextField("good");
	       bar = new JScrollBar( JScrollBar.HORIZONTAL, 1, 1, 1, 20 );
	       
	       panel2.add(area);
	       panel2.add(field);
	       panel2.add(bar);
	       
	       panel3 = new JPanel();
	       panel3.setLayout(new BorderLayout());
	       
	       button1 = new JButton("Java");
	       button2 = new JButton("Programmer");
	       
	       panel3.add(button1,BorderLayout.EAST);
	       panel3.add(button2,BorderLayout.CENTER);
	       
	       panel1.add(panel2);
	       panel1.add(panel3);
	       
	       this.add(panel1);
	       drawer1 = new Drawer();
	       this.add(drawer1);
       }
	}
	
	class Drawer extends JPanel{
       public Drawer ( )   {
	       setBackground(Color.RED);
       }
       public void paintComponent ( Graphics g ) {
	       super.paintComponent(g);
       }
	}


	
	class ColorPanel extends JPanel implements MouseListener {
		//////////////////////////////////////////////////////////
		// Declare CardLayout and JPanel objects
		private CardLayout cards;
		private JPanel color1, color2, color3;
		
		public ColorPanel() {			// constructor
			////////////////////////////////////////////////////////
			// Initialize CardLayout and setLayout() to this panel
			cards = new CardLayout();
			this.setLayout(cards);
			
			////////////////////////////////////////////////////////
			// Create blue, green and red JPanels and set their backgrounds
			color1 = new JPanel();
			color1.setBackground(Color.blue);
			
			color2 = new JPanel();
			color2.setBackground(Color.green);

			color3 = new JPanel();
			color3.setBackground(Color.red);

			////////////////////////////////////////////////////////
			// Add the MouseListener to *each* JPanel and add
			// each JPanel to ColorPanel (this)
			color1.addMouseListener(this);
			color2.addMouseListener(this);
			color3.addMouseListener(this);
			
			add(color1, "Panel 1");
			add(color2, "Panel 2");
			add(color3, "Panel 3");
		}
		public void mousePressed(MouseEvent evt) {
			////////////////////////////////////////////////////////
			// Select the next panel on the stack of panels
			cards.next(this);
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
	}
	
	class ButtonPanel extends JPanel implements ActionListener {
		private JButton lang1, lang2, lang3;
		private JTextField langField;
		private String[] languages = { "English", "French", "German" };
		
		public ButtonPanel() {
			////////////////////////////////////////////////////////
			// Change FlowLayout (default) to GridLayout
			// with 1 row and 4 columns.
			this.setLayout(new GridLayout(1,4));
					
			lang1 = new JButton (languages[0]);
			lang1.addActionListener(this);
			this.add(lang1);
			lang2 = new JButton (languages[1]);
			lang2.addActionListener(this); 		
			this.add(lang2);
			lang3 = new JButton (languages[2]);
			lang3.addActionListener(this); 		
			this.add(lang3);
			langField = new JTextField(languages[0], 9);
			this.add(langField);
		}
		
		public void actionPerformed (ActionEvent a) {
			String command = a.getActionCommand();
			for (int i=0; i < 3; i++)
				if (command.equals(languages[i])) langField.setText(languages[i]);
		}
	}
}