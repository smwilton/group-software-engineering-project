package druidsAndMana;

/**
 * 
 * @author sandra
 *
 */
public class GameEngine {

	private IInputService inputService;
	private IOutputService outputService;
	private Menu menu;

	public GameEngine() {
		this.menu = new Menu();
	}
	
	/**
	 * Shows welcome message and rules, then creates the game loop
	 */
	public void startGameEngine() {
		
		// Display welcome message and ask user if they want to see rules or play game
		displayWelcomeMessage();
		String userInput = menu.homeMenu();
		while(!userInput.equals("1")) {
			userInput = menu.homeMenu();
		}
		
		// Start game via Game Admin
		GameBoardBuilder gameBoardBuilder = new GameBoardBuilder();
		GameBoard gameBoard = new GameBoard(gameBoardBuilder);
		GameAdmin gameAdmin = new GameAdmin(inputService, outputService, gameBoard);
		
		// Play game until it is over
		while(gameAdmin.gameOn) {
		}
		
		// Display good bye message after game ends
		displayGoodbyeMessage();
		
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
}
