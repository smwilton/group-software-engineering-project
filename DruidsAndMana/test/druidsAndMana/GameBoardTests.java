package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import druidsAndMana.Square;
import druidsAndMana.GameBoard;
import druidsAndMana.IGameBoardBuilder;

class GameBoardTests {

	private MockGameBoardBuilder mockBoardBuilder;
	private SacredAlder mockAlderSquare;
	private ScenicViewpoint mockScenicViewpoint;
	private Tropical mockTropical;
	private Subtropical mockSubtropical;
	private Boreal mockBoreal;
	private Temperate mockTemporate;
	private GameBoard mockGameBoard;
	
	@BeforeEach
	void setUp() throws Exception {
		// Create the mockGameBoard:
		mockBoardBuilder = new MockGameBoardBuilder();
		
		// Create the squares:
		mockAlderSquare = new SacredAlder();
		mockScenicViewpoint = new ScenicViewpoint();
		mockTropical = new Tropical(Realm.Tropical);
		mockSubtropical = new Subtropical(Realm.Subtropical);
		mockBoreal = new Boreal(Realm.Boreal);
		mockTemporate = new Temperate(Realm.Temperate);
		
		// Create the mockBoardBuilder:
		mockBoardBuilder.mockSquares = new ISquare[] { mockAlderSquare, mockScenicViewpoint, mockTropical, mockSubtropical, mockBoreal, mockTemporate };
		
		// Create the mock game board:
		mockGameBoard = new GameBoard(mockBoardBuilder);
	}

	@Test
	void setsquareOwnerId_VacantSquare_SetsOwnerIdUpdatesSquareType() {
		
		// Arrange
		String ownerId = "12345";
		int index = 2;
		
		// Act
		boolean ownerIdSet = this.mockGameBoard.setSquareOwnerId(index, ownerId);
		
		// Assert
		assertTrue(ownerIdSet);
		assertEquals(ownerId, mockTropical.getOwnerId());
		assertEquals(SquareStatus.Grassland, mockTropical.getSquareStatus());
	}
	
	@Test
	void setsquareOwnerId_NonGrassland_ReturnsFalse() {
		
		// Arrange
		String ownerId = "12345";
		int index = 0;
		
		// Act
		boolean ownerIdSet = this.mockGameBoard.setSquareOwnerId(index, ownerId);
		
		// Assert
		assertFalse(ownerIdSet);
		assertEquals(null, mockTropical.getOwnerId());
	}
	
	@Test
	void setsquareOwnerId_OwnedSquare_ThrowsException() {
		
		// Arrange
		String ownerId = "12345";
		int index = 2;
		
		// Act
		boolean ownerIdSet = mockGameBoard.setSquareOwnerId(index, ownerId);
		assertTrue(ownerIdSet);
		
		// Assert
		assertThrows(IllegalArgumentException.class, () -> mockGameBoard.setSquareOwnerId(index, ownerId));
	}
	
	
	
	@Test
	void getSquareOwnerId_SquareHasOwner_GetsOwnerIdForGrassland() {
		
		// Arrange
		String ownerId = "12345";
		int index = 2;
		mockTropical.setOwnerId(ownerId);
		
		// Act
		String ownerIdValue = this.mockGameBoard.getSquareOwnerId(index);
		
		// Assert
		assertEquals(ownerIdValue, ownerId);	
	}
	
	@Test
	void getSquareOwnerId_SquareHasNoOwner_ReturnsNull() {
		
		// Arrange
		int index = 2;
		
		// Act
		String ownerIdValue = this.mockGameBoard.getSquareOwnerId(index);
		
		// Assert
		assertNull(ownerIdValue);
	}
	
	@Test
	void playerCanUpgrade_PlayerOwnsAllGrasslandInRealm_ReturnsTrue() {
		
		// Arrange
		String ownerId = "12345";
		int index = 2;
		mockTropical.setOwnerId(ownerId);
		
		// Act
		boolean palyerCanUpgrade = this.mockGameBoard.playerCanUpgrade(ownerId, index);
		
		// Assert
		assertTrue(palyerCanUpgrade);
	}
	
	@Test
	void playerCanUpgrade_PlayerDoesNotOwnAllGrasslandInRealm_ReturnsFalse() {
		
		// Arrange
		String playerId = "54321";
		String ownerId = "12345";
		int index = 2;
		mockTropical.setOwnerId(ownerId);
		
		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, index);
		
		// Assert
		assertFalse(playerCanUpgrade);
	}
	
	@Test
	void playerCanUpgrade_PlayerAttemptsToUpgradeNonGrassland_ReturnsFalse() {
		
		// Arrange
		String playerId = "54321";
		
		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, 0);
		
		// Assert
		assertFalse(playerCanUpgrade);
	}
	
	@Test
	void playerCanUpgrade_RealmHasUnOnwedGrassland_ReturnFalse() {
		
		// Arrange
		String playerId = "54321";
		
		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, 4);
		
		// Assert
		assertFalse(playerCanUpgrade);
	}
}
