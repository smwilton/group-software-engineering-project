package druidsAndMana;

public class Menu {

	GameAdmin admin;
	private IInputService inputService;
	private IOutputService outputService;
	private Rules rules = new Rules(inputService);

	public Menu(GameAdmin admin, IInputService inputService, IOutputService outputService) {
		this.admin = admin;
		this.inputService = inputService;
		this.outputService = outputService;
	}

	public void displayMenu() throws Exception {
		int option = 1;
		int playerChoice, start = -1, upgrade = -1, move = -1, purchase = -1, stats = -1, owned = -1, endTurn = -1,
				showRules = -1, endGame = -1;
		int highestOptionNumber = 1;
		// outputService.clearConsole();

		if (!admin.gameIsOn()) {
			outputService.println("Welcome to Druids and Mana!");
			outputService.println("Please choose from the following options:");
			outputService.println(option + ") Start Game");
			start = option;
			highestOptionNumber = option;
			option++;
		} else {

			outputService.println("\n" + admin.getCurrentPlayer().getPlayerName() + ", your current options are: ");

			if (admin.canUpgradeGrasslands()) {
				outputService.println(option + ") Plant a Forest on Grasslands");
				upgrade = option;
				highestOptionNumber = option;
				option++;
			}

			if (!admin.getHasMoved()) {
				outputService.println(option + ") Roll Dice and Move");
				move = option;
				highestOptionNumber = option;
				option++;
			}

			if (admin.getHasMoved() && admin.getBoard().squareIsGrassland(admin.getCurrentPlayerPosition())
					&& !admin.isSquareOwned(admin.getCurrentPlayerPosition())) {
				outputService.println(option + ") Buy Grassland");
				purchase = option;
				highestOptionNumber = option;
				option++;
			}

			outputService.println(option + ") Show current mana and CO2 stats");
			stats = option;
			highestOptionNumber = option;
			option++;
			
			if (!admin.getBoard().getAllPlayerOwnedGrasslands(admin.getCurrentPlayer()).isEmpty()) {
				outputService.println(option + ") Show all owned Grasslands");
				owned = option;
				highestOptionNumber = option;
				option++;
			}

			if (admin.getHasMoved()) {
				outputService.println(option + ") End Turn");
				endTurn = option;
				highestOptionNumber = option;
				option++;
			}
		}
		outputService.println(option + ") View Rules");
		showRules = option;
		highestOptionNumber = option;
		option++;
		outputService.println(option + ") End Game");
		endGame = option;
		highestOptionNumber = option;
		option++;

		playerChoice = getPlayerChoice(highestOptionNumber);

		if (playerChoice == start) {
			admin.startGame();
			displayMenu();
		} else if (playerChoice == upgrade) {
			admin.listUpgradableGrasslands();
			getUpgradableChoice();
			displayMenu();
		} else if (playerChoice == move) {
			admin.movePlayer(admin.roll());
			admin.displaySquareDetails();
			if (admin.getBoard().getSquareOwnerId(admin.getCurrentPlayerPosition()) != 0) {
				admin.payForLandingOnOwnedGrassland();
			}
			displayMenu();
		} else if (playerChoice == purchase) {
			inputService.GetUserConfirmation("Are you sure you want to invest "
					+ admin.getBoard().costToUpgrade(admin.getCurrentPlayerPosition()) + " to buy this Grassland?");
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

	public void getUpgradableChoice() {
		int upgradableOption = 1;
		int chosenGrassland;
		outputService.println("Where would you like to plant the forest?");

		for (int i : admin.getUpgradable()) {
			if (i == 1 || i == 2) {
				outputService.println(upgradableOption + ") Upgrade Tropical Grassland " + i + " from a "
						+ admin.getBoard().getSquareType(i) + " for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}
			if (i >= 3 && i <= 5) {
				outputService.println(upgradableOption + ") Subtropical Grassland " + i + " from a "
						+ admin.getBoard().getSquareType(i) + " for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}
			if (i >= 7 && i <= 9) {
				outputService.println(upgradableOption + ") Temperate Grassland " + i + " from a "
						+ admin.getBoard().getSquareType(i) + " for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}
			if (i == 10 || i == 11) {
				outputService.println(upgradableOption + ") Boreal Grassland " + i + " from a "
						+ admin.getBoard().getSquareType(i) + " for " + admin.getBoard().costToUpgrade(i));
				upgradableOption++;
			}

		}
		int playerChoice = inputService.GetUserIntInput("Enter your upgrade choice:",
				new int[] { 1, 2, admin.getUpgradable().size() }) - 1;
		chosenGrassland = admin.getUpgradable().get(playerChoice);

		admin.upgradeOwnedGrassland(chosenGrassland);
		admin.getUpgradable().clear();
	}

}
