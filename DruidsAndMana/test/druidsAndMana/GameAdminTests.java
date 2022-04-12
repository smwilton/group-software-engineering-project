package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameAdminTests {
	
	String name1, name2, duplicateName;
	int numOfPlayersAllowed, numOfPlayersNotAllowed;
	GameAdmin gameAdmin;
	MockInputService inputService;
	MockOutputService outputService;
	IGameBoard board;
	
	@BeforeEach
	void setUp() throws Exception{
		
		inputService = new MockInputService();
		outputService = new MockOutputService();
		
		IGameBoardBuilder gameBoardBuilder = new GameBoardBuilder();
		IGameBoard gameBoard = new GameBoard(gameBoardBuilder);
		
		gameAdmin = new GameAdmin(inputService, outputService, gameBoard);
		
		board = gameAdmin.getGameBoard();
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
	void numOfPlayers_PlayerDoesNotConfirm_OutputsMessageToConsole() throws Exception {
		
		// Arrange
		String expectedOutput = "Number of failed confirmations has reached the limit. Resetting game.";
		inputService.setUserInputResponse("2");
		inputService.setConfirmation(false);
		
		// Act
		gameAdmin.numOfPlayers();
		String actualOutput = outputService.getLastOutput();
		
		// Assert
		assertEquals(expectedOutput, actualOutput);
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
	void testGetSetSquareOwnerId() {
		assertEquals(0, board.getSquareOwnerId(2));
		board.setSquareOwnerId(2, 1);
		assertEquals(1, board.getSquareOwnerId(2));
	}
	
	@Test
	void testIsSquareOwned() {
		assertFalse(gameAdmin.isSquareOwned(board, 2));
		board.setSquareOwnerId(2, 1);
		assertTrue(gameAdmin.isSquareOwned(board, 2));
	}
	
	@Test
	void testPayForLandingOnOwnedGrassland() {
		// Peter will implement
	}
		
	@Test
	void playerSetUp_AddNameThatAlreadyExists_OutputsMessageToConsole() throws Exception {
		
		// Arrange
		String expectedOutput = "This player name already exists. Please choose a unique name.";
		inputService.setUserInputResponse4PlayerArray("4", "Clive", "Clive", "Tom", "David");
		inputService.setConfirmation(true);
		
		// Act
		gameAdmin.startGame();
		
		// Assert
		String actualOutput = outputService.getLastOutput();	
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void displaySquareDetails_SquareUnonwed_OutputsCorrectContentToConsole() throws Exception {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
		
		// Setting up the players and starting the game
		inputService.setUserInputResponse4PlayerArray("4", "David", "Peter", "Nicola", "Sandra");
		inputService.setConfirmation(true);
		
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		gameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		gameAdmin.playerSetUp(4);
				
		// Act
		gameAdmin.displaySquareDetails();
		
		// Assert
		String allOutput = outputService.getAllOutput();
		assertTrue(allOutput.contains(mockTropical.description()));
		assertTrue(allOutput.contains("Currently Unowned"));
		assertTrue(allOutput.contains("Cost to buy: 0"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"Peter", "Alfred", "Daniel", "Joe"})
	void example(String input) {
		assertTrue(input.length() > 0);
	}
}
