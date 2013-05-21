import java.awt.*;
import javax.swing.*;

public class QuestionFrame extends JFrame {
	private JPanel choicePanel;
	private JTextArea questionText;
	
	public QuestionFrame() {
		super();
		setTitle("Quiz Question");
		setSize(500, 500);
		setLocation(600, 300);
		
		// Create JPanel containing answer choice buttons
		choicePanel = new JPanel();
		choicePanel.setLayout(new GridLayout(4, 1));
		
		// Create text area for question
		questionText = new JTextArea();
		questionText.setEditable(false);
	}
	
	public void askQuestion(String[] question, JButton[] choices) {
		// System.out.println(question[0]+" -> "+question[1]);
		questionText.setText(question[0]);
		getContentPane().add(questionText, BorderLayout.NORTH);
		
		choicePanel.removeAll();
		// Add buttons to panel for choices
		choicePanel.add(choices[0]);
		choicePanel.add(choices[1]);
		choicePanel.add(choices[2]);
		choicePanel.add(choices[3]);
		
		// Add choice panel to frame
		getContentPane().add(choicePanel, BorderLayout.CENTER);
	}
}
