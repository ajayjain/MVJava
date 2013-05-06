// Ajay Jain
// January 31, 2013
// GUI.java
// GUI for RPN.java

import java.awt.*;
import javax.swing.*;

public class RPNGUI extends CalcGUI {
	RPN calc;
	
	public RPNGUI() { calc = new RPN(); }
	
	public static void main() {
		RPNGUI gui = new RPNGUI();
		gui.launch();
	}
}
