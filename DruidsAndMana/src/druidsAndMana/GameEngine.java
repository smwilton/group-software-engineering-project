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
		this.inputService = new ConsoleInputService();
		this.outputService = new ConsoleOutputService();
		this.menu = new Menu(inputService, outputService);

	}

	/**
	 * Shows welcome message and rules, then creates the game loop
	 * @throws Exception 
	 */
	public void startGameEngine() throws Exception {
		
		// Display welcome message and ask user if they want to see rules or play game
		displayWelcomeMessage();
		
		//Access Menu class to run game within
		menu.displayMenu();
		
		// Display good bye message after game ends
		displayGoodbyeMessage();

	}

	/**
	 * Displays goodbye message
	 */
	public String displayGoodbyeMessage() {
		String message = "Thanks for playing! - Team 31";
		outputService.println(message);
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

		outputService.println(welcomeMessage);
		return welcomeMessage;
	}

}
