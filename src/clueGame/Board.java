package clueGame;


// Holds game board
public class Board {

	
	 // variable and methods used for singleton pattern
	private static Board theInstance = new Board();
	
	// constructor is private to ensure only one can be created
	private Board() {
		super() ;
	}
	
	// this method returns the only Board
	public static Board getInstance() {
		return theInstance;
	}
	
	// initialize the board (since we are using singleton pattern)
	public void initialize() {
	}
	
	public void setConfigFiles(String string, String string2) {
		
	}
	
	public void loadSetupConfig() {
		
	}
	
	public void loadLayoutConfig() {
		
	}
	
	public Object getRoom(char c) {
		return null;
	}
	
	public Object getName() {
		return null;
	}
	
	public int getNumRows() {
		return 0;
	}
	
	public BoardCell getCell(int i, int j) {
		BoardCell cell = new BoardCell();
		return cell;
	}
	
	public int getNumColumns() {
		return 0;
	}
	
	public Room getRoom(BoardCell cell) {
		return null;
	}
	
	public int getAmountRooms() {
		return 0;
	}
	public int getAmountDoors(){
		return 0;
	}

	
}