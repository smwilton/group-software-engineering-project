package druidsAndMana;

/**
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
		
		
		MockInputService inputService = new MockInputService();
		inputService.setUserInputResponse("1");
		MockOutputService outputService = new MockOutputService();
		IGameBoardBuilder builder = new GameBoardBuilder();
		GameBoard board = new GameBoard(builder);
		GameAdmin admin = new GameAdmin(inputService, outputService);
		Menu menu = new Menu(inputService, outputService);
		gameEngine = new GameEngine();
	}


	@Test
	void testDisplayWelcomeMessage() {
		String welcomeMessage = gameEngine.displayWelcomeMessage();
		assertTrue(welcomeMessage.contains("|_______/"));
	}

	@Test
	void testDisplayGoodbyeMessage() {
		String goodbyeMessage = gameEngine.displayGoodbyeMessage();
		assertTrue(goodbyeMessage.equals("Thanks for playing! - Team 31"));
	}

}
