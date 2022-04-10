package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameAdminTests {
	
	String name1, name2, duplicateName;
	int numOfPlayersAllowed, numOfPlayersNotAllowed;
	GameAdmin gameAdmin;
	MockInputService inputService = new MockInputService();
	
	@BeforeEach
	void setUp() throws Exception{
		name1 = "Tester";
		name2 = "Tester2";
		duplicateName = "Tester";
		gameAdmin = new GameAdmin(inputService);
	}

	@Test
	void testNumOfPlayersConfirmed() {
		inputService.setUserInputResponse("2");
		inputService.setConfirmation(true);
		assertEquals(2, gameAdmin.numOfPlayers());
	}
	
	@Test
	void testNumOfPlayersNotConfirmed() {
		inputService.setUserInputResponse("2");
		assertEquals(0, gameAdmin.numOfPlayers());
	}
	
	/**
	@Test
	void testPlayerSetUp() {
		fail("Not yet implemented");
	}
	**/

}
