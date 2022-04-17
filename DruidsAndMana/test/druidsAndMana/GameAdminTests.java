package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		
		assertEquals(1, gameAdmin.getPlayers().size());
		assertEquals("David", gameAdmin.getPlayers().get(0).getPlayerName());
		assertEquals(0, gameAdmin.getPlayers().get(0).getCo2());
		assertEquals(1500, gameAdmin.getPlayers().get(0).getMana());
		assertEquals(1, gameAdmin.getPlayers().get(0).getPlayerNumber());
	}
	
	@Test
	void testPlayerSetUpMaxAllowed() throws Exception {
		inputService.setUserInputResponse4PlayerArray("4", "David", "Peter", "Nicola", "Sandra");
		inputService.setConfirmation(true);
		gameAdmin.playerSetUp(4);		
		
		assertEquals(4, gameAdmin.getPlayers().size());
		assertEquals("David", gameAdmin.getPlayers().get(0).getPlayerName());
		assertEquals(0, gameAdmin.getPlayers().get(0).getCo2());
		assertEquals(1500, gameAdmin.getPlayers().get(0).getMana());
		assertEquals(1, gameAdmin.getPlayers().get(0).getPlayerNumber());
		assertEquals("Peter", gameAdmin.getPlayers().get(1).getPlayerName());
		assertEquals(0, gameAdmin.getPlayers().get(1).getCo2());
		assertEquals(1500, gameAdmin.getPlayers().get(1).getMana());
		assertEquals(2, gameAdmin.getPlayers().get(1).getPlayerNumber());
		assertEquals("Nicola", gameAdmin.getPlayers().get(2).getPlayerName());
		assertEquals(0, gameAdmin.getPlayers().get(2).getCo2());
		assertEquals(1500, gameAdmin.getPlayers().get(2).getMana());
		assertEquals(3, gameAdmin.getPlayers().get(2).getPlayerNumber());
		assertEquals("Sandra", gameAdmin.getPlayers().get(3).getPlayerName());
		assertEquals(0, gameAdmin.getPlayers().get(3).getCo2());
		assertEquals(1500, gameAdmin.getPlayers().get(3).getMana());
		assertEquals(4, gameAdmin.getPlayers().get(3).getPlayerNumber());
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
		assertFalse(gameAdmin.isSquareOwned(2));
		board.setSquareOwnerId(2, 1);
		assertTrue(gameAdmin.isSquareOwned(2));
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
		gameAdmin.playerSetUp(4);
		
		// Assert
		String actualOutput = outputService.getLastOutput();	
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void displaySquareDetails_SquareUnonwed_OutputsCorrectContentToConsole() throws Exception {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
				
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		
		// Create mock players
		Player mockPlayer1 = new Player("Mock", 1, 1, 0, 0, 0);
		Player mockPlayer2 = new Player("Mock", 2, 1, 0, 0, 0);
		
		GameAdmin localGameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		localGameAdmin.setPlayers(new ArrayList<Player>());
		localGameAdmin.getPlayers().add(mockPlayer1);
		localGameAdmin.getPlayers().add(mockPlayer2);
		localGameAdmin.setCurrentPlayer(1);
				
		// Act
		localGameAdmin.displaySquareDetails();
		
		// Assert
		String allOutput = outputService.getAllOutput();
		assertTrue(allOutput.contains(mockTropical.description()));
		assertTrue(allOutput.contains("Currently Unowned"));
		assertTrue(allOutput.contains("Cost to buy: 0"));
	}

	@Test
	void displaySquareDetails_SquareOwned_OutputsCorrectContentToConsole() throws Exception {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
				
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		mockTropical.setInitialOwnerId(1);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		
		// Create mock players
		Player mockPlayer1 = new Player("Mock", 1, 1, 0, 0, 0);
		Player mockPlayer2 = new Player("Mock", 2, 1, 0, 0, 0);
		
		GameAdmin localGameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		localGameAdmin.setPlayers(new ArrayList<Player>());
		localGameAdmin.getPlayers().add(mockPlayer1);
		localGameAdmin.getPlayers().add(mockPlayer2);
		localGameAdmin.setCurrentPlayer(1);
				
		// Act
		localGameAdmin.displaySquareDetails();
		
		// Assert
		String allOutput = outputService.getAllOutput();
		assertTrue(allOutput.contains(mockTropical.description()));
		assertTrue(allOutput.contains("Owned by: Mock"));
		assertTrue(allOutput.contains("Mana Charge: 0"));
	}
	
	@Test
	void buyUnownedGrassland_SufficientMana_PlayerBecomesOwner() throws Exception {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
		
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		mockBoard.setManaCharge(100);
		
		// Ensure the grass land is not owned
		assertEquals(0, mockTropical.getOwnerId());
		
		// Create mock players
		int expectedPlayerNumber = 1;
		Player mockPlayer1 = new Player("Mock", expectedPlayerNumber, 1, 999, 0, 0);
		Player mockPlayer2 = new Player("Mock", 2, 1, 999, 0, 0);
		
		GameAdmin localGameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		localGameAdmin.setPlayers(new ArrayList<Player>());
		localGameAdmin.getPlayers().add(mockPlayer1);
		localGameAdmin.getPlayers().add(mockPlayer2);
		localGameAdmin.setCurrentPlayer(1);
		
	}
	
	@Test
	void buyUnownedGrassland_InsufficientMana_PlayerDoesNotBecomeOwner() throws Exception {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
		
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		mockBoard.setManaCharge(100);
		
		// Ensure the grass land is not owned
		assertEquals(0, mockTropical.getOwnerId());
		
		// Create mock players
		int expectedPlayerNumber = 1;
		Player mockPlayer1 = new Player("Mock", expectedPlayerNumber, 1, 0, 0, 0);
		Player mockPlayer2 = new Player("Mock", 2, 1, 0, 0, 0);
		
		GameAdmin localGameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		localGameAdmin.setPlayers(new ArrayList<Player>());
		localGameAdmin.getPlayers().add(mockPlayer1);
		localGameAdmin.getPlayers().add(mockPlayer2);
		localGameAdmin.setCurrentPlayer(1);
		
	}
	
	@Test
	void payForLandingOnOwnedGrassland_InsufficientMana_PlayerCannotPayDebt() {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
		
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		mockTropical.setInitialOwnerId(2);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		mockBoard.setManaCharge(100);
		
		// Create mock players
		int expectedPlayerNumber = 1;
		Player mockPlayer1 = new Player("Mock", expectedPlayerNumber, 1, 0, 0, 0);
		Player mockPlayer2 = new Player("Mock", 2, 1, 0, 0, 0);
		
		GameAdmin localGameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		localGameAdmin.setPlayers(new ArrayList<Player>());
		localGameAdmin.getPlayers().add(mockPlayer1);
		localGameAdmin.getPlayers().add(mockPlayer2);
		localGameAdmin.setCurrentPlayer(1);
		
	}
	
	@Test
	void payForLandingOnOwnedGrassland_SufficientMana_PlayerPaysDebtToOwner() {
		
		// Arrange
		inputService = new MockInputService();
		outputService = new MockOutputService();
		
		// Creating a mock GameBoard
		Tropical mockTropical = new Tropical(RealmTier.TIER_1);
		MockGameBoard mockBoard = new MockGameBoard(mockTropical);
		
		// Ensure the grass land is not owned
		assertEquals(0, mockTropical.getOwnerId());
		
		// Setting the mana charge:
		int manaCharge = 100;
		mockBoard.setManaCharge(manaCharge);
		
		// Create mock players
		int expectedPlayerNumber = 1;
		Player mockPlayer1 = new Player("Mock", expectedPlayerNumber, 1, manaCharge, 0, 0);
		Player mockPlayer2 = new Player("Mock", 2, 1, 0, 0, 0);
		
		GameAdmin localGameAdmin = new GameAdmin(inputService, outputService, mockBoard);
		localGameAdmin.setPlayers(new ArrayList<Player>());
		localGameAdmin.getPlayers().add(mockPlayer1);
		localGameAdmin.getPlayers().add(mockPlayer2);
		localGameAdmin.setCurrentPlayer(1);
		
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = {"Peter", "Alfred", "Daniel", "Joe"})
	void example(String input) {
		assertTrue(input.length() > 0);
	}
}
