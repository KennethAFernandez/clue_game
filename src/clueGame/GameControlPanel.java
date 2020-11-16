package clueGame;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class GameControlPanel extends JPanel{
	
	// strings to hold value names
	String theGuess, guessResult, turnName;
	// various variables to hold textfields and buttons
	private JButton next, accuse;
	private JTextField guess, result, turn, roll;
	
	int rollNum;
	int counter = 0;
	
	Player player;
	Color color;
	
	private static Board board;

	
	// sets various panels and adds them to the main panel
	public GameControlPanel() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 0));
		
		JPanel nameAndDie = createTurnAndRoll();
		mainPanel.add(nameAndDie);
		
		JPanel buttons = createButtons();
		mainPanel.add(buttons);
		
		JPanel guess = createGuess();
		mainPanel.add(guess);
		
		JPanel result = createResult();
		mainPanel.add(result);
		
		add(mainPanel);
	}
	
	// creates the needed panels and labels, and passes an instance variable
	// through for updating purposes. then adds everything to the panel.
	public JPanel createTurnAndRoll() {
		
		JPanel panel = new JPanel();
		JPanel whoseTurnPanel = new JPanel();
		JPanel rollPanel = new JPanel();
		
		JLabel whoseTurn = new JLabel("Whose turn?");
		JLabel theRoll = new JLabel("Roll:");
		
		turn = new JTextField(turnName);
		roll = new JTextField(rollNum);
		
		panel.setLayout(new GridLayout(2, 0));
		whoseTurnPanel.setLayout(new GridLayout(1, 2));
		rollPanel.setLayout(new GridLayout(1, 2));
		
		whoseTurnPanel.add(whoseTurn);
		whoseTurnPanel.add(turn);
		rollPanel.add(theRoll);
		rollPanel.add(roll);
	
		panel.add(whoseTurnPanel, BorderLayout.EAST);
		panel.add(rollPanel, BorderLayout.WEST);
		panel.setBorder(new TitledBorder (new EtchedBorder()));
		panel.setBackground(Color.LIGHT_GRAY);
		
		return panel;
	}
	
	// creates the needed panels and labels, and passes an instance variable
	// through for updating purposes. then adds everything to the panel.
	public JPanel createButtons() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		accuse = new JButton("Make Accusation");
		next = new JButton("NEXT!");
		next.addActionListener(new ButtonListener());
		panel.add(accuse);
		panel.add(next);
		
		panel.setBorder(new TitledBorder (new EtchedBorder()));
		panel.setBackground(Color.LIGHT_GRAY);
		
		return panel;		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(counter == 6) {
				counter = 0;
			}
			player = board.players.get(board.gameCharacters.get(counter).getCardName());
			turn.setText(player.getName());
			turn.setBackground(player.getColor());
			rollNum = (int) (Math.random() * 6) + 1;
			roll.setText(String.valueOf(rollNum));
			counter++;
		}
	}
	
	// creates the needed panels and labels, and passes an instance variable
	// through for updating purposes. then adds everything to the panel.
	public JPanel createGuess() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		
		guess = new JTextField(theGuess, 25);
		guess.setBorder(BorderFactory.createTitledBorder("Guess"));
		
		panel.add(guess, BorderLayout.WEST);
		panel.setBorder(new TitledBorder (new EtchedBorder()));
		panel.setBackground(Color.GRAY);
		return panel;

	}
	
	// creates the needed panels and labels, and passes an instance variable
	// through for updating purposes. then adds everything to the panel.
	public JPanel createResult() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		
		result = new JTextField(guessResult, 25);
		result.setBorder(BorderFactory.createTitledBorder("Guess Result!"));
		
		panel.add(result);
		panel.setBorder(new TitledBorder (new EtchedBorder()));
		panel.setBackground(Color.GRAY);
		return panel;
	}
	
	
	// update display function that updates the text boxes
	public void updateDisplay() {
		guess.setText(getGuess());
		result.setText(getResult());
		turn.setText(turnName);
		turn.setBackground(color);
		roll.setText(Integer.toString(rollNum));
	}

	// setters and getters
	private void setGuess(String string) {
		this.theGuess = string;
	}
	
	private void setGuessResult(String string) {
		this.guessResult = string;
	}
	
	void setTurn(Player computerPlayer, int i) {
		this.player = computerPlayer;
		this.turnName = computerPlayer.getName();
		this.rollNum = i;
		this.color = computerPlayer.getColor();
	}
	
	public String getGuess() {
		return theGuess;
	}
	
	public String getResult() {
		return guessResult;
	}
	public int getRoll() {
		return rollNum;
	}
	

	public static void main(String[] args) {
		board = Board.getInstance();
		board.setConfigFiles("ClueLayout.csv", "ClueSetup.txt");
		board.initialize();
		GameControlPanel panel = new GameControlPanel();  // create the panel
		JFrame frame = new JFrame();  // create the frame
		frame.setContentPane(panel); // put the panel in the frame
		frame.setSize(750, 180);  // size the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allow it to close
		frame.setVisible(true); // make it visible
		// test filling in the data
		
		panel.setTurn(new ComputerPlayer( "Col. Mustard", Color.ORANGE, 6, 5), 5);
		panel.setGuess( "I have no guess!");
		panel.setGuessResult( "So you have nothing?");
		panel.updateDisplay();
	}
}
