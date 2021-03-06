// Ajay Jain
// March 23, 2013
// Quote.java
// Displays random quotes with customizable size and color.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Quote {
	private JFrame frame;	// Window of program
	
	// Declare component identifiers
	private ButtonGroup colorPicker;	// Ensures only one radio button is selected
	private JRadioButton red, blue, green;	// The individual buttons
	private JTextArea quote, author;		// Text areas containing the body of the quote and author
	private JSlider fontSize;	// JSlider for changing the font size
	
	// Initial font for quote and author
	private Font quoteFont = new Font("Serif", Font.PLAIN, 18);
	
	// Data for quotes
	private final String[] quotes = {"Do not go where the path may lead, go instead where there is no path and leave a trail.", "Experience is not what happens to you; it's what you do with what happens to you.", "For beautiful eyes, look for the good in others; for beautiful lips, speak only words of kindness; and for poise, walk with the knowledge that you are never alone.", "By three methods we may learn wisdom: First, by reflection, which is noblest; Second, by imitation, which is easiest; and third by experience, which is the bitterest.", "If you're trying to achieve, there will be roadblocks. I've had them; everybody has had them. But obstacles don't have to stop you. If you run into a wall, don't turn around and give up. Figure out how to climb it, go through it, or work around it.", "The only true wisdom is in knowing you know nothing.", "A wise man is superior to any insults which can be put upon him, and the best reply to unseemly behavior is patience and moderation.", "A good head and a good heart are always a formidable combination.", "A fool flatters himself, a wise man flatters the fool.", "I'd rather regret the things I've done than regret the things I haven't done.", "Wisdom begins in wonder.", "The teacher who is indeed wise does not bid you to enter the house of his wisdom but rather leads you to the threshold of your mind.", "If you talk to a man in a language he understands, that goes to his head. If you talk to him in his language, that goes to his heart.", "The pessimist complains about the wind; the optimist expects it to change; the realist adjusts the sails.", "Winners never quit and quitters never win.", "Discipline is the bridge between goals and accomplishment.", "It's not what you look at that matters, it's what you see.", "Adopt the pace of nature: her secret is patience.", "Honesty is the first chapter in the book of wisdom.", "Always keep an open mind and a compassionate heart.", "A mistake is simply another way of doing things.", "A man must be big enough to admit his mistakes, smart enough to profit from them, and strong enough to correct them.", "As you walk down the fairway of life you must smell the roses, for you only get to play one round.", "If you only have a hammer, you tend to see every problem as a nail.", "Climb the mountains and get their good tidings.", "In order to succeed, your desire for success should be greater than your fear of failure.", "A successful man is one who can lay a firm foundation with the bricks others have thrown at him.", "Always be yourself, express yourself, have faith in yourself, do not go out and look for a successful personality and duplicate it.", "Take up one idea. Make that one idea your life - think of it, dream of it, live on that idea. Let the brain, muscles, nerves, every part of your body, be full of that idea, and just leave every other idea alone. This is the way to success.", "Think twice before you speak, because your words and influence will plant the seed of either success or failure in the mind of another.", "Success is not final, failure is not fatal: it is the courage to continue that counts.", "I don't know the key to success, but the key to failure is trying to please everybody.", "I've failed over and over and over again in my life and that is why I succeed.", "Always bear in mind that your own resolution to succeed is more important than any other.", "Success consists of going from failure to failure without loss of enthusiasm.", "Coming together is a beginning; keeping together is progress; working together is success.", "Try not to become a man of success, but rather try to become a man of value.", "Don't aim for success if you want it; just do what you love and believe in, and it will come naturally.", "The difference between a successful person and others is not a lack of strength, not a lack of knowledge, but rather a lack of will.", "Success is to be measured not so much by the position that one has reached in life as by the obstacles which he has overcome.", "Formula for success: rise early, work hard, strike oil.", "No man succeeds without a good woman behind him. Wife or mother, if it is both, he is twice blessed indeed.", "If at first you don't succeed, try, try again. Then quit. There's no point in being a damn fool about it.", "Develop success from failures. Discouragement and failure are two of the surest stepping stones to success.", "Formal education will make you a living; self-education will make you a fortune.", "Success is a lousy teacher. It seduces smart people into thinking they can't lose.", "Action is the foundational key to all success.", "I honestly think it is better to be a failure at something you love than to be a success at something you hate.", "Defeat is not the worst of failures. Not to have tried is the true failure.", "Failure is success if we learn from it.", "A friend is one who knows you and loves you just the same.", "Don't walk behind me; I may not lead. Don't walk in front of me; I may not follow. Just walk beside me and be my friend.", "An insincere and evil friend is more to be feared than a wild beast; a wild beast may wound your body, but an evil friend will wound your mind.", "Friendship... is not something you learn in school. But if you haven't learned the meaning of friendship, you really haven't learned anything.", "Lots of people want to ride with you in the limo, but what you want is someone who will take the bus with you when the limo breaks down.", "When we honestly ask ourselves which person in our lives means the most to us, we often find that it is those who, instead of giving advice, solutions, or cures, have chosen rather to share our pain and touch our wounds with a warm and tender hand.", "A friend should be one in whose understanding and virtue we can equally confide, and whose opinion we can value at once for its justness and its sincerity.", "In everyone's life, at some time, our inner fire goes out. It is then burst into flame by an encounter with another human being. We should all be thankful for those people who rekindle the inner spirit.", "A true friend never gets in your way unless you happen to be going down.", "A friendship can weather most things and thrive in thin soil; but it needs a little mulch of letters and phone calls and small, silly presents every so often - just to save it from drying out completely.", "A single rose can be my garden... a single friend, my world.", "I value the friend who for me finds time on his calendar, but I cherish the friend who for me does not consult his calendar.", "Be courteous to all, but intimate with few, and let those few be well tried before you give them your confidence.", "Let us be grateful to people who make us happy, they are the charming gardeners who make our souls blossom.", "Think where man's glory most begins and ends, and say my glory was I had such friends.", "Friendship is unnecessary, like philosophy, like art... It has no survival value; rather it is one of those things that give value to survival.", "One of the most beautiful qualities of true friendship is to understand and to be understood.", "True friends stab you in the front.", "The friend who can be silent with us in a moment of despair or confusion, who can stay with us in an hour of grief and bereavement, who can tolerate not knowing... not healing, not curing... that is a friend who cares.", "A true friend freely, advises justly, assists readily, adventures boldly, takes all patiently, defends courageously, and continues a friend unchangeably.", "A friend to all is a friend to none.", "A friend is someone who gives you total freedom to be yourself.", "Friendship is a single soul dwelling in two bodies.", "But friendship is precious, not only in the shade, but in the sunshine of life, and thanks to a benevolent arrangement the greater part of life is sunshine.", "It is one of the blessings of old friends that you can afford to be stupid with them."};
	private final String[] authors = {"Ralph Waldo Emerson", "Aldous Huxley", "Audrey Hepburn", "Confucius", "Michael Jordan", "Socrates", "Moliere", "Nelson Mandela", "Edward G. Bulwer-Lytton", "Lucille Ball", "Socrates", "Khalil Gibran", "Nelson Mandela", "William Arthur Ward", "Vince Lombardi", "Jim Rohn", "Henry David Thoreau", "Ralph Waldo Emerson", "Thomas Jefferson", "Phil Jackson", "Katharine Graham", "John C. Maxwell", "Ben Hogan", "Abraham Maslow", "John Muir", "Bill Cosby", "David Brinkley", "Bruce Lee", "Swami Vivekananda", "Napoleon Hill", "Winston Churchill", "Bill Cosby", "Michael Jordan", "Abraham Lincoln", "Winston Churchill", "Henry Ford", "Albert Einstein", "David Frost", "Vince Lombardi", "Booker T. Washington", "J. Paul Getty", "Harold MacMillan", "W. C. Fields", "Dale Carnegie", "Jim Rohn", "Bill Gates", "Pablo Picasso", "George Burns", "George Edward Woodberry", "Malcolm Forbes", "Elbert Hubbard", "Albert Camus", "Buddha", "Muhammad Ali", "Oprah Winfrey", "Henri Nouwen", "Robert Hall", "Albert Schweitzer", "Arnold H. Glasow", "Pam Brown", "Leo Buscaglia", "Robert Brault", "George Washington", "Marcel Proust", "William Butler Yeats", "C. S. Lewis", "Lucius Annaeus Seneca", "Oscar Wilde", "Henri Nouwen", "William Penn", "Aristotle", "Jim Morrison", "Aristotle", "Thomas Jefferson", "Ralph Waldo Emerson"};
	
	public static void main(String[] args) {
		new Quote().run();
	}
	
	// Initialize program
	public void run() {
		// Create a frame to hold everything
		frame = new JFrame("Quote");
		frame.setBackground(Color.gray);
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,2));

		// Declare and initialize JButton, then add to JFrame
		JButton rbutton = new JButton("PRESS FOR A RANDOM QUOTE");
		rbutton.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		rbutton.addActionListener(new ButtonListener());
		frame.add(rbutton);
		
		// Text area for text of quote
		quote = new JTextArea(quotes[0]);
		quote.setEditable(false);
		quote.setLineWrap(true);
		quote.setWrapStyleWord(true);
		quote.setFont(quoteFont);
		quote.setForeground(Color.red);
		frame.add(quote);
		
		initRadioButtons();
		
		// Initialize JTextField, set editable to false, then add to JFrame
		author = new JTextArea(" - "+authors[0]);
		author.setEditable(false);
		author.setFont(quoteFont);
		author.setForeground(Color.red);
		frame.add(author);
		
		initSlider();
		
		frame.setVisible(true);
	}
	
	// Configure and add the JSlider
	private void initSlider() {
		fontSize = new JSlider(16, 24);
		fontSize.setValue(18);
		// Add ticks
		fontSize.setMajorTickSpacing(2);
		fontSize.setMinorTickSpacing(1);
		fontSize.setPaintTicks(true);
		// Add labels
		fontSize.setLabelTable(fontSize.createStandardLabels(2));
		fontSize.setPaintLabels(true);
		
		fontSize.addChangeListener(new SliderListener());
		frame.add(fontSize);
	}
	
	// Initialize JRadioButtons, a JPanel, and a ButtonGroup, add items, add listener, then add to JFrame
	private void initRadioButtons() {
		JPanel colorPicker = new JPanel();
		colorPicker.setLayout(new FlowLayout());
		ButtonGroup radioGroup = new ButtonGroup();
		RadioListener radioListener = new RadioListener();
		
		red = new JRadioButton();
		red.addActionListener(radioListener);
		red.setText("RED");
		
		green = new JRadioButton();
		green.addActionListener(radioListener);
		green.setText("GREEN");
		
		blue = new JRadioButton();
		blue.addActionListener(radioListener);
		blue.setText("BLUE");
		
		radioGroup.add(red);
		radioGroup.add(green);
		radioGroup.add(blue);
		
		colorPicker.add(red);
		colorPicker.add(green);
		colorPicker.add(blue);
		frame.add(colorPicker);
	}
	
	// Class to change text of text areas
	class ButtonListener implements ActionListener {
		// Called on button click
		public void actionPerformed (ActionEvent e) {
			int index = new java.util.Random().nextInt(quotes.length);
			quote.setText(quotes[index]);
			author.setText(" - "+authors[index]);
		}
	}
	
	// Class to change text area text color
	class RadioListener implements ActionListener {
		// Called on radio button selection
		public void actionPerformed(ActionEvent e) {
			Color col = Color.red;
			if (green.isSelected()) col = Color.green;
			else if (blue.isSelected()) col = Color.blue;
			
			quote.setForeground(col);
			author.setForeground(col);
		}
	}
	
	// Class to change font size of text
	class SliderListener implements ChangeListener {
		// Called on slider change
		public void stateChanged (ChangeEvent e) {
			int size = fontSize.getValue();
			quoteFont = quoteFont.deriveFont((float) size);
			quote.setFont(quoteFont);
			author.setFont(quoteFont);
		}
	}
}	// end class Quote.java
