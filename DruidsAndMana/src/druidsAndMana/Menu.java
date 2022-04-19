package druidsAndMana;

public class Menu {

	private GameAdmin admin;
	private IInputService inputService;
	private IOutputService outputService;
	private Rules rules;

	public Menu(IInputService inputService, IOutputService outputService) {
		this.admin = new GameAdmin(inputService, outputService);
		this.inputService = inputService;
		this.outputService = outputService;
		this.rules = new Rules();
	}

	/**
	 * A single method, fully responsive menu. This menu assesses what actions a Player is able to perform from their given position
	 * @throws Exception
	 */
	public void displayMenu() throws Exception {
		int option = 1;
		int playerChoice, start = -1, upgrade = -1, move = -1, purchase = -1, stats = -1, owned = -1, endTurn = -1,
				showRules = -1, endGame = -1;
		int highestOptionNumber = 1;
		
		//Check to see if game has started. If not, display initial Start game menu.
		
		if (!admin.gameIsOn()) {
			outputService.println("Welcome to Druids and Mana!\n");
			outputService.println("Please choose from the following options:");
			outputService.println(option + ") Start Game");
			start = option;
			highestOptionNumber = option;
			option++;
		} else {

			outputService.println("\n" + admin.getCurrentPlayer().getPlayerName() + ", your current options are: ");
			
			//Check if player has already moved. If not, offer the option to roll dice and move
			
			if (!admin.getHasMoved()) {
				outputService.println(option + ") Roll Dice and Move");
				move = option;
				highestOptionNumber = option;
				option++;
			}

			//Check if the new square is owned or not and offer the Player the option to buy if it is still vacant
			
			if (admin.getHasMoved() && admin.getBoard().squareIsGrassland(admin.getCurrentPlayerPosition())
					&& !admin.isSquareOwned(admin.getCurrentPlayerPosition()) 
					&& admin.getCurrentPlayer().getMana()>=admin.getBoard().costToUpgrade(admin.getCurrentPlayerPosition())) {
				outputService.println(option + ") Rejuvenate arid, vacant land");
				purchase = option;
				highestOptionNumber = option;
				option++;
			}
			
			//Check if the Player has land that can be upgraded and if they can afford to so. If so, give them the option
			
			if (admin.canUpgradeGrasslands() && !admin.getUpgradable().isEmpty()) {
				admin.getUpgradable().clear();
				outputService.println(option + ") Plant a Forest on Grasslands");
				upgrade = option;
				highestOptionNumber = option;
				option++;
			}
			
			//Always offer the option to see current player stats.

			outputService.println(option + ") Show current mana and CO2 stats");
			stats = option;
			highestOptionNumber = option;
			option++;
			
			//If the Player owns any Grasslands, offer them the option to view them all.

			if (!admin.getBoard().getAllPlayerOwnedGrasslands(admin.getCurrentPlayer()).isEmpty()) {
				outputService.println(option + ") Show all owned Grasslands");
				owned = option;
				highestOptionNumber = option;
				option++;
			}
			
			//Offer the option to end turn, provided the player has moved already.

			if (admin.getHasMoved()) {
				outputService.println(option + ") End Turn");
				endTurn = option;
				highestOptionNumber = option;
				option++;
			}
		}
		
		//Always give the option to view the rules
		
		outputService.println(option + ") View Rules");
		showRules = option;
		highestOptionNumber = option;
		option++;
		
		//Always give the option to end the game
		
		outputService.println(option + ") End Game");
		endGame = option;
		highestOptionNumber = option;
		option++;

		playerChoice = getPlayerChoice(highestOptionNumber);

		//Long if-else statement to process the players choice, allowing for all the possible options they were presented with
		
		if (playerChoice == start) {
			admin.startGame();
			displayMenu();
		} else if (playerChoice == upgrade) {
			admin.listUpgradableGrasslands();
			getUpgradableChoice();
			displayMenu();
		} else if (playerChoice == move) {
			admin.movePlayer();
			admin.displaySquareDetails();
			if (admin.getBoard().getSquareOwnerId(admin.getCurrentPlayerPosition()) != 0) {
				admin.payForLandingOnOwnedGrassland();
			}
			displayMenu();
		} else if (playerChoice == purchase) {
			inputService.GetUserConfirmation("Are you sure you want to invest "
					+ admin.getBoard().costToUpgrade(admin.getCurrentPlayerPosition()) + " mana to rejuvenate this arid land?");
			admin.buyUnownedGrassland();
			displayMenu();
		} else if (playerChoice == stats) {
			admin.getCurrentPlayer().printStats();
			displayMenu();
		} else if (playerChoice == owned) {
			admin.showAllOwnedGrasslands();
			displayMenu();
		} else if (playerChoice == endTurn) {
			if (inputService.GetUserConfirmation("Are you sure you want to end your turn?")) {
				admin.endTurn();
			}
			displayMenu();
		} else if (playerChoice == showRules) {
			outputService.println(rules.displayRules());
			displayMenu();
		} else if (playerChoice == endGame) {
			String prompt;
			if (admin.getPlayers().isEmpty()) {
				prompt = "Are you sure you want to end the game?";
			} else {
				prompt = "Are you sure you want to end the game and declare a winner?";
			}
			if (inputService.GetUserConfirmation(prompt)) {
				admin.declareWinner();
				if (inputService.GetUserConfirmation("Would you like to return to the main menu?")) {
					displayMenu();
				}
			} else {
				displayMenu();
			}
		}

	}

	/**
	 * This method takes an int and creates an int[] of sequential numbers from 1 up to that int. These are then fed into the inputService as the specific options for the user.
	 * A selection outside this int range will be rejected until a suitable int is provided
	 * @param highestOptionNumber : an int taken from the menu class of how many options the user has
	 * @return int : the users chosen option number
	 */
	public int getPlayerChoice(int highestOptionNumber) {
		int chosen;

		// Create int[] of available options for Player
		int[] choices = new int[highestOptionNumber];
		for (int i = 1; i <= highestOptionNumber; i++) {
			choices[i - 1] = i;
		}

		// Ask for Player input
		chosen = inputService.GetUserIntInput("Enter your menu choice: ", choices);

		return chosen;

	}

	/**
	 * A method to display all of the available upgradable regions to a Player. They can then select which option numbe they wish to take and the upgrade is completed
	 * and mana ammended appropriately
	 */
	public void getUpgradableChoice() {
		int upgradableOption = 1;
		int chosenGrassland;
		outputService.println("Where would you like to plant the forest?");

		for (int i : admin.getUpgradable()) {
			if (i == 1 || i == 2) {
				outputService.println(upgradableOption + ") On Tropical Grassland region" + i + "/2, transforming it from a "
						+ admin.convertSquareTypeToString(admin.getBoard().getSquareType(i)) + " to a "+ 
						admin.convertSquareTypeToString(admin.convertSquareTypeToInt(admin.getBoard().getSquareType(i))+1) 
						+", for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}
			if (i >= 3 && i <= 5) {
				outputService.println(upgradableOption + ") On Subtropical Grassland region" + (i-2) + "/3, transforming it from a "
						+ admin.convertSquareTypeToString(admin.getBoard().getSquareType(i)) + " to a "+ 
						admin.convertSquareTypeToString(admin.convertSquareTypeToInt(admin.getBoard().getSquareType(i))+1) 
						+", for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}
			if (i >= 7 && i <= 9) {
				outputService.println(upgradableOption + ") On Temperate Grassland region" + (i-6) + "/3, transforming it from a "
						+ admin.convertSquareTypeToString(admin.getBoard().getSquareType(i)) + " to a "+ 
						admin.convertSquareTypeToString(admin.convertSquareTypeToInt(admin.getBoard().getSquareType(i))+1) 
						+", for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}
			if (i == 10 || i == 11) {
				outputService.println(upgradableOption + ") On Boreal Grassland region" + (i-9) + "/2, transforming it from a "
						+ admin.convertSquareTypeToString(admin.getBoard().getSquareType(i)) + " to a "+ 
						admin.convertSquareTypeToString(admin.convertSquareTypeToInt(admin.getBoard().getSquareType(i))+1) 
						+", for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}

		}
		outputService.println("Or enter 0 to cancel upgrading.");
		int playerChoice = inputService.GetUserIntInput("Enter your choice:",
				createArray(upgradableOption-1)) - 1;
		if (playerChoice != -1) {
			chosenGrassland = admin.getUpgradable().get(playerChoice);
			admin.upgradeOwnedGrassland(chosenGrassland);
		}
		admin.getUpgradable().clear();
	}
	
	/**
	 * A method to create an array of sequential ints, used in the inputServ
	 * @param numOfValues
	 * @return
	 */
	public int[] createArray(int numOfValues) {
		int[] array = new int[numOfValues+1];
		for (int i=numOfValues; i>=0; i--) {
			array[i] = i;
		}
		return array;
		
	}

}
