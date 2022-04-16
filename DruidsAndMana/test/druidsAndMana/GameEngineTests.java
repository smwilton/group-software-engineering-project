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
	
	private GameEngine gameEngine;
	
	@BeforeEach
	void setUp() throws Exception {
		gameEngine = new GameEngine();
	}

	
	@Test
	void testDisplayGoodbyeMessage() {
		String goodbyeMessage = gameEngine.displayGoodbyeMessage();
		assertTrue(goodbyeMessage.equals("Thanks for playing! - Team 31"));		
	}
	
	@Test
	void testDisplayWelcomeMessage() {
		String welcomeMessage = gameEngine.displayWelcomeMessage();
		assertTrue(welcomeMessage.contains("|_______/"));		
	}

}
