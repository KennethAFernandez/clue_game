package tests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import clueGame.Board;

public class ComputerAITest {

	// creates board
	private static Board board;

	@BeforeAll
	public static void setUp() {
		board = Board.getInstance();
		board.setConfigFiles("ClueLayout.csv", "ClueSetup.txt");
		board.initialize();
	}
	
	
	@Test
	public void testSelectTargets() {
		
	}
	
	@Test
	public void createSuggestion() {
		
	}
	
}