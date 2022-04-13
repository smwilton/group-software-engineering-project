package druidsAndMana;
/**
 * 
 * @author sandra
 * 
 */

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameEngineTests {

	String welcomeMessage, startNewGame, viewRules;
	
	private MockInputService inputService = new MockInputService();
	private GameEngine gameEngine;
	
	@BeforeEach
	void setUp() throws Exception {
		welcomeMessage = "";
		startNewGame = "1. Start new game";
		viewRules = "2. View Rules";
		gameEngine = new GameEngine(inputService);
	}
	
	
	@Test
	void testDisplayStartScreen() {
		String displayStartScreen = gameEngine.displayStartScreen();
		assertTrue(displayStartScreen.equals(welcomeMessage));		
		assertTrue(displayStartScreen.equals(startNewGame));
		assertTrue(displayStartScreen.equals(viewRules));

	}

}
