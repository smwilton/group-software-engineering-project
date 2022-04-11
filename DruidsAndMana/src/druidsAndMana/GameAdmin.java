/**
 * 
 */
package druidsAndMana;

import java.util.ArrayList;

/**
 * @author Dave
 *
 */
public class GameAdmin {
	
	private IInputService inputService;
	ArrayList<Player> players = new ArrayList<Player>();
	boolean gameOn = false;
	
	public GameAdmin(IInputService inputService) {
		this.inputService = inputService;
	}
	/**
	 * A method to signify the beginning of the game and proceed to set up players Array
	 */
	public void startGame() {
		gameOn = true;
		playerSetUp(numOfPlayers());		
	}
	
	/**
	 * A method to end the game by setting the gameOn boolean variable to off
	 */
	public void endGame() {
		gameOn = false;
	}
	
	/**
	 * A method to check if the game is currently on
	 * @return boolean : true if game is on, otherwise false.
	 */
	public boolean gameIsOn() {
		return gameOn;
	}
	
	/**
	 * This method gets user input for how many Players are joining the game
	 * @return int : number of Players
	 */
	public int numOfPlayers() {
	//Ask number of players
	int loops = 1;
	while(loops<=3) {
	String numOfPlayers = this.inputService.GetUserInput("How many players are joining the game? 1-4", new String[] {"1","2","3","4"});
	
	//confirm selection
	boolean check = this.inputService.GetUserConfirmation("Are you sure?");
	
	//if confirmed, return number of players
	if(check) {
		return Integer.parseInt(numOfPlayers);
	}
	//If not confirmed, repeats the question up to 5 times.
	loops++;
	}
	System.out.println("Number of failed confirmations has reached the limit. Resetting game.");
	return 0;
	}
	
	/**
	 * This method gets all Player names and stores in an ArrayList<String>, then creates a Player object for each name
	 * @param numOfPlayers : an int between 1 and 4
	 * @return ArrayList<String> : An ArrayList of the player names
	 */

	public void playerSetUp(int numOfPlayers) {
		//Create an ArrayList to add Player names to
		ArrayList<String> playerNames = new ArrayList<String>();
		
		//Get Player names
		for (int i=0; i<numOfPlayers; i++) {
			
			boolean nameCheck = false;
			//Check if each Player name is unique and repeat until they are.
			while(!nameCheck) {
			String playerName = this.inputService.GetOpenUserInput("What is the name of player "+(i+1)+"?");
			
			if(!playerNames.contains(playerName)) {
				nameCheck=true;
				playerNames.add(playerName);
				//If unique name chosen, creates a Player object with defualt starting values.
				Player player = new Player(playerName, i+1, 0, 1500, 0);
				players.add(player);
			}else {
				//Display error message on repeated name input
				System.out.println("This player name already exists. Please choose a unique name.");
			}
			}
			}			
		}
		
	
	/**
	 * A method to create a game board at the beginning of the game.
	 * @return new GameBoard object
	 */
	public GameBoard createGameBoard() {
		
		GameBoardBuilder builder = new GameBoardBuilder();
		GameBoard board = new GameBoard(builder);
		return board;		
	}
	
	/**
	 * Checks if a square is owned and returns a boolean
	 * @param board : an instance of a game board
	 * @param squareIndex : the index of the square to check
	 * @return boolean : true if square has an owner, false if it is unowned
	 */
	public boolean checkIfSquareIsOwned(GameBoard board, int squareIndex) {
		if(board.getSquareOwnerId(squareIndex)==null) {
			return false;
		}else {
			return true;
		}
		
	}
	
	/**
	 * This method changes the owner of unowned Grasslands to the purchasing Player and 
	 * deducts the Mana cost from their reserves if they can afford it
	 * @param board
	 * @param squareIndex
	 * @param playerNumber
	 */
	public void buyUnownedGrassland(GameBoard board, int squareIndex, String playerNumber) {
		//Retrieve Player object
		Player player = players.get(Integer.parseInt(playerNumber));
		
		int manaCost = board.costToUpgrade(playerNumber, squareIndex);
		int mana = player.getMana();
		//Check if Player can afford the manaCost and commit the purchase if possible
		if(mana>manaCost) {
		player.setMana(mana-manaCost);
		board.setSquareOwnerId(squareIndex, playerNumber);
		}else {
			System.out.println("Sorry " + player.getPlayerName() + ", but you cannot afford to buy this " + board.getSquareType(squareIndex) + " Grassland");
		}
	}
	
	
	/**
	 * This method will deduct the mana fee from the current player's mana reserves and add it to the mana reserves of the owner
	 * @param board
	 * @param squareIndex
	 * @param playerNumber
	 */
	public void payForLandingOnOwnedGrassland(GameBoard board, int squareIndex, String playerNumber, String ownerPlayerNumber) {
		int feeOwed = board.manaCharge(squareIndex);
		Player player = players.get(Integer.parseInt(playerNumber));
		int buyerMana = player.getMana();
		Player owner = players.get(Integer.parseInt(ownerPlayerNumber));
		int ownerMana = owner.getMana();
		if(buyerMana>feeOwed) {
			player.setMana(buyerMana-feeOwed);
			owner.setMana(ownerMana+feeOwed);
		}else {
			System.out.println("Oh no "+ player.getPlayerName() + "! You cannot afford to pay this mana debt!");
		}
	}
	
	

}
