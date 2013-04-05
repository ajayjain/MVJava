// Ajay Jain
// January 31, 2013
// GUI.java
// GUI for RPN.java

import java.awt.*;
import javax.swing.*;

public class CalcGUI {
	public CalcGUI() { }
	
	public void launch() {
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main() {
		CalcGUI gui = new CalcGUI();
		gui.launch();
	}
}
