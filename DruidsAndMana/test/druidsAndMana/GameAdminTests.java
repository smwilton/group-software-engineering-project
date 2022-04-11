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
	
	
	@Test
	void testPlayerSetUpAllowed() {
		assertEquals(0, gameAdmin.players.size());
		inputService.setUserInputResponse("1");
		inputService.setConfirmation(true);
		gameAdmin.playerSetUp(gameAdmin.numOfPlayers());
		assertEquals(1, gameAdmin.players.size());
		assertEquals("1", gameAdmin.players.get(0).getPlayerName());
		assertEquals(0, gameAdmin.players.get(0).getCo2());
		assertEquals(1500, gameAdmin.players.get(0).getMana());
		assertEquals(1, gameAdmin.players.get(0).getPlayerNumber());
	}
	

}
