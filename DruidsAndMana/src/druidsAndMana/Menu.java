package druidsAndMana;

public class Menu {

	GameAdmin admin;
	private IInputService inputService;
	private IOutputService outputService;

	public Menu(GameAdmin admin, IInputService inputService, IOutputService outputService) {
		this.admin = admin;
		this.inputService = inputService;
		this.outputService = outputService;
	}

	public void displayMenu() throws Exception {
		int option = 1;
		int playerChoice, start = -1, upgrade = -1, move = -1, purchase = -1, stats = -1, endTurn = -1, rules = -1, endGame=-1;
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

			outputService.println("\n"+admin.getCurrentPlayer().getPlayerName()+", your current options are: ");

			if (admin.canUpgradeGrasslands()) {
				outputService.println(option + ") Upgrade Grasslands");
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

			if (admin.getHasMoved()) {
				outputService.println(option + ") End Turn");
				endTurn = option;
				highestOptionNumber = option;
				option++;
			}
		}
		outputService.println(option + ") View Rules");
		rules = option;
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
			inputService.GetUserConfirmation("Are you sure you want to invest "+admin.getBoard().costToUpgrade(admin.getCurrentPlayerPosition())+" to buy this Grassland?");
			admin.buyUnownedGrassland();
			displayMenu();
		} else if (playerChoice == stats) {
			admin.getCurrentPlayer().printStats();
			displayMenu();
		} else if (playerChoice == endTurn) {
			inputService.GetUserConfirmation("Are you sure you want to end your turn?");
			admin.endTurn();
			displayMenu();
		} else if (playerChoice == rules) {
			displayMenu();
		} else if (playerChoice == endGame) {
			inputService.GetUserConfirmation("Are you sure you want to end the game and declare a winner?");
			admin.declareWinner();
			if(inputService.GetUserConfirmation("Would you like to return to the main menu?")) {
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
		outputService.println("Where would you like to upgrade?");

		for (int i : admin.getUpgradable()) {
			outputService.println(upgradableOption + ") Grassland " + i + " for " + admin.getBoard().costToUpgrade(i));
			upgradableOption++;
		}
		chosenGrassland = admin.getUpgradable().get((inputService.GetUserIntInput("Enter your upgrade choice:",
				new int[] {1,2,admin.getUpgradable().size()})));

		admin.upgradeOwnedGrassland(chosenGrassland);
		admin.getUpgradable().clear();
	}
	

}
