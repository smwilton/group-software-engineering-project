package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameAdminTests {
	
	String name1, name2, duplicateName;
	int numOfPlayersAllowed, numOfPlayersNotAllowed;
	GameAdmin gameAdmin;
	MockInputService inputService;
	GameBoard board;
	
	@BeforeEach
	void setUp() throws Exception{
		
		inputService = new MockInputService();
		
		gameAdmin = new GameAdmin(inputService);
		
		board = gameAdmin.createGameBoard();
		
		
		
		
	}

	@Test
	void testNumOfPlayersConfirmed() throws Exception {
		inputService.setUserInputResponse("2");
		inputService.setConfirmation(true);
		assertEquals(2, gameAdmin.numOfPlayers());
	}
	
	@Test
	void testNumOfPlayersNotConfirmed() throws Exception {
		inputService.setUserInputResponse("2");
		inputService.setConfirmation(false);
		
		assertEquals(0, gameAdmin.numOfPlayers());
	}
	
	
	@Test
	void testPlayerSetUpAllowed() throws Exception {
		inputService.setUserInputResponse1PlayerArray("1", "David");
		inputService.setConfirmation(true);
		gameAdmin.startGame();
		
		assertEquals(1, gameAdmin.players.size());
		assertEquals("David", gameAdmin.players.get(0).getPlayerName());
		assertEquals(0, gameAdmin.players.get(0).getCo2());
		assertEquals(1500, gameAdmin.players.get(0).getMana());
		assertEquals(1, gameAdmin.players.get(0).getPlayerNumber());
	}
	
	@Test
	void testPlayerSetUpMaxAllowed() throws Exception {
		inputService.setUserInputResponse4PlayerArray("4", "David", "Peter", "Nicola", "Sandra");
		inputService.setConfirmation(true);
		gameAdmin.startGame();		
		
		assertEquals(4, gameAdmin.players.size());
		assertEquals("David", gameAdmin.players.get(0).getPlayerName());
		assertEquals(0, gameAdmin.players.get(0).getCo2());
		assertEquals(1500, gameAdmin.players.get(0).getMana());
		assertEquals(1, gameAdmin.players.get(0).getPlayerNumber());
		assertEquals("Peter", gameAdmin.players.get(1).getPlayerName());
		assertEquals(0, gameAdmin.players.get(1).getCo2());
		assertEquals(1500, gameAdmin.players.get(1).getMana());
		assertEquals(2, gameAdmin.players.get(1).getPlayerNumber());
		assertEquals("Nicola", gameAdmin.players.get(2).getPlayerName());
		assertEquals(0, gameAdmin.players.get(2).getCo2());
		assertEquals(1500, gameAdmin.players.get(2).getMana());
		assertEquals(3, gameAdmin.players.get(2).getPlayerNumber());
		assertEquals("Sandra", gameAdmin.players.get(3).getPlayerName());
		assertEquals(0, gameAdmin.players.get(3).getCo2());
		assertEquals(1500, gameAdmin.players.get(3).getMana());
		assertEquals(4, gameAdmin.players.get(3).getPlayerNumber());
	}
	
	@Test
	void testGameIsOn() {
		assertFalse(gameAdmin.gameIsOn());
	}
	
	@Test
	void testStartEndGame() throws Exception {
		assertFalse(gameAdmin.gameIsOn());
		inputService.setUserInputResponse4PlayerArray("4", "David", "Peter", "Nicola", "Sandra");
		inputService.setConfirmation(true);
		gameAdmin.startGame();
		assertTrue(gameAdmin.gameIsOn());
		gameAdmin.endGame();
		assertFalse(gameAdmin.gameIsOn());
	}
	
	@Test
	void testGetSetSquareOWnerId() {
		assertNull(board.getSquareOwnerId(2));
		board.setSquareOwnerId(2, "1");
		assertEquals("1", board.getSquareOwnerId(2));
	}
	
	@Test
	void testCheckIfSquareIsOWned() {
		assertFalse(gameAdmin.checkIfSquareIsOwned(board, 2));
		board.setSquareOwnerId(2, "1");
		assertTrue(gameAdmin.checkIfSquareIsOwned(board, 2));
	}
	
	@Test
	void testPayForLandingOnOwnedGrassland() {
		fail();
		
	}
	

}
