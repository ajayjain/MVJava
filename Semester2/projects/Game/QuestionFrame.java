import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class QuestionFrame extends JFrame {
	private JPanel choicePanel;
	private JLabel questionText;
    
    private Color blueColor = new Color(105, 204, 255);
    
    private Border paddingBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private Border blueBorder = BorderFactory.createLineBorder(blueColor, 3);
    private Border headerBorder = BorderFactory.createCompoundBorder(blueBorder, paddingBorder);
	
	public QuestionFrame() {
		super();
		setTitle("Quiz Question");
		setSize(500, 500);
		setLocation(600, 300);
		
		// Create JPanel containing answer choice buttons
		choicePanel = new JPanel();
		choicePanel.setLayout(new GridLayout(4, 1));
        choicePanel.setBackground(blueColor);
		
		// Create text area for question
		questionText = new JLabel("", JLabel.CENTER);
        questionText.setBorder(headerBorder);
		questionText.setFont(new Font("Sans-serif", Font.PLAIN, 25));
		getContentPane().add(questionText, BorderLayout.NORTH);
		//questionText.setEditable(false);
	}
	
	public void askQuestion(String[] question, JButton[] choices) {
		questionText.setText(question[0]);
		
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
