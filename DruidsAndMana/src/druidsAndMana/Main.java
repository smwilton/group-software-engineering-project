package druidsAndMana;

public class Main {

	
	public static void main(String[] args) {
		
		ConsoleInputService inputService = new ConsoleInputService();
		
		// Create a user input mock:
		MockInputService mockInputService = new MockInputService();
		
		// Set return value:
		mockInputService.setUserInputResponse("Value returned from mock input service");
		
		// We can pass a mocked instance into the game engine to allow end to end testing:
		GameEngine gameEngine = new GameEngine(mockInputService);
		
		gameEngine.TakeTurn();
	}
}
