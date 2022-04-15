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
	public ArrayList<Player> players = new ArrayList<Player>();
	public boolean gameOn = false;
	public int currentPlayer;
	public GameBoardBuilder builder;
	public IGameBoard board;
	private Dice dice = new Dice(2);
	public boolean hasMoved = false;

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
		sortPlayersByRoll(players);
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
					//Roll a dice to see which player goes first
					int roll = roll();
					// If unique name chosen, creates a Player object with defualt starting values.
					Player player = new Player(playerName,i+1, 0, 1500, 0, roll);
					players.add(player);
				} else {
					// Display error message on repeated name input
					outputService.println("This player name already exists. Please choose a unique name.");
				}
			}
		}
		
		
	}
	
	/**
	 * A method at the beginning of a game to sort the players ArrayList by their dice rolls.
	 * @param players
	 */
	public void sortPlayersByRoll(ArrayList<Player> players) {
		//Uses the CombareByRoll comparator to sort the players ArrayList by their rolls
				players.sort(new CompareByRoll());
				int playerNum = 1;
				//Set player number and display to screen the order of the players
				for (Player player : players) {
					player.setPlayerNumber(playerNum);
					outputService.println("Player " + player.getPlayerName()+ " rolled a "+player.getRoll()+ " so they are now player "+player.getPlayerNumber());
					playerNum++;
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
	
	/**
	 * This method rolls the dice and returns the total of all the requested dice.
	 * @return
	 */
	public int roll() {
		int total=0;
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
				outputService.println("You have just paid a visit to the Sacred Alder Tree. You have received 100 mana");
			}
		}
		outputService.println("You rolled a "+diceRoll+", landing on square "+board.newsquarePosition(getCurrentPlayerPosition(), diceRoll));
		player.setPlayerPosition(newPosition);
		hasMoved = true;
	}
	
	/**
	 * A method to display the current square Ascii art and description. Places a large gap in the console to effectively clear the screen
	 */
	public void displaySquareDetails() {
		int position = getCurrentPlayerPosition();
		outputService.println("\n\n");
		outputService.println(board.squareAsciiArt(position)+"\n");
		outputService.println(board.squareDescription(position)+"\n");
		int ownerId = board.getSquareOwnerId(getCurrentPlayerPosition());
		if (ownerId!=0) {
			outputService.println("Owned by: "+players.get(ownerId-1).getPlayerName());
			outputService.println("Mana Charge: "+ board.manaCharge(position));
		}else {
			if(board.squareIsGrassland(getCurrentPlayerPosition())) {
			outputService.println("Currently Unowned");
			outputService.println("Cost to buy: "+ board.costToUpgrade(position));
			}else {
				outputService.println("This square cannot be purchased");
			}
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
	public boolean isSquareOwned(int squareIndex) {
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
	public void buyUnownedGrassland() {
		// Retrieve Player object
		Player player = getCurrentPlayer();
		int playerNumber = player.getPlayerNumber();

		int manaCost = board.costToUpgrade(getCurrentPlayerPosition());
		int mana = player.getMana();
		// Check if Player can afford the manaCost and commit the purchase if possible
		if (mana > manaCost) {
			player.setMana(mana - manaCost);
			board.setSquareOwnerId(getCurrentPlayerPosition(), playerNumber);
			outputService.println("Congratulations! You have just bought this beautiful Grassland!");
		} else {
			outputService.println("Sorry " + player.getPlayerName() + ", but you cannot afford to buy this "
					+ board.getSquareType(getCurrentPlayerPosition()) + " Grassland");
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
	public void payForLandingOnOwnedGrassland() {
		int feeOwed = board.manaCharge(getCurrentPlayerPosition());
		Player player = getCurrentPlayer();
		int buyerMana = player.getMana();
		Player owner = players.get(board.getSquareOwnerId(getCurrentPlayerPosition())-1);
		int ownerMana = owner.getMana();
		if (buyerMana >= feeOwed) {
			player.setMana(buyerMana - feeOwed);
			owner.setMana(ownerMana + feeOwed);
			outputService.println("You have had to donate "+feeOwed+" mana to "+owner.getPlayerName()+" for landing on their Grassland!");
		} else {
			outputService.println("Oh no " + player.getPlayerName() + "! You cannot afford to pay this mana debt!");
			deactivateCurrentPlayer(board.getSquareOwnerId(getCurrentPlayerPosition()));
		}
	}
	
	/**
	 * A method to check if the current Player has any upgradable Grasslands
	 * @return true if any upgrades are available, otherwise returns false
	 */
	public boolean canUpgradeGrasslands() {
		boolean canUpgrade = false;
		//ArrayList<Grassland> owned = board.getAllPlayerOwnedGrasslands(getCurrentPlayer());
		for(int i=0;i<12;i++) {
			if(board.playerCanUpgrade(currentPlayer+1, i)) {
				canUpgrade = true;
			}
		}
		return canUpgrade;
	}
	
	/**
	 * This method will upgrade a Player's Grassland and deduct the mana from them appropriately.
	 * @param squareIndex
	 */
	public void upgradeOwnedGrassland(int squareIndex) {
		if(board.playerCanUpgrade(currentPlayer+1, squareIndex)) {
			int charge = board.costToUpgrade(squareIndex);
			int balance = getCurrentPlayer().getMana();
			if(balance>charge) {
				getCurrentPlayer().setMana(balance-charge);
				board.upgradeGrassland(squareIndex);
			}
		}
	}
	
	/**
	 * A method to end current player turn by moving currentPlayer int by 1. It will skip any deactivated Players
	 */
	public void endTurn() {
		System.out.printf("That's "+getCurrentPlayer().getPlayerName()+"'s turn over.");
		ArrayList<Grassland> owned = board.getAllPlayerOwnedGrasslands(getCurrentPlayer());
		for (Grassland square: owned) {
			getCurrentPlayer().setCo2(getCurrentPlayer().getCo2()+square.getCo2ImpactRating());
		}
		
		do {
		currentPlayer++;
		
		
		if(currentPlayer>=players.size()) {
			currentPlayer-=players.size();
		}
		}while(!getCurrentPlayer().isActive());
		outputService.println(" Next up it's "+getCurrentPlayer().getPlayerName()+"'s turn!");
		hasMoved = false;
	}
	
	/**
	 * This method will transfer all Grasslands owned by the current Player to another player.
	 * Specifically meant for when a player loses the game and their owned properties are tranferred to their rival
	 * @param newOwnerId
	 */
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
	 * This method will deactivate a Player so they no longer get a turn
	 */
	public void deactivateCurrentPlayer() {
		getCurrentPlayer().setIsActive(false);
	}
	
	/**
	 * This method will deactivate a Player so they no longer get a turn and transfer their properties to the player to which they owe a mana debt.
	 */
	public void deactivateCurrentPlayer(int ownerId) {
		transferOwnedGrasslands(ownerId);
		getCurrentPlayer().setIsActive(false);
	}
	
	

}
