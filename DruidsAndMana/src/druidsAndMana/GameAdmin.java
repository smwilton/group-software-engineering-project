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
	private IOutputService outputService;
	ArrayList<Player> players = new ArrayList<Player>();
	boolean gameOn = false;
	int currentPlayer;
	GameBoardBuilder builder;
	IGameBoard board;
	Dice dice1, dice2;

	public GameAdmin(IInputService inputService, IOutputService outputService, IGameBoard board) {
		this.inputService = inputService;
		this.outputService = outputService;
		this.board = board;
	}

	/**
	 * Returns the IGameBoard instance
	 * @return
	 */
	public IGameBoard getGameBoard() {
		return board;
	}
	
	/**
	 * A method to signify the beginning of the game and proceed to set up players
	 * Array
	 * @throws Exception 
	 */
	public void startGame() throws Exception {
		gameOn = true;
		playerSetUp(numOfPlayers());
		currentPlayer=0;
	}

	/**
	 * A method to end the game by setting the gameOn boolean variable to off
	 */
	public void endGame() {
		gameOn = false;
	}

	/**
	 * A method to check if the game is currently on
	 * 
	 * @return boolean : true if game is on, otherwise false.
	 */
	public boolean gameIsOn() {
		return gameOn;
	}

	/**
	 * This method gets user input for how many Players are joining the game
	 * @return int : number of Players
	 */
	public int numOfPlayers() throws Exception{
		try {
			//Ask number of players
			int loops = 1;
			while(loops<=3) {
				String numOfPlayers = this.inputService.GetUserInput("How many players are joining the game? 2-4", new String[] {"2","3","4"});
				
				//confirm selection
				boolean check = this.inputService.GetUserConfirmation("Are you sure?");
				
	
				//if confirmed, return number of players
				if(check) {
					return Integer.parseInt(numOfPlayers);
				}
				//If not confirmed, repeats the question up to 5 times.
				loops++;
			}
			throw new Exception("Number of failed confirmations has reached the limit. Resetting game.");
			
		}catch(Exception exception){
			outputService.println(exception.getMessage());
			endGame();
			return 0;
			
		}
	}

	/**
	 * This method gets all Player names and stores in an ArrayList<String>, then
	 * creates a Player object for each name
	 * 
	 * @param numOfPlayers : an int between 1 and 4
	 * @return ArrayList<String> : An ArrayList of the player names
	 */

	public void playerSetUp(int numOfPlayers) {
		// Create an ArrayList to add Player names to
		ArrayList<String> playerNames = new ArrayList<String>();

		// Get Player names
		for (int i = 0; i < numOfPlayers; i++) {

			boolean nameCheck = false;
			// Check if each Player name is unique and repeat until they are.
			while (!nameCheck) {
				
				String playerName = this.inputService.GetOpenUserInput("What is the name of player " + (i + 1) + "?");

				if (!playerNames.contains(playerName)) {
					nameCheck = true;
					playerNames.add(playerName);
					// If unique name chosen, creates a Player object with defualt starting values.
					Player player = new Player(playerName, i + 1, 0, 1500, 0);
					players.add(player);
				} else {
					// Display error message on repeated name input
					outputService.println("This player name already exists. Please choose a unique name.");
				}
			}
		}
	}
	
	/**
	 * a method to return the current player from the players ArrayList.
	 * @return
	 */
	public Player getCurrentPlayer() {
		Player player = players.get(currentPlayer);
		return player;
	}
	/**
	 * A method to return the Square Index that the current player is on
	 * @return
	 */
	public int getCurrentPlayerPosition() {
		Player player = getCurrentPlayer();
		int position = player.getPlayerPosition();
		return position;
	}
	
	/**
	 * A method to return the current players details
	 * @return
	 */
	public String getCurrentPlayerDetails() {
		Player player = getCurrentPlayer();
		return player.toString();
	}
	
	public int roll() {
		int total=0;
		Dice dice = new Dice(2);
		total+=dice.rollDice();
		return total;
	}
	
	/**
	 * This method will update the position of the current player on the game board.
	 * It will also update the Player's mana if they pass or land on the Alder Square	
	 * It will also
	 * @param diceRoll : the total dice roll of the current player
	 */
	public void movePlayer(int diceRoll) {
		Player player = getCurrentPlayer();
		int position = player.getPlayerPosition();
		int newPosition = position+diceRoll;
		if(newPosition>=12) {
			player.setMana(player.getMana()+100);
			newPosition -=12;
			if(newPosition==0) {
				player.setMana(player.getMana()+100);
			}
		}
		player.setPlayerPosition(newPosition);
	}
	
	/**
	 * A method to display the current square Ascii art and description
	 */
	public void displaySquareDetails() {
		int position = getCurrentPlayerPosition();
		outputService.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		outputService.println(board.squareAsciiArt(position)+"\n");
		outputService.println(board.squareDescription(position)+"\n");
		int ownerId = board.getSquareOwnerId(getCurrentPlayerPosition());
		if (ownerId!=0) {
			outputService.println("Owned by: "+players.get(ownerId-1).getPlayerName());
			outputService.println("Mana Charge: "+ board.manaCharge(position));
		}else {
			outputService.println("Currently Unowned");
			outputService.println("Cost to buy: "+ board.costToUpgrade(position));
		}
		outputService.println("");
	}

	/**
	 * Checks if a square is owned and returns a boolean
	 * 
	 * @param board       : an instance of a game board
	 * @param squareIndex : the index of the square to check
	 * @return boolean : true if square has an owner, false if it is unowned
	 */
	public boolean isSquareOwned(IGameBoard board, int squareIndex) {
		if (board.getSquareOwnerId(squareIndex) == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * This method changes the owner of unowned Grasslands to the purchasing Player
	 * and deducts the Mana cost from their reserves if they can afford it
	 * 
	 * @param board
	 * @param squareIndex
	 * @param playerNumber
	 */
	public void buyUnownedGrassland(IGameBoard board, int squareIndex, int playerNumber) {
		// Retrieve Player object
		Player player = players.get(playerNumber-1);

		int manaCost = board.costToUpgrade(squareIndex);
		int mana = player.getMana();
		// Check if Player can afford the manaCost and commit the purchase if possible
		if (mana > manaCost) {
			player.setMana(mana - manaCost);
			board.setSquareOwnerId(squareIndex, playerNumber);
		} else {
			outputService.println("Sorry " + player.getPlayerName() + ", but you cannot afford to buy this "
					+ board.getSquareType(squareIndex) + " Grassland");
		}
	}

	/**
	 * This method will deduct the mana fee from the current player's mana reserves
	 * and add it to the mana reserves of the owner
	 * 
	 * @param board
	 * @param squareIndex
	 * @param playerNumber
	 */
	public void payForLandingOnOwnedGrassland(IGameBoard board, int squareIndex, int playerNumber,
			int ownerPlayerNumber) {
		int feeOwed = board.manaCharge(squareIndex);
		Player player = players.get(playerNumber-1);
		int buyerMana = player.getMana();
		Player owner = players.get(ownerPlayerNumber-1);
		int ownerMana = owner.getMana();
		if (buyerMana > feeOwed) {
			player.setMana(buyerMana - feeOwed);
			owner.setMana(ownerMana + feeOwed);
		} else {
			outputService.println("Oh no " + player.getPlayerName() + "! You cannot afford to pay this mana debt!");
		}
	}
	
	/**
	 * A method to end current player turn by moving currentPlayer int by 1.
	 */
	public void endTurn() {
		System.out.printf("That's "+getCurrentPlayer().getPlayerName()+"'s turn over.");
		ArrayList<Grassland> owned = board.getAllPlayerOwnedGrasslands(getCurrentPlayer());
		for (Grassland square: owned) {
			getCurrentPlayer().setCo2(getCurrentPlayer().getCo2()+square.getCo2ImpactRating());
		}
		currentPlayer++;
		if(currentPlayer>=players.size()) {
			currentPlayer-=players.size();
		}
		outputService.println(" Next up it's "+getCurrentPlayer().getPlayerName()+"'s turn!");
	}
	
	public void transferOwnedGrasslands(int newOwnerId) {
		ArrayList<Grassland> owned = board.getAllPlayerOwnedGrasslands(getCurrentPlayer());
		for (Grassland square: owned) {
			square.transferOwnership(newOwnerId);
		}
	}
	
	/**
	 * This method will calculate the winner(s) of the game and display their names and CO2 Impact Ratings with an ASCII art celebration design
	 */
	public void declareWinner() {
		//Creating arrayList of winners in case of a draw
		ArrayList<Player> winners = new ArrayList<Player>();
		//Adding first player as benchmark score
		winners.add(players.get(0));
		//Setting first players Co2 score as benchmark
		int maxCo2= players.get(0).getCo2();
		//Creating a boolean to track whether the game has ended in a draw or not
		boolean draw=false;
		//Cycle through all players replacing the winner, or adding to the ArrayList if a draw is found 
		for (Player player : players) {
			if(player.getCo2()>maxCo2) {
				maxCo2 = player.getCo2();
				winners.clear();
				winners.add(player);
				draw=false;
			}else if(player.getCo2()==maxCo2 && player.getPlayerNumber()!=1) {
				draw=true;
				winners.add(player);
			}
		}
		//Display to screen who has won with Ascii art celebration.
		outputService.print("                                   .''.       \r\n"
				+ "       .''.      .        *''*    :_\\/_:     . \r\n"
				+ "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n"
				+ "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n"
				+ " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n"
				+ " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n"
				+ "  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n"
				+ "      *            *..*         :\n\n");
		if(draw) {
			int check = winners.size();
			outputService.println("There is a draw! The winners are:\n");
			for(Player winner:winners) {
				outputService.print(winner.getPlayerName()+" ");
				if(check>1) {
					outputService.print("and ");
					check--;
				}
			}
			outputService.print("with a total CO2 impact rating of "+winners.get(0).getCo2()+"m^3!");
		}else {
			outputService.println("Congratulations "+winners.get(0).getPlayerName()+"! You are the winner with a total CO2 impact rating of "+winners.get(0).getCo2()+"m^3!");
		}
		
		
		
	}

	
	/**
	 * Method to remove the current player from the list of players
	 */
	public void removeCurrentPlayer() {
		players.remove(getCurrentPlayer());
	}

}
