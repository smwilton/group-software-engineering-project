package druidsAndMana;

import druidsAndMana.MockInputService;

public class Main {

	
	public static void main(String[] args) {
		
		ConsoleInputService inputService = new ConsoleInputService();
				
		// We can pass a mocked instance into the game engine to allow end to end testing:
		GameEngine gameEngine = new GameEngine(inputService);
		
		gameEngine.TakeTurn();
	}
}
