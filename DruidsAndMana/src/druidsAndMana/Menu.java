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
		int playerChoice, start=-1, upgrade=-1, move=-1, purchase=-1,stats=-1, endTurn=-1, rules=-1;
		int highestOptionNumber=1;
		//outputService.clearConsole();
		
		if (!admin.gameIsOn()) {
			outputService.println("Welcome to Druids and Mana!");
			outputService.println("Please choose from the following options:");
			outputService.println(option + ") Start Game");
			start = option;
			highestOptionNumber=option;
			option++;
		} else {
			
			outputService.println("Your current options are: ");
			
			if (admin.canUpgradeGrasslands()) {
				outputService.println(option + ") Upgrade Grasslands");
				upgrade = option;
				highestOptionNumber=option;
				option++;
			}

			if (!admin.hasMoved) {
				outputService.println(option + ") Roll Dice and Move");
				move = option;
				highestOptionNumber=option;
				option++;
			}

			if (admin.hasMoved && admin.board.squareIsGrassland(admin.getCurrentPlayerPosition())
					&& !admin.isSquareOwned(admin.getCurrentPlayerPosition())) {
				outputService.println(option + ") Buy Grassland");
				purchase = option;
				highestOptionNumber=option;
				option++;
			}

			outputService.println(option + ") Show current mana and CO2 stats");
			stats = option;
			highestOptionNumber=option;
			option++;

			if (admin.hasMoved) {
				outputService.println(option + ") End Turn");
				endTurn = option;
				highestOptionNumber=option;
				option++;
			}
		}
		outputService.println(option + ") View Rules");
		rules = option;
		highestOptionNumber=option;
		option++;
		
		playerChoice = getPlayerChoice(highestOptionNumber);
		
		if(playerChoice==start) {
			admin.startGame();
			displayMenu();
		}else if(playerChoice==upgrade){
			//add method to display all upgradeable squares and let Player decide which to upgrade
			displayMenu();
		}else if(playerChoice==move){
			admin.movePlayer(admin.roll());
			admin.displaySquareDetails();
			if(admin.board.getSquareOwnerId(admin.getCurrentPlayerPosition())!=0) {
				admin.payForLandingOnOwnedGrassland();
			}
			displayMenu();
		}else if(playerChoice==purchase){
			admin.buyUnownedGrassland();
			displayMenu();
		}else if(playerChoice==stats){
			outputService.println(admin.getCurrentPlayerDetails());
			displayMenu();
		}else if(playerChoice==endTurn){
			admin.endTurn();
			displayMenu();
		}else if(playerChoice==rules) {
			displayMenu();
		}
		
	}
	
	public int getPlayerChoice(int highestOptionNumber) {
		int chosen;
		
		//Create int[] of available options for Player
		int[] choices = new int[highestOptionNumber];
		for (int i=1; i<=highestOptionNumber; i++) {
			choices[i-1] = i;
		}
		
		//Ask for Player input
		chosen = inputService.GetUserIntInput("Enter your menu choice: ", choices);
		
		return chosen;
		
	}
	
	

}
