package clueGame;

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public abstract class Player {

	// variables to hold name of the player, corresponding color,
	// location and said players hand
	private String name;
	private Color color;
	private int row, column;
	private BoardCell location;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> seen = new ArrayList<Card>();

	// constructor to set correct variables
	public Player(String name, Color color, int row, int column) {
		this.setName(name);
		this.setColor(color);
		this.setRow(row);
		this.setColumn(column);
		this.location = Board.getInstance().getCell(row, column);
	}

	// Player disproves a suggestion
	public Card disproveSuggestion(ArrayList<Card> suggestion) {
		ArrayList<Card> disproveCards = new ArrayList<Card>();
		for(Card card: hand) {
			if(suggestion.contains(card)) {
				disproveCards.add(card);
			}
		}

		Random num = new Random();
		if(disproveCards.size() > 0) {
			int index = num.nextInt(disproveCards.size());
			return disproveCards.get(index);
		}else {
			return null;
		}
	}

	public void updateSeen(Card seenCard) {
		if(!seen.contains(seenCard)) {
			seen.add(seenCard);
		}
	}

	// adds cards to array list hand of players
	public void updateHand(Card card) {
		hand.add(card);
	}
	
	public ArrayList<Card> getSeen() {
		return seen;
	}

	// returns each player's hand
	public ArrayList<Card> getHand() {
		return hand;
	}

	// corresponding setters and getters
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public BoardCell getLocation() {
		return location;
	}

	public void setLocation(BoardCell location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
