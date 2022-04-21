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
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Integer> upgradable = new ArrayList<Integer>();
	private boolean gameOn = false;
	private int currentPlayer;
	private IGameBoardBuilder builder;
	private IGameBoard board;
	private Dice dice;
	private boolean hasMoved = false;

	public GameAdmin(IInputService inputService, IOutputService outputService) {
		this.inputService = inputService;
		this.outputService = outputService;
		this.builder = new GameBoardBuilder();
		this.board = new GameBoard(builder);
		this.dice = new Dice(2);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Integer> getUpgradable() {
		return upgradable;
	}

	public void setUpgradable(ArrayList<Integer> upgradable) {
		this.upgradable = upgradable;
	}

	public boolean getGameOn() {
		return gameOn;
	}

	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}

	public IGameBoard getBoard() {
		return board;
	}

	public void setBoard(IGameBoard board) {
		this.board = board;
	}

	public boolean getHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public int getCurrentPlayerNumber() {
		return getCurrentPlayer().getPlayerNumber();
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * A method to signify the beginning of the game and proceed to set up players
	 * Array
	 * 
	 * @throws Exception
	 */
	public void startGame() throws Exception {
		gameOn = true;
		playerSetUp(numOfPlayers());
		setCurrentPlayer(0);
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
	 * 
	 * @return int : number of Players
	 */
	public int numOfPlayers() throws Exception {
		try {
			// Ask number of players
			int loops = 1;
			while (loops <= 3) {
				String numOfPlayers = this.inputService.GetUserInput("How many players are joining the game? 2-4",
						new String[] { "2", "3", "4" });

				// confirm selection
				boolean check = this.inputService.GetUserConfirmation("Are you sure?");

				// if confirmed, return number of players
				if (check) {
					return Integer.parseInt(numOfPlayers);
				}
				// If not confirmed, repeats the question up to 5 times.
				loops++;
			}
			throw new Exception("You are very indecisive! Let's try again from the start...");

		} catch (Exception exception) {
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
					// Roll a dice to see which player goes first
					int roll = dice.rollDice();
					// If unique name chosen, creates a Player object with defualt starting values.
					Player player = new Player(playerName, i + 1, 0, 1000, 0, roll);
					players.add(player);
				} else {
					// Display error message on repeated name input
					outputService.println("This player name already exists. Please choose a unique name.");
				}
			}
		}

	}

	/**
	 * A method at the beginning of a game to sort the players ArrayList by their
	 * dice rolls.
	 * 
	 * @param players
	 */
	public void sortPlayersByRoll(ArrayList<Player> players) {
		// Uses the CombareByRoll comparator to sort the players ArrayList by their
		// rolls
		players.sort(new CompareByRoll());
		int playerNum = 1;
		// Set player number and display to screen the order of the players
		for (Player player : players) {
			player.setPlayerNumber(playerNum);
			outputService.println(player.getPlayerName() + " rolled a " + player.getRoll()
					+ " so they are now player " + player.getPlayerNumber());
			playerNum++;
		}
	}

	/**
	 * a method to return the current player from the players ArrayList.
	 * 
	 * @return
	 */
	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}

	/**
	 * A method to return the Square Index that the current player is on
	 * 
	 * @return
	 */
	public int getCurrentPlayerPosition() {
		Player player = getCurrentPlayer();
		int position = player.getPlayerPosition();
		return position;
	}

	/**
	 * A method to return the current players details
	 * 
	 * @return
	 */
	public String getCurrentPlayerDetails() {
		Player player = getCurrentPlayer();
		return player.toString();
	}

	

	/**
	 * This method will update the position of the current player on the game board.
	 * It will also update the Player's mana if they pass or land on the Alder
	 * Square It will also
	 * 
	 * @param diceRoll : the total dice roll of the current player
	 */
	public void movePlayer() {
		int diceRoll = dice.rollDice();
		Player player = getCurrentPlayer();
		int position = player.getPlayerPosition();
		int newPosition = position + diceRoll;
		if (newPosition >= 12) {
			player.setMana(player.getMana() + 100);
			newPosition -= 12;
			outputService.println("You have just paid a visit to the Sacred Alder Tree. You have received 100 mana!");
			if (newPosition == 0) {
				player.setMana(player.getMana() + 100);
			}
		}
		outputService.println("You rolled a " + diceRoll + ", landing on square "
				+ board.newsquarePosition(getCurrentPlayerPosition(), diceRoll));
		player.setPlayerPosition(newPosition);
		setHasMoved(true);
	}

	/**
	 * A method to display the current square Ascii art and description. Places a
	 * large gap in the console to effectively clear the screen
	 */
	public void displaySquareDetails() {
		int position = getCurrentPlayerPosition();
		outputService.println("\n\n");
		outputService.println(board.squareAsciiArt(position) + "\n");
		outputService.println(board.squareDescription(position) + "\n");
		int ownerId = board.getSquareOwnerId(getCurrentPlayerPosition());
		if (ownerId != 0) {
			outputService.println("Owned by: " + players.get(ownerId - 1).getPlayerName());
			outputService.println("Mana Contribution: " + board.manaCharge(position));
		} else {
			if (board.squareIsGrassland(getCurrentPlayerPosition())) {
				outputService.println("Currently dry, barren and uninviting");
				outputService.println("Mana needed to rejuvenate the land: " + board.costToUpgrade(position));
			} else {
				outputService.println("This land is already imbued with magical energy and you cannot take posession of it!");
			}
		}
		outputService.println("");
	}

	/**
	 * Checks if a square is owned and returns a boolean
	 * 
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
			outputService.println("Congratulations! You have just turned this arid, vacant land into a beautiful Grassland! You can already feel the fresh air returning!");
		} else {
			outputService.println("Sorry " + player.getPlayerName() + ", but you do not have the mana reserves to turn this vacant land into a Grassland. Perhaps a trip to the Sacred Alder Tree would help?");
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
		if (player == owner) {
			outputService.println("You already own this Grassland. Kick back and admire the scenery! Greenery as far as the eye can see!");
		} else {
			if (buyerMana >= feeOwed) {
				player.setMana(buyerMana - feeOwed);
				owner.setMana(ownerMana + feeOwed);
				outputService.println("You have had to constribute " + feeOwed + " mana to " + owner.getPlayerName()
						+ " for the upkeep of their Grassland! It looks great though!");
			} else {
				outputService.println("Oh no " + player.getPlayerName()
						+ "! You do not have the mana reserves to repay this mana debt!\n All of your Grasslands have been transferred to "
						+ owner.getPlayerName() + ".\nI'm afraid you are out of the game. We hope you had fun though!");
				deactivateCurrentPlayer(board.getSquareOwnerId(getCurrentPlayerPosition()));
				int remaining = 0;
				for (Player active : players) {
					if (active.isActive()) {
						remaining++;
					}
				}
				if (remaining == 1) {
					declareWinner();
				}

			}
		}
	}

	/**
	 * A method to convert the Enum SquareStatus into a more display friendly version
	 * @param type : the SquareStatus Enum value
	 * @return a user friendly string to convey the SquareStatus information
	 */
	public String convertSquareTypeToString(SquareStatus type) {
		String stringType = type.toString();
		if (stringType == "VACANT") {
			stringType = "Vacant";
		} else if (stringType == "GRASSLAND") {
			stringType = "Grassland";
		} else if (stringType == "SEEDLING_FOREST") {
			stringType = "Seedling Forest";
		} else if (stringType == "INTERMEDIATE_FOREST") {
			stringType = "Intermediate Forest";
		} else if (stringType == "ESTABLISHED_FOREST") {
			stringType = "Established Forest";
		} else if (stringType == "WILDLIFE_SANCTUARY") {
			stringType = "Wildlife Sanctuary";
		}

		return stringType;

	}

	/**
	 * A method to convert the SquareStatus int into a String . Useful for checking the status of the square if it were to be upgraded (+1)
	 * @param type : an int of the SquareStatus value
	 * @return a console friendly String of the SquareStatus
	 */
	public String convertSquareTypeToString(int type) {
		String stringType = null;
		if (type == 1) {
			stringType = "Vacant";
		} else if (type == 2) {
			stringType = "Grassland";
		} else if (type == 3) {
			stringType = "Seedling Forest";
		} else if (type == 4) {
			stringType = "Intermediate Forest";
		} else if (type == 5) {
			stringType = "Established Forest";
		} else if (type == 6) {
			stringType = "Wildlife Sanctuary";
		}

		return stringType;

	}

	/**
	 * A method to convert the SquareStatus Enum into an int denoting it's position in the status hierarchy
	 * @param type : the SquareStatus Enum value
	 * @return an int from 1-6 denoting the status of the square according to its natural hierarchy
	 */
	public int convertSquareTypeToInt(SquareStatus type) {
		int squareStatus = 0;
		if (type.toString() == "VACANT") {
			squareStatus = 1;
		} else if (type.toString() == "GRASSLAND") {
			squareStatus = 2;
		} else if (type.toString() == "SEEDLING_FOREST") {
			squareStatus = 3;
		} else if (type.toString() == "INTERMEDIATE_FOREST") {
			squareStatus = 4;
		} else if (type.toString() == "ESTABLISHED_FOREST") {
			squareStatus = 5;
		} else if (type.toString() == "WILDLIFE_SANCTUARY") {
			squareStatus = 6;
		}

		return squareStatus;

	}

	/**
	 * A method to print to console a formatted list of all a players owned Grasslands with their most important statistics
	 */
	public void showAllOwnedGrasslands() {

		ISquare[] squares = board.getSquares();
		int tropical = 0, subtropical = 0, temperate = 0, boreal = 0;
		for (int i = 0; i < squares.length; i++) {
			if (squares[i] instanceof Grassland && ((Grassland) squares[i]).getOwnerId() == getCurrentPlayerNumber()) {
				if (squares[i] instanceof Tropical) {
					if (tropical == 0) {
						outputService.println("TROPICAL REALM:");
					}
					tropical++;
					outputService.println("Tropical realm region " + i + "/2 in this realm. A "
							+ convertSquareTypeToString(board.getSquareType(i)) + " currently costing rival druids "
							+ board.manaCharge(i) + " to land on. It removes " + board.getCO2Modifier(i)
							+ "m^3 of CO2 from the air at the end of each turn!");
				}
				if (squares[i] instanceof Subtropical) {
					if (subtropical == 0) {
						outputService.println("\nSUBTROPICAL REALM:");
					}
					subtropical++;
					outputService.println("Subtropical realm region " + (i - 2) + "/3 in this realm. A "
							+ convertSquareTypeToString(board.getSquareType(i)) + " currently costing rival druids "
							+ board.manaCharge(i) + " to land on. It removes " + board.getCO2Modifier(i)
							+ "m^3 of CO2 from the air at the end of each turn!");
				}
				if (squares[i] instanceof Temperate) {
					if (temperate == 0) {
						outputService.println("\nTEMPERATE REALM:");
					}
					temperate++;
					outputService.println("Temperate realm region " + (i - 6) + "/3 in this realm. A "
							+ convertSquareTypeToString(board.getSquareType(i)) + " currently costing rival druids "
							+ board.manaCharge(i) + " to land on. It removes " + board.getCO2Modifier(i)
							+ "m^3 of CO2 from the air at the end of each turn!");
				}
				if (squares[i] instanceof Boreal) {
					if (boreal == 0) {
						outputService.println("\nBOREAL REALM:");
					}
					boreal++;
					outputService.println("Boreal realm region " + (i - 9) + "/2 in this realm. A "
							+ convertSquareTypeToString(board.getSquareType(i)) + " currently costing rival druids "
							+ board.manaCharge(i) + " to land on. It removes " + board.getCO2Modifier(i)
							+ "m^3 of CO2 from the air at the end of each turn!");
				}
			}
		}

	}

	/**
	 * A method to check if the current Player has any upgradable Grasslands
	 * 
	 * @return true if any upgrades are available, otherwise returns false
	 */
	public boolean canUpgradeGrasslands() {

		boolean canUpgrade = false;
		if (board.getSquareOwnerId(1) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(2) == getCurrentPlayerNumber()) {
			if (board.playerCanUpgrade(getCurrentPlayerNumber(), 1)
					|| board.playerCanUpgrade(getCurrentPlayerNumber(), 2)) {
				canUpgrade = true;
			}
		}

		if (board.getSquareOwnerId(3) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(4) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(5) == getCurrentPlayerNumber()) {
			if (board.playerCanUpgrade(getCurrentPlayerNumber(), 3)
					|| board.playerCanUpgrade(getCurrentPlayerNumber(), 4)
					|| board.playerCanUpgrade(getCurrentPlayerNumber(), 5)) {
				canUpgrade = true;
			}
		}

		if (board.getSquareOwnerId(7) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(8) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(9) == getCurrentPlayerNumber()) {
			if (board.playerCanUpgrade(getCurrentPlayerNumber(), 7)
					|| board.playerCanUpgrade(getCurrentPlayerNumber(), 8)
					|| board.playerCanUpgrade(getCurrentPlayerNumber(), 9)) {
				canUpgrade = true;
			}
		}

		if (board.getSquareOwnerId(10) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(11) == getCurrentPlayerNumber()) {
			if (board.playerCanUpgrade(getCurrentPlayerNumber(), 10)
					|| board.playerCanUpgrade(getCurrentPlayerNumber(), 11)) {
				canUpgrade = true;
			}
		}
		listUpgradableGrasslands();

		return canUpgrade;
	}

	/**
	 * A method to add the square index of upgradable Grasslands to the upgradable
	 * ArryaList
	 */
	public void listUpgradableGrasslands() {

		if (board.getSquareOwnerId(1) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(2) == getCurrentPlayerNumber()) {
			for (int i = 1; i <= 2; i++) {
				if (board.playerCanUpgrade(getCurrentPlayerNumber(), i)
						&& getCurrentPlayer().getMana() > board.costToUpgrade(i)) {
					upgradable.add((Integer) i);
				}
			}
		}
		if (board.getSquareOwnerId(3) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(4) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(5) == getCurrentPlayerNumber()) {
			for (int i = 3; i <= 5; i++) {
				if (board.playerCanUpgrade(getCurrentPlayerNumber(), i)
						&& getCurrentPlayer().getMana() > board.costToUpgrade(i)) {
					upgradable.add((Integer) i);
				}
			}
		}
		if (board.getSquareOwnerId(7) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(8) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(9) == getCurrentPlayerNumber()) {
			for (int i = 7; i <= 9; i++) {
				if (board.playerCanUpgrade(getCurrentPlayerNumber(), i)
						&& getCurrentPlayer().getMana() > board.costToUpgrade(i)) {
					upgradable.add((Integer) i);
				}
			}
		}
		if (board.getSquareOwnerId(10) == getCurrentPlayerNumber()
				&& board.getSquareOwnerId(11) == getCurrentPlayerNumber()) {
			for (int i = 10; i <= 11; i++) {
				if (board.playerCanUpgrade(getCurrentPlayerNumber(), i)
						&& getCurrentPlayer().getMana() > board.costToUpgrade(i)) {
					upgradable.add((Integer) i);
				}
			}
		}

	}

	/**
	 * This method will upgrade a Player's Grassland and deduct the mana from them
	 * appropriately.
	 * 
	 * @param squareIndex
	 */
	public void upgradeOwnedGrassland(int squareIndex) {
		int currentLandingCharge = board.manaCharge(squareIndex);
		int currentCO2Reduction = board.getCO2Modifier(squareIndex);
		String originalType = convertSquareTypeToString(board.getSquareType(squareIndex));
		String newType = originalType;
		if (board.playerCanUpgrade(currentPlayer + 1, squareIndex)) {
			int charge = board.costToUpgrade(squareIndex);
			int balance = getCurrentPlayer().getMana();
			if (balance > charge) {
				getCurrentPlayer().setMana(balance - charge);
				board.upgradeGrassland(squareIndex);
				newType = convertSquareTypeToString(board.getSquareType(squareIndex));

				outputService.println(
						"\nCongratulations! You have upgraded that " + originalType + " to a " + newType + "!");
				outputService.println("The mana charge for landing on this " + newType + " has increased from "
						+ currentLandingCharge + " mana, to " + board.manaCharge(squareIndex) + " mana.\n"
						+ "And its CO2 reduction rating will increase from " + currentCO2Reduction + "m^3 to "
						+ board.getCO2Modifier(squareIndex) + "m^3.\n");
			} else {
				outputService
						.println("\nOh no! You don't have the mana reserves to upgrade that " + originalType + "!");
			}
		}
	}

	/**
	 * A method to end current player turn by moving currentPlayer int by 1. It will
	 * skip any deactivated Players
	 */
	public void endTurn() {
		System.out.printf("That's " + getCurrentPlayer().getPlayerName() + "'s turn over.");
		ArrayList<Grassland> owned = board.getAllPlayerOwnedGrasslands(getCurrentPlayer());
		for (Grassland square : owned) {
			getCurrentPlayer().setCo2(getCurrentPlayer().getCo2() + square.getCo2ReductionRating());
		}

		do {
			currentPlayer++;

			if (currentPlayer >= players.size()) {
				currentPlayer -= players.size();
			}
		} while (!getCurrentPlayer().isActive());
		outputService.println(" Next up it's " + getCurrentPlayer().getPlayerName() + "'s turn!");
		setHasMoved(false);
		upgradable.clear();
	}

	/**
	 * This method will transfer all Grasslands owned by the current Player to
	 * another player. Specifically meant for when a player loses the game and their
	 * owned properties are tranferred to their rival
	 * 
	 * @param newOwnerId
	 */
	public void transferOwnedGrasslands(int newOwnerId) {
		ArrayList<Grassland> owned = board.getAllPlayerOwnedGrasslands(getCurrentPlayer());
		for (Grassland square : owned) {
			square.transferOwnership(newOwnerId);
		}
	}

	/**
	 * This method will calculate the winner(s) of the game and display their names
	 * and CO2 Reduction Ratings with an ASCII art celebration design
	 */
	public void declareWinner() {
		if (gameOn) {
			// Creating arrayList of winners in case of a draw
			ArrayList<Player> winners = new ArrayList<Player>();
			// Adding first player as benchmark score
			winners.add(players.get(0));
			// Setting first players Co2 score as benchmark
			int maxCo2 = players.get(0).getCo2();
			// Creating a boolean to track whether the game has ended in a draw or not
			boolean draw = false;
			// Cycle through all players replacing the winner, or adding to the ArrayList if
			// a draw is found
			for (Player player : players) {
				if (player.getCo2() > maxCo2) {
					maxCo2 = player.getCo2();
					winners.clear();
					winners.add(player);
					draw = false;
				} else if (player.getCo2() == maxCo2 && player.getPlayerNumber() != 1) {
					draw = true;
					winners.add(player);
				}
			}
			// Display to screen who has won with Ascii art celebration.
			outputService.print("                                   .''.       \r\n"
					+ "       .''.      .        *''*    :_\\/_:     . \r\n"
					+ "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n"
					+ "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n"
					+ " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n"
					+ " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n"
					+ "  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n" + "      *            *..*         :\n\n");
			showAllCO2Ratings();
			if (draw) {
				int check = winners.size();
				outputService.print("There is a draw! The winners are ");
				for (Player winner : winners) {
					outputService.print(winner.getPlayerName());
					if(check>2) {
						outputService.print(", ");
						check--;
					}else if (check == 2) {
						outputService.print(" and ");
						check--;
					}
				}
				outputService.println(" with a total CO2 reduction rating of " + winners.get(0).getCo2() + "m^3!\n");
			} else {
				outputService.println("Congratulations " + winners.get(0).getPlayerName()
						+ "! You are the winner with a total CO2 reduction rating of " + winners.get(0).getCo2() + "m^3!");
			}
			players.clear();
			board = new GameBoard(builder);
			endGame();
		}
	}
	
	/**
	 * A method to display all players CO2 stats
	 */
	public void showAllCO2Ratings() {
		outputService.println("Player\t\tCO2 removed\tMana reserves");
		for(Player player : getPlayers()) {
			outputService.println(player.getPlayerName()+":\t\t"+player.getCo2()+"m^3\t\t"+player.getMana());
		}
		outputService.print("\n");
	}

	/**
	 * This method will deactivate a Player so they no longer get a turn
	 */
	public void deactivateCurrentPlayer() {
		getCurrentPlayer().setIsActive(false);
	}

	/**
	 * This method will deactivate a Player so they no longer get a turn and
	 * transfer their properties to the player to which they owe a mana debt.
	 */
	public void deactivateCurrentPlayer(int ownerId) {
		transferOwnedGrasslands(ownerId);
		getCurrentPlayer().setIsActive(false);
	}

}
