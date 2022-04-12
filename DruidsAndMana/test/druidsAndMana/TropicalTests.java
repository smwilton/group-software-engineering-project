package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Testing of the Tropical Class as an implementation of the ISquare Interface,
 * Grassland Abstract Class and Tropical Class
 * 
 * @author Nicola Stirling 40020701
 *
 */
class TropicalTests {

	Tropical squareTropicalInstance, squareVacant, squareGrassland, squareSeedlingForest, squareIntermediateForest,
			squareEstablishedForest, squareWildlifeSanctuary;
	Grassland squareGrasslandInstance;
	ISquare squareISquareInstance;
	RealmTier realmTier1;
	String expectedAsciiArt, expectedDescription, ownerIdOption1, ownerIdOption2, ownerIdOption3;
	SquareStatus status1, status2, status3, status4, status5, status6;
	int expectedPriceToBuyTier1, expectedPriceToPlantForestTier1,
			expectedPriceForWildlifeSanctuaryUpgradeTier1, expectedCO2ImpactVacantTier1,
			expectedCO2ImpactGrasslandTier1, expectedCO2ImpactSeedlingTier1, expectedCO2ImpactIntermediateTier1,
			expectedCO2ImpactEstablishedTier1, expectedCO2ImpactWildlifeSanctuaryTier1, expectedLandOnCostVacantTier1,
			expectedLandOnCostGrasslandTier1, expectedLandOnCostSeedlingTier1, expectedLandOnCostIntermediateTier1,
			expectedLandOnCostEstablishedTier1, expectedLandOnCostWildlifeSanctuaryTier1, ownerIdOption1, ownerIdOption2, ownerIdOption3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		realmTier1 = RealmTier.TIER_1;

		squareTropicalInstance = new Tropical(realmTier1);
		squareGrasslandInstance = new Tropical(realmTier1);
		squareISquareInstance = new Tropical(realmTier1);
		expectedAsciiArt = "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
				+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
		expectedDescription = "The tropical grassland has a bustling and diverse ecosystem where each player will find harmony with Nature";
		status1 = SquareStatus.VACANT;
		status2 = SquareStatus.GRASSLAND;
		status3 = SquareStatus.SEEDLING_FOREST;
		status4 = SquareStatus.INTERMEDIATE_FOREST;
		status5 = SquareStatus.ESTABLISHED_FOREST;
		status6 = SquareStatus.WILDLIFE_SANCTUARY;

		squareVacant = new Tropical(realmTier1);
		squareGrassland = new Tropical(realmTier1);
		squareGrassland.developGrassland(); // developing the square once to convert to a GRASSLAND
		squareSeedlingForest = new Tropical(realmTier1);
		squareSeedlingForest.developGrassland();
		squareSeedlingForest.developGrassland(); // developing the square twice to convert to a SEEDLING_FOREST (1 minor
													// development)
		squareIntermediateForest = new Tropical(realmTier1);
		squareIntermediateForest.developGrassland();
		squareIntermediateForest.developGrassland();
		squareIntermediateForest.developGrassland();// developing the square three times to convert to a
													// INTERMEDIATE_FOREST (2 minor developments)
		squareEstablishedForest = new Tropical(realmTier1);
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland(); // developing the square four times to convert to a
													// ESTABLISHED_FOREST (3 minor developments)
		squareWildlifeSanctuary = new Tropical(realmTier1);
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland(); // developing the square five times to convert to a
													// ESTABLISHED_FOREST (1 major development)
		// This is the Tier 1 values
		expectedPriceToBuyTier1 = 60;
		expectedPriceToPlantForestTier1 = 12;
		expectedPriceForWildlifeSanctuaryUpgradeTier1 = 60;
		expectedCO2ImpactVacantTier1 = 0;
		expectedCO2ImpactGrasslandTier1 = 60;
		expectedCO2ImpactSeedlingTier1 = 66;
		expectedCO2ImpactIntermediateTier1 = 72;
		expectedCO2ImpactEstablishedTier1 = 78;
		expectedCO2ImpactWildlifeSanctuaryTier1 = 98;
		expectedLandOnCostVacantTier1 = 0;
		expectedLandOnCostGrasslandTier1 = 10;
		expectedLandOnCostSeedlingTier1 = 14;
		expectedLandOnCostIntermediateTier1 = 18;
		expectedLandOnCostEstablishedTier1 = 22;
		expectedLandOnCostWildlifeSanctuaryTier1 = 30;

		ownerIdOption1 = "1";
		ownerIdOption2 = "Owner Test";
		ownerIdOption3 = "Owner123";
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.Tropical#Tropical(druidsAndMana.RealmTier)}.
	 * <p>
	 * Tests that the constructor sets the initial square status as VACANT, that the
	 * ownerId is null and that for each RealmTier the correct the correct
	 * priceToBuy is set
	 */
	@ParameterizedTest(name = "{index} => a={0}, b={1}")
	@CsvSource({ "TIER_1 , 60", "TIER_2 , 50", "TIER_3 , 40", "TIER_4 , 30" })
	void testConstructor(RealmTier realmTier, int expectedPriceToBuy) {
		Tropical squareTropicalInstance = new Tropical(realmTier);
		// Testing constructor is an instance of the ISquare interface, Grassland Class
		// and Tropical Class
		assertTrue(squareTropicalInstance instanceof ISquare);
		assertTrue(squareTropicalInstance instanceof Grassland);
		assertTrue(squareTropicalInstance instanceof Tropical);
		// Testing constructor set the status to VACANT
		assertEquals(status1, squareTropicalInstance.getSquareStatus());
		// Testing the constructor set the Values using the private method by getting
		// the price to buy
		assertEquals(expectedPriceToBuy, squareTropicalInstance.getDevelopmentCost());
		// Testing that owner's id is null initially
		assertEquals(0,squareTropicalInstance.getOwnerId());

		Grassland squareGrasslandInstance = new Tropical(realmTier);
		// Testing constructor is an instance of the ISquare interface, Grassland Class
		// and Tropical Class
		assertTrue(squareGrasslandInstance instanceof ISquare);
		assertTrue(squareGrasslandInstance instanceof Grassland);
		assertTrue(squareGrasslandInstance instanceof Tropical);
		// Testing constructor set the status to VACANT
		assertEquals(status1, squareGrasslandInstance.getSquareStatus());
		// Testing the constructor set the Values using the private method by getting
		// the price to buy
		assertEquals(expectedPriceToBuy, squareGrasslandInstance.getDevelopmentCost());
		// Testing that owner's id is null initially
		assertEquals(0,squareGrasslandInstance.getOwnerId());

		ISquare squareISquareInstance = new Tropical(realmTier);
		// Testing constructor is an instance of the ISquare interface, Grassland Class
		// and Tropical Class
		assertTrue(squareISquareInstance instanceof ISquare);
		assertTrue(squareISquareInstance instanceof Grassland);
		assertTrue(squareISquareInstance instanceof Tropical);
		// Testing constructor set the status to VACANT
		assertEquals(status1, ((Grassland) squareISquareInstance).getSquareStatus());
		// Testing the constructor set the Values using the private method by getting
		// the price to buy
		assertEquals(expectedPriceToBuy, ((Grassland) squareISquareInstance).getDevelopmentCost());
		// Testing that owner's id is null initially
		assertEquals(0,((Grassland) squareISquareInstance).getOwnerId());

	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getDevelopmentCost()}.
	 * <p>
	 * Tests the developmentCost method returns the expected value for each stage in
	 * the squares development
	 */
	@Test
	void testGetDevelopmentCost() {
		// VACANT square should return the price to buy
		assertEquals(expectedPriceToBuyTier1, squareVacant.getDevelopmentCost());

		// GRASSLAND, SEEDLING_FOREST, and INTERMEDIATE_FOREST should return the price
		// to
		// plant a forest
		assertEquals(expectedPriceToPlantForestTier1, squareGrassland.getDevelopmentCost());
		assertEquals(expectedPriceToPlantForestTier1, squareSeedlingForest.getDevelopmentCost());
		assertEquals(expectedPriceToPlantForestTier1, squareIntermediateForest.getDevelopmentCost());

		// ESTABLISHED_FOREST should return the price to upgrade to a WILDLIFE_SANCTUARY
		assertEquals(expectedPriceForWildlifeSanctuaryUpgradeTier1, squareEstablishedForest.getDevelopmentCost());

		// WILDLIFE_SANCTUARY should return 0 as development option have been fully
		// exhausted
		assertEquals(0, squareWildlifeSanctuary.getDevelopmentCost());
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.Grassland#getChargeForLandingOnSquare()}.
	 * <p>
	 * Tests the getChargeForLandingOnSquare method returns the expected value for
	 * each stage in the squares development
	 */
	@Test
	void testGetChargeForLandingOnSquare() {
		assertEquals(expectedLandOnCostVacantTier1, squareVacant.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostGrasslandTier1, squareGrassland.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostSeedlingTier1, squareSeedlingForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostIntermediateTier1, squareIntermediateForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostEstablishedTier1, squareEstablishedForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostWildlifeSanctuaryTier1, squareWildlifeSanctuary.getChargeForLandingOnSquare());
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getCo2ImpactRating()}.
	 * <p>
	 * Tests the getCo2ImpactRating method returns the expected value for each stage
	 * in the squares development
	 */
	@Test
	void testGetCo2ImpactRating() {
		assertEquals(expectedCO2ImpactVacantTier1, squareVacant.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactGrasslandTier1, squareGrassland.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactSeedlingTier1, squareSeedlingForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactIntermediateTier1, squareIntermediateForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactEstablishedTier1, squareEstablishedForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactWildlifeSanctuaryTier1, squareWildlifeSanctuary.getCo2ImpactRating());
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getSquareStatus()} and
	 * {@link druidsAndMana.Grassland#canDevelopGrassland()} and
	 * {@link druidsAndMana.Grassland#developGrassland()}.
	 * <p>
	 * Tests that the getSquareStatus, canDevelopGrassland and DevelopGrassland
	 * methods behaves as expected as each stage throughout the squares development
	 * and that the square development is applied as expected.
	 * <p>
	 * This test has been performed for each square instance to ensure the methods
	 * behave as expected regardless of how it has been declared (i.e. using
	 * ISquare, Grassland or Tropical).
	 */
	@Test
	void testSquareDevelopment() {
		// when a square instance is declared the status is set to VACANT
		assertEquals(status1, squareTropicalInstance.getSquareStatus());
		assertEquals(status1, squareGrasslandInstance.getSquareStatus());
		assertEquals(status1, ((Grassland) squareISquareInstance).getSquareStatus());
		assertTrue(squareTropicalInstance.canDevelopGrassland());
		assertTrue(squareGrasslandInstance.canDevelopGrassland());
		assertTrue(((Grassland) squareISquareInstance).canDevelopGrassland());

		/*
		 * When a square is developed it should update the status to the next one and
		 * the developGrassland() method returns true. The canDevelopGrassland() method
		 * should return true for all status's except for when the status is set to
		 * WildLifeReserve
		 */

		// Updating from VACANT to GRASSLAND
		assertTrue(squareTropicalInstance.developGrassland());
		assertTrue(squareGrasslandInstance.developGrassland());
		assertTrue(((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status2, squareTropicalInstance.getSquareStatus());
		assertEquals(status2, squareGrasslandInstance.getSquareStatus());
		assertEquals(status2, ((Grassland) squareISquareInstance).getSquareStatus());
		assertTrue(squareTropicalInstance.canDevelopGrassland());
		assertTrue(squareGrasslandInstance.canDevelopGrassland());
		assertTrue(((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from GRASSLAND to SEEDLING_FOREST
		assertTrue(squareTropicalInstance.developGrassland());
		assertTrue(squareGrasslandInstance.developGrassland());
		assertTrue(((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status3, squareTropicalInstance.getSquareStatus());
		assertEquals(status3, squareGrasslandInstance.getSquareStatus());
		assertEquals(status3, ((Grassland) squareISquareInstance).getSquareStatus());
		assertTrue(squareTropicalInstance.canDevelopGrassland());
		assertTrue(squareGrasslandInstance.canDevelopGrassland());
		assertTrue(((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from SEEDLING_FOREST to INTERMEDIATE_FOREST
		assertTrue(squareTropicalInstance.developGrassland());
		assertTrue(squareGrasslandInstance.developGrassland());
		assertTrue(((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status4, squareTropicalInstance.getSquareStatus());
		assertEquals(status4, squareGrasslandInstance.getSquareStatus());
		assertEquals(status4, ((Grassland) squareISquareInstance).getSquareStatus());
		assertTrue(squareTropicalInstance.canDevelopGrassland());
		assertTrue(squareGrasslandInstance.canDevelopGrassland());
		assertTrue(((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from INTERMEDIATE_FOREST to EstablisedForest
		assertTrue(squareTropicalInstance.developGrassland());
		assertTrue(squareGrasslandInstance.developGrassland());
		assertTrue(((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status5, squareTropicalInstance.getSquareStatus());
		assertEquals(status5, squareGrasslandInstance.getSquareStatus());
		assertEquals(status5, ((Grassland) squareISquareInstance).getSquareStatus());
		assertTrue(squareTropicalInstance.canDevelopGrassland());
		assertTrue(squareGrasslandInstance.canDevelopGrassland());
		assertTrue(((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from ESTABLISHED_FOREST to WildlifeReserve
		assertTrue(squareTropicalInstance.developGrassland());
		assertTrue(squareGrasslandInstance.developGrassland());
		assertTrue(((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status6, squareTropicalInstance.getSquareStatus());
		assertEquals(status6, squareGrasslandInstance.getSquareStatus());
		assertEquals(status6, ((Grassland) squareISquareInstance).getSquareStatus());
		assertFalse(squareTropicalInstance.canDevelopGrassland());
		assertFalse(squareGrasslandInstance.canDevelopGrassland());
		assertFalse(((Grassland) squareISquareInstance).canDevelopGrassland());

		// Trying to update the WILDLIFE_SANCTUARY should return false and the status
		// should remain as WILDLIFE_SANCTUARY
		assertFalse(squareTropicalInstance.developGrassland());
		assertFalse(squareGrasslandInstance.developGrassland());
		assertFalse(((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status6, squareTropicalInstance.getSquareStatus());
		assertEquals(status6, squareGrasslandInstance.getSquareStatus());
		assertEquals(status6, ((Grassland) squareISquareInstance).getSquareStatus());
	}

	/**
	 * Test method for {@link druidsAndMana.Tropical#description()}.
	 * <p>
	 * Tests that the description for each square instance is as expected regardless
	 * of how it has been declared (i.e. using ISquare, Grassland or Tropical. It
	 * has also been performed for a square at each stage of the development cycle
	 * to ensure it behaves as expected regardless of how many developments have
	 * been applied
	 */
	@Test
	void testDescription() {
		assertEquals(expectedDescription, squareTropicalInstance.description());
		assertEquals(expectedDescription, squareGrasslandInstance.description());
		assertEquals(expectedDescription, squareISquareInstance.description());
		assertEquals(expectedDescription, squareVacant.description());
		assertEquals(expectedDescription, squareGrassland.description());
		assertEquals(expectedDescription, squareSeedlingForest.description());
		assertEquals(expectedDescription, squareIntermediateForest.description());
		assertEquals(expectedDescription, squareEstablishedForest.description());
		assertEquals(expectedDescription, squareWildlifeSanctuary.description());
	}

	/**
	 * Test method for {@link druidsAndMana.Tropical#asciiArt()}.
	 * <p>
	 * Tests that the ascii art for each square instance is as expected regardless
	 * of how it has been declared (i.e. using ISquare, Grassland or Tropical). It
	 * has also been performed for a square at each stage of the development cycle
	 * to ensure it behaves as expected regardless of how many developments have
	 * been applied
	 */
	@Test
	void testAsciiArt() {
		assertEquals(expectedAsciiArt, squareTropicalInstance.asciiArt());
		assertEquals(expectedAsciiArt, squareGrasslandInstance.asciiArt());
		assertEquals(expectedAsciiArt, squareISquareInstance.asciiArt());
		assertEquals(expectedAsciiArt, squareVacant.asciiArt());
		assertEquals(expectedAsciiArt, squareGrassland.asciiArt());
		assertEquals(expectedAsciiArt, squareSeedlingForest.asciiArt());
		assertEquals(expectedAsciiArt, squareIntermediateForest.asciiArt());
		assertEquals(expectedAsciiArt, squareEstablishedForest.asciiArt());
		assertEquals(expectedAsciiArt, squareWildlifeSanctuary.asciiArt());
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.Grassland#setInitialOwnerId(java.lang.String)} and
	 * {@link druidsAndMana.Grassland#getOwnerId()} and
	 * {@link druidsAndMana.Grassland#transferOwnership(java.lang.String)}.
	 * <p>
	 * Tests the getter and 2 setter methods for the OwnerId behaves as expected
	 * regardless of how it has been declared (i.e. using ISquare, Grassland or
	 * Tropical).
	 * <p>
	 * This test includes both the setInitialOwnerId setter and the
	 * transferOwnership setter
	 */
	@Test
	void testSetAndGetOwnerId() {
		// ----------------------- PART1 - Tropical -----------------------

		// An error should be thrown if the transferOwnership method is used before the
		// OwnerId has been set
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			squareTropicalInstance.transferOwnership(ownerIdOption2);
		});
		assertEquals("A player must currently own this square to transfer the ownership to another Player",
				e.getMessage());

		// Test setting the initial owner and updating the SquareStatus from VACANT to
		// GRASSLAND)
		assertEquals(SquareStatus.VACANT, squareTropicalInstance.getSquareStatus()); // Status is VACANT before OwnerID
																						// is set
		squareTropicalInstance.setInitialOwnerId(ownerIdOption1);
		assertEquals(1, squareTropicalInstance.getOwnerId());
		assertEquals(SquareStatus.GRASSLAND, squareTropicalInstance.getSquareStatus()); // Status is GRASSLAND after
																						// OwnerID is set

		// Test that an exception is thrown if an owner id is set when an owner id is
		// already set
		e = assertThrows(IllegalArgumentException.class, () -> {
			squareTropicalInstance.setInitialOwnerId(ownerIdOption2);
		});
		assertEquals("Another player already owns this square", e.getMessage());

		// Test that now the Initial Owner has been set the the ownership can be
		// transferred
		squareTropicalInstance.transferOwnership(ownerIdOption2);
		assertEquals(12345, squareTropicalInstance.getOwnerId());

		// ----------------------- PART2 - Grassland -----------------------

		// An error should be thrown if the transferOwnership method is used before the
		// OwnerId has been set
		e = assertThrows(IllegalArgumentException.class, () -> {
			squareGrasslandInstance.transferOwnership(ownerIdOption3);
		});
		assertEquals("A player must currently own this square to transfer the ownership to another Player",
				e.getMessage());

		// Test setting the initial owner and updating the SquareStatus from VACANT to
		// GRASSLAND)
		assertEquals(SquareStatus.VACANT, squareGrasslandInstance.getSquareStatus()); // Status is VACANT before OwnerID
																						// is set
		squareGrasslandInstance.setInitialOwnerId(ownerIdOption2);
		assertEquals(12345, squareGrasslandInstance.getOwnerId());
		assertEquals(SquareStatus.GRASSLAND, squareGrasslandInstance.getSquareStatus()); // Status is GRASSLAND after
																							// OwnerID is set

		// Test that an exception is thrown if an owner id is set when an owner id is
		// already set
		e = assertThrows(IllegalArgumentException.class, () -> {
			squareGrasslandInstance.setInitialOwnerId(ownerIdOption3);
		});
		assertEquals("Another player already owns this square", e.getMessage());

		// Test that now the Initial Owner has been set the the ownership can be
		// transferred
		squareGrasslandInstance.transferOwnership(ownerIdOption3);
		assertEquals(123, squareGrasslandInstance.getOwnerId());

		// ----------------------- PART3 - ISquare -----------------------

		// An error should be thrown if the transferOwnership method is used before the
		// OwnerId has been set
		e = assertThrows(IllegalArgumentException.class, () -> {
			((Grassland) squareISquareInstance).transferOwnership(ownerIdOption1);
		});
		assertEquals("A player must currently own this square to transfer the ownership to another Player",
				e.getMessage());

		// Test setting the initial owner and updating the SquareStatus from VACANT to
		// GRASSLAND)
		assertEquals(SquareStatus.VACANT, ((Grassland) squareISquareInstance).getSquareStatus()); // Status is VACANT
																									// before OwnerID is
																									// set
		((Grassland) squareISquareInstance).setInitialOwnerId(ownerIdOption3);
		assertEquals(123, ((Grassland) squareISquareInstance).getOwnerId());
		assertEquals(SquareStatus.GRASSLAND, ((Grassland) squareISquareInstance).getSquareStatus()); // Status is
																										// GRASSLAND
																										// after OwnerID
																										// is set

		// Test that an exception is thrown if an owner id is set when an owner id is
		// already set
		e = assertThrows(IllegalArgumentException.class, () -> {
			((Grassland) squareISquareInstance).setInitialOwnerId(ownerIdOption1);
		});
		assertEquals("Another player already owns this square", e.getMessage());

		// Test that now the Initial Owner has been set the the ownership can be
		// transferred
		((Grassland) squareISquareInstance).transferOwnership(ownerIdOption1);
		assertEquals(1, ((Grassland) squareISquareInstance).getOwnerId());
	}

}
