package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author pete
 * 
 */
class GameBoardTests {

	private MockGameBoardBuilder mockBoardBuilder;
	private SacredAlder mockAlderSquare;
	private ScenicViewpoint mockScenicViewpoint;
	private Tropical mockTropical_1;
	private Tropical mockTropical_2;
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
		mockTropical_1 = new Tropical(RealmTier.TIER_1);
		mockTropical_2 = new Tropical(RealmTier.TIER_1);
		mockSubtropical = new Subtropical(RealmTier.TIER_2);
		mockBoreal = new Boreal(RealmTier.TIER_4);
		mockTemporate = new Temperate(RealmTier.TIER_3);

		// Create the mockBoardBuilder:
		mockBoardBuilder.mockSquares = new ISquare[] { mockAlderSquare, mockScenicViewpoint, mockTropical_1,
				mockTropical_2, mockSubtropical, mockBoreal, mockTemporate };

		// Create the mock game board:
		mockGameBoard = new GameBoard(mockBoardBuilder);
	}

	@Test
	void setsquareOwnerId_VacantSquare_SetsOwnerIdUpdatesSquareType() {

		// Arrange
		int ownerId = 12345;
		int index = 2;

		// Act
		boolean ownerIdSet = this.mockGameBoard.setSquareOwnerId(index, ownerId);

		// Assert
		assertTrue(ownerIdSet);
		assertEquals(ownerId, mockTropical_1.getOwnerId());
		assertEquals(SquareStatus.GRASSLAND, mockTropical_1.getSquareStatus());
	}

	@Test
	void setsquareOwnerId_NonGrassland_ReturnsFalse() {

		// Arrange
		int ownerId = 12345;
		int index = 0;

		// Act
		boolean ownerIdSet = this.mockGameBoard.setSquareOwnerId(index, ownerId);

		// Assert
		assertFalse(ownerIdSet);
		assertEquals(0, mockTropical_1.getOwnerId());
	}

	@Test
	void setsquareOwnerId_OwnedSquare_ThrowsException() {

		// Arrange
		int ownerId = 12345;
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
		int ownerId = 12345;
		int index = 2;
		mockTropical_1.setInitialOwnerId(ownerId);

		// Act
		int ownerIdValue = this.mockGameBoard.getSquareOwnerId(index);

		// Assert
		assertEquals(ownerIdValue, ownerId);
	}

	@Test
	void getSquareOwnerId_SquareHasNoOwner_Returns0() {

		// Arrange
		int index = 2;

		// Act
		int ownerIdValue = this.mockGameBoard.getSquareOwnerId(index);

		// Assert
		assertEquals(0,ownerIdValue);
	}

	@Test
	void playerCanUpgrade_PlayerOwnsAllGrasslandInRealm_ReturnsTrue() {

		// Arrange
		int playerId = 12345;
		int index = 2;
		mockTropical_1.setInitialOwnerId(playerId);
		mockTropical_2.setInitialOwnerId(playerId);

		// Act
		boolean palyerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, index);

		// Assert
		assertTrue(palyerCanUpgrade);
	}

	@Test
	void playerCanUpgrade_PlayerDoesNotOwnAllGrasslandInRealm_ReturnsFalse() {

		// Arrange
		int playerId_1 = 54321;
		int playerId_2 = 12345;
		int index = 2;
		mockTropical_1.setInitialOwnerId(playerId_1);
		mockTropical_2.setInitialOwnerId(playerId_2);

		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId_1, index);

		// Assert
		assertFalse(playerCanUpgrade);
	}

	@Test
	void playerCanUpgrade_RealmHasAVacantSquare_ReturnsFalse() {
		// Arrange
		int playerId = 54321;
		int index = 2;
		mockTropical_1.setInitialOwnerId(playerId);

		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, index);

		// Assert
		assertFalse(playerCanUpgrade);
	}

	@Test
	void playerCanUpgrade_PlayerAttemptsToUpgradeNonGrassland_ReturnsFalse() {

		// Arrange
		int playerId = 54321;

		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, 0);

		// Assert
		assertFalse(playerCanUpgrade);
	}

	@Test
	void playerCanUpgrade_SquareIsVacant_ReturnTrue() {

		// Arrange
		int playerId = 54321;

		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, 4);

		// Assert
		assertTrue(playerCanUpgrade);
	}

	@Test
	void playerCanUpgrade_SquareIsAWildlifeSanctuary_ReturnFalse() {
		// Arrange
		int playerId = 12345;
		int index = 2;
		mockTropical_1.setInitialOwnerId(playerId);
		mockTropical_2.setInitialOwnerId(playerId);

		while (mockTropical_1.developGrassland()) {
			mockTropical_1.developGrassland();
		}

		assertEquals(SquareStatus.WILDLIFE_SANCTUARY, mockTropical_1.getSquareStatus());

		// Act
		boolean playerCanUpgrade = this.mockGameBoard.playerCanUpgrade(playerId, index);

		// Assert
		assertFalse(playerCanUpgrade);
	}
}
