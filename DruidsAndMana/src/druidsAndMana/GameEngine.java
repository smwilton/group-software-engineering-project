package druidsAndMana;

/**
 * 
 * @author sandra
 *
 */
public class GameEngine {

	private IInputService inputService;
	private IOutputService outputService;
	private IGameBoard gameBoard;
	private Rules rules;

	public GameEngine(IInputService inputService) {
		this.inputService = inputService;
	}

	public String displayStartScreen() {
		String welcomeMesage = "";
		
		// Display options
		String startNewGame = "1. Start new game";
		String viewRules = "2. View rules";
		System.out.println(welcomeMesage + "\n\n");
		System.out.println(startNewGame + "\n" + viewRules);
		
		String optionChoice = this.inputService.GetUserInput("WHat would you like to do?", new String[] {"1", "2"});
		
	
		// if player chooses option 1, a new GmeAdmin is instantiated within a while
		// loop that's asking GameAdmin if the game is still on.
		// if GameAdmin return false then.... (figure this out)

		// if player chooses option 2, the Rules are displayed and a prompt asks if they
		// want to return to the previous page.
		
		return optionChoice;
	}

	public void handleMenuOptions() throws Exception {
//		do {
			// displayStartScreen();
			// } while (
			// displayStartScreen()
			// );
			//
			//
			// GameAdmin gameAdmin = new GameAdmin(inputService);
			//

			String result = displayStartScreen();

			while (!result.equals("1")){
			rules = new Rules(inputService);
			rules.displayRules();
			result = displayStartScreen();
			}

			// Create GameAdmin and loop until gameAdmin.isGameOn == false
			GameAdmin gameAdmin = new GameAdmin(inputService, outputService, gameBoard);

			gameAdmin.startGame();

			while(gameAdmin.gameIsOn()) {
			// Game is on, do nothing
			}

			System.out.println("Thanks for playing!");

	}

	public void TakeTurn() {

		// Lots of logic here:

		// Getting some user input:
		// String selectedValue = this.inputService.GetUserInput("Please enter your
		// pokemon type", new String[] { "Earth", "Wind", "Fire", "Water" });

		// Create a new game board... just for fun
		IGameBoard testGameBoard = new GameBoard(new GameBoardBuilder());

		String art = testGameBoard.squareAsciiArt(6);
		String description = testGameBoard.squareDescription(6);

		System.out.println(art);
		System.out.println();
		System.out.println(description);

		//
		// boolean val = this.inputService.GetUserConfirmation("test");

		// Printing the userInput
		// System.out.println(val);

		// Store all of the variables

		// Game engine -> wraps the turn engine

		// Game engine -> persists state

		// Turn engine -> runs in a game

		// Game engine creates players before the game starts

		// passed into the turn engine:

		// Turn engine encapsulates

		// --------------------------------------------

		// Game admin -> putting in the players names, knows who playing:

		// Board class contains an array of 12 tiles

		// Each turn tile abstact generic -> different types grassland, realmTier1 ->
		// enum -> need const values

		// Turn - player existing position and dice roll -> [2, 6], Player < - class

		// Player set new position.

		// dice roll service -> mock out dice roll for testing

		// dice object - number of sides -> two dice need two instances. Dice dice = new
		// Dice(6) - int result = dice.roll() + dice.roll()

		// Player score and co2 balance and owned grassland is part of the player class

		//

	}
}
