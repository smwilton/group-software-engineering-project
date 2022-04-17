package druidsAndMana;

/**
 * 
 * @author sandra
 *
 */
public class GameEngine {

	private IInputService inputService;
	private IOutputService outputService;
	private Rules rules;

	public GameEngine(IInputService inputService, IOutputService outputService) {
		this.inputService = inputService;
		this.outputService = outputService;
		this.rules = new Rules(inputService);
	}

	/**
	 * Shows welcome message and rules, then creates the game loop
	 */
	public void startGameEngine() {
		
		// Display welcome message and ask user if they want to see rules or play game
		displayWelcomeMessage();
		String userInput = homeMenu();

		// User chooses option 2 (Rules)
		while (!userInput.equals("1")) {
			// Rules are displayed
			rules.displayRules();
			// User inputs response
			boolean exitRules = rules.exitRules();
			// If user is still reading the rules ask if they are finished, again.
			if (exitRules == false) {
				rules.displayRules();
			} else {
				// User has finished reading rules and they return to welcome message and menu
				displayWelcomeMessage();
				// If user again chooses rules, the loop starts again
				userInput = homeMenu();
			}
		}

		// Start game via GameAdmin
		GameAdmin gameAdmin = startGame();
		
		// Play game until it is over
		while (gameAdmin.gameIsOn()) {
		}

		// Display good bye message after game ends
		displayGoodbyeMessage();

	}
	
	public GameAdmin startGame() {
		GameBoardBuilder gameBoardBuilder = new GameBoardBuilder();
		GameBoard gameBoard = new GameBoard(gameBoardBuilder);
		GameAdmin gameAdmin = new GameAdmin(inputService, outputService, gameBoard);

		return gameAdmin;
	}

	/**
	 * Displays goodbye message
	 */
	public String displayGoodbyeMessage() {
		String message = "Thanks for playing! - Team 31";
		System.out.println(message);
		return message;
	}

	/**
	 * Displays welcome message
	 */
	public String displayWelcomeMessage() {

		String welcomeMessage = "\n\n\n"

				+ "              _______  .______       __    __   __   _______       _______.             .___  ___.      ___      .__   __.      ___      \n"
				+ "             |       \\ |   _  \\     |  |  |  | |  | |       \\     /       |      _      |   \\/   |     /   \\     |  \\ |  |     /   \\     \n"
				+ "             |  .--.  ||  |_)  |    |  |  |  | |  | |  .--.  |   |   (----`    _| |_    |  \\  /  |    /  ^  \\    |   \\|  |    /  ^  \\    \n"
				+ "             |  |  |  ||      /     |  |  |  | |  | |  |  |  |    \\   \\       |_   _|   |  |\\/|  |   /  /_\\  \\   |  . `  |   /  /_\\  \\   \n"
				+ "             |  '--'  ||  |\\  \\----.|  `--'  | |  | |  '--'  |.----)   |        |_|     |  |  |  |  /  _____  \\  |  |\\   |  /  _____  \\  \n"
				+ "             |_______/ | _| `._____| \\______/  |__| |_______/ |_______/                 |__|  |__| /__/     \\__\\ |__| \\__| /__/     \\__\\ \n"
				+ "                                                                                                                                        \n\n ";

		System.out.println(welcomeMessage);
		return welcomeMessage;
	}

	public String homeMenu() {

		String startNewGame = "1. Start new game";
		String viewRules = "2. View rules";
		System.out.println("Choose an option from below :\n\n");
		System.out.println(startNewGame + "\n" + viewRules);

		String optionChoice = this.inputService.GetUserInput("What would you like to do?", new String[] { "1", "2" });
		return optionChoice;
	}
}
