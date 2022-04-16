package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Testing of the Temperate Class.
 * <p>
 * See TropicalTest where the implementation has been tested as ISquare and
 * Grassland.
 * 
 * @author Nicola
 *
 */
class TemperateTests {

	Temperate squareVacant, squareGrassland, squareSeedlingForest, squareIntermediateForest, squareEstablishedForest,
			squareWildlifeSanctuary;
	RealmTier realmTier3;
	String expectedAsciiArt, expectedDescription;
	SquareStatus status1, status2, status3, status4, status5, status6;
	int expectedPriceToBuyTier3, expectedPriceToPlantForestTier3, expectedPriceForWildlifeSanctuaryUpgradeTier3,
			expectedCO2ImpactVacantTier3, expectedCO2ImpactGrasslandTier3, expectedCO2ImpactSeedlingTier3,
			expectedCO2ImpactIntermediateTier3, expectedCO2ImpactEstablishedTier3,
			expectedCO2ImpactWildlifeSanctuaryTier3, expectedLandOnCostVacantTier3, expectedLandOnCostGrasslandTier3,
			expectedLandOnCostSeedlingTier3, expectedLandOnCostIntermediateTier3, expectedLandOnCostEstablishedTier3,
			expectedLandOnCostWildlifeSanctuaryTier3,ownerIdOption1, ownerIdOption2;
	int[] values;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		realmTier3 = RealmTier.TIER_3;

		expectedAsciiArt = " ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\r\n"
				+ "/|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
		expectedDescription = "Temperate grasslands experience heavy rainfall but also periods of drought, giving a highly diverse ecosystem";
		status1 = SquareStatus.VACANT;
		status2 = SquareStatus.GRASSLAND;
		status3 = SquareStatus.SEEDLING_FOREST;
		status4 = SquareStatus.INTERMEDIATE_FOREST;
		status5 = SquareStatus.ESTABLISHED_FOREST;
		status6 = SquareStatus.WILDLIFE_SANCTUARY;

		squareVacant = new Temperate(realmTier3);

		squareGrassland = new Temperate(realmTier3);
		squareGrassland.developGrassland(); // developing the square once to convert to a GRASSLAND

		squareSeedlingForest = new Temperate(realmTier3);
		squareSeedlingForest.developGrassland();
		squareSeedlingForest.developGrassland(); // developing the square twice to convert to a SEEDLING_FOREST (1 minor
													// development)
		squareIntermediateForest = new Temperate(realmTier3);
		squareIntermediateForest.developGrassland();
		squareIntermediateForest.developGrassland();
		squareIntermediateForest.developGrassland();// developing the square three times to convert to a
													// INTERMEDIATE_FOREST (2 minor developments)
		squareEstablishedForest = new Temperate(realmTier3);
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland(); // developing the square four times to convert to a
													// ESTABLISHED_FOREST (3 minor developments)
		squareWildlifeSanctuary = new Temperate(realmTier3);
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland(); // developing the square five times to convert to a
													// ESTABLISHED_FOREST (1 major development)
		// This is the Tier 3 values
		values = new int[] { 140, 70, 140, 15, 100, 200, 10, 70, 240 };
		expectedPriceToBuyTier3 = values[0];
		expectedPriceToPlantForestTier3 = values[1];
		expectedPriceForWildlifeSanctuaryUpgradeTier3 = values[2];
		expectedCO2ImpactVacantTier3 = 0;
		expectedCO2ImpactGrasslandTier3 = values[3];
		expectedCO2ImpactSeedlingTier3 = (values[3]+values[4]);
		expectedCO2ImpactIntermediateTier3 = (values[3]+(2*values[4]));
		expectedCO2ImpactEstablishedTier3 = (values[3]+(3*values[4]));
		expectedCO2ImpactWildlifeSanctuaryTier3 = (values[3]+(3*values[4])+ values[5]);
		expectedLandOnCostVacantTier3 = 0;
		expectedLandOnCostGrasslandTier3 = values[6];
		expectedLandOnCostSeedlingTier3 = (values[6]+values[7]);
		expectedLandOnCostIntermediateTier3 = (values[6]+(2*values[7]));
		expectedLandOnCostEstablishedTier3 = (values[6]+(3*values[7]));
		expectedLandOnCostWildlifeSanctuaryTier3 = (values[6]+(3*values[7])+values[8]);

		ownerIdOption1 = 1;
		ownerIdOption2 = 123;

	}

	/**
	 * Test method for {@link druidsAndMana.Temperate#description()}.
	 * <p>
	 * Tests the description at each stage of the development cycle to ensure it
	 * behaves as expected regardless of how many developments have been applied
	 */
	@Test
	void testDescription() {
		assertEquals(expectedDescription, squareVacant.description());
		assertEquals(expectedDescription, squareGrassland.description());
		assertEquals(expectedDescription, squareSeedlingForest.description());
		assertEquals(expectedDescription, squareIntermediateForest.description());
		assertEquals(expectedDescription, squareEstablishedForest.description());
		assertEquals(expectedDescription, squareWildlifeSanctuary.description());
	}

	/**
	 * Test method for {@link druidsAndMana.Temperate#asciiArt()}.
	 * <p>
	 * Tests the ascii art at each stage of the development cycle to ensure it
	 * behaves as expected regardless of how many developments have been applied
	 */
	@Test
	void testAsciiArt() {
		assertEquals(expectedAsciiArt, squareVacant.asciiArt());
		assertEquals(expectedAsciiArt, squareGrassland.asciiArt());
		assertEquals(expectedAsciiArt, squareSeedlingForest.asciiArt());
		assertEquals(expectedAsciiArt, squareIntermediateForest.asciiArt());
		assertEquals(expectedAsciiArt, squareEstablishedForest.asciiArt());
		assertEquals(expectedAsciiArt, squareWildlifeSanctuary.asciiArt());
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.Temperate#Temperate(druidsAndMana.RealmTier)}.
	 * <p>
	 * Tests that the constructor sets the initial square status as VACANT, that the
	 * ownerId is null and that for each RealmTier the correct the correct
	 * priceToBuy is set
	 */
	@ParameterizedTest(name = "{index} => a={0}, b={1}")
	@CsvSource({ "TIER_1 , 300", "TIER_2 , 220", "TIER_3 , 140", "TIER_4 , 60" })
	void testConstructor(RealmTier realmTier, int expectedPriceToBuy) {
		Temperate square1 = new Temperate(realmTier);
		// Testing constructor is an instance of the ISquare interface, Grassland Class
		// and Tropical Class
		assertTrue(square1 instanceof ISquare);
		assertTrue(square1 instanceof Grassland);
		assertTrue(square1 instanceof Temperate);
		// Testing constructor set the status to VACANT
		assertEquals(status1, square1.getSquareStatus());
		// Testing the constructor set the Values using the private method by getting
		// the price to buy
		assertEquals(expectedPriceToBuy, square1.getDevelopmentCost());
		// Testing that owner's id is null initially
		assertEquals(0,square1.getOwnerId());
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

		// An error should be thrown if the transferOwnership method is used before the
		// OwnerId has been set
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			squareVacant.transferOwnership(ownerIdOption2);
		});
		assertEquals("A player must currently own this square to transfer the ownership to another Player",
				e.getMessage());

		// Test setting the initial owner and updating the SquareStatus from VACANT to
		// GRASSLAND)
		assertEquals(SquareStatus.VACANT, squareVacant.getSquareStatus()); // Status is VACANT before OwnerID
																			// is set
		squareVacant.setInitialOwnerId(ownerIdOption1);
		assertEquals(1, squareVacant.getOwnerId());
		assertEquals(SquareStatus.GRASSLAND, squareVacant.getSquareStatus()); // Status is GRASSLAND after
																				// OwnerID is set

		// Test that an exception is thrown if an owner id is set when an owner id is
		// already set
		e = assertThrows(IllegalArgumentException.class, () -> {
			squareVacant.setInitialOwnerId(ownerIdOption2);
		});
		assertEquals("Another player already owns this square", e.getMessage());

		// Test that now the Initial Owner has been set the the ownership can be
		// transferred
		squareVacant.transferOwnership(ownerIdOption2);
		assertEquals(123, squareVacant.getOwnerId());

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
		assertEquals(expectedPriceToBuyTier3, squareVacant.getDevelopmentCost());

		// GRASSLAND, SEEDLING_FOREST, and INTERMEDIATE_FOREST should return the price
		// to
		// plant a forest
		assertEquals(expectedPriceToPlantForestTier3, squareGrassland.getDevelopmentCost());
		assertEquals(expectedPriceToPlantForestTier3, squareSeedlingForest.getDevelopmentCost());
		assertEquals(expectedPriceToPlantForestTier3, squareIntermediateForest.getDevelopmentCost());

		// ESTABLISHED_FOREST should return the price to upgrade to a WILDLIFE_SANCTUARY
		assertEquals(expectedPriceForWildlifeSanctuaryUpgradeTier3, squareEstablishedForest.getDevelopmentCost());

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
		assertEquals(expectedLandOnCostVacantTier3, squareVacant.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostGrasslandTier3, squareGrassland.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostSeedlingTier3, squareSeedlingForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostIntermediateTier3, squareIntermediateForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostEstablishedTier3, squareEstablishedForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostWildlifeSanctuaryTier3, squareWildlifeSanctuary.getChargeForLandingOnSquare());
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getCo2ImpactRating()}.
	 * <p>
	 * Tests the getCo2ImpactRating method returns the expected value for each stage
	 * in the squares development
	 */
	@Test
	void testGetCo2ImpactRating() {
		assertEquals(expectedCO2ImpactVacantTier3, squareVacant.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactGrasslandTier3, squareGrassland.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactSeedlingTier3, squareSeedlingForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactIntermediateTier3, squareIntermediateForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactEstablishedTier3, squareEstablishedForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactWildlifeSanctuaryTier3, squareWildlifeSanctuary.getCo2ImpactRating());
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getSquareStatus()} and
	 * {@link druidsAndMana.Grassland#canDevelopGrassland()} and
	 * {@link druidsAndMana.Grassland#developGrassland()}.
	 * <p>
	 * Tests that the getSquareStatus, canDevelopGrassland and DevelopGrassland
	 * methods behaves as expected as each stage throughout the squares development
	 * and that the square development is applied as expected.
	 */
	@Test
	void testSquareDevelopment() {
		// when a square instance is declared the status is set to VACANT
		assertEquals(status1, squareVacant.getSquareStatus());
		assertTrue(squareVacant.canDevelopGrassland());

		/*
		 * When a square is developed it should update the status to the next one and
		 * the developGrassland() method returns true. The canDevelopGrassland() method
		 * should return true for all status's except for when the status is set to
		 * WildLifeReserve
		 */

		// Updating from VACANT to GRASSLAND
		assertTrue(squareVacant.developGrassland());
		assertEquals(status2, squareVacant.getSquareStatus());
		assertTrue(squareVacant.canDevelopGrassland());

		// Updating from GRASSLAND to SEEDLING_FOREST
		assertTrue(squareVacant.developGrassland());
		assertEquals(status3, squareVacant.getSquareStatus());
		assertTrue(squareVacant.canDevelopGrassland());

		// Updating from SEEDLING_FOREST to INTERMEDIATE_FOREST
		assertTrue(squareVacant.developGrassland());
		assertEquals(status4, squareVacant.getSquareStatus());
		assertTrue(squareVacant.canDevelopGrassland());

		// Updating from INTERMEDIATE_FOREST to EstablisedForest
		assertTrue(squareVacant.developGrassland());
		assertEquals(status5, squareVacant.getSquareStatus());
		assertTrue(squareVacant.canDevelopGrassland());

		// Updating from ESTABLISHED_FOREST to WildlifeReserve
		assertTrue(squareVacant.developGrassland());
		assertEquals(status6, squareVacant.getSquareStatus());
		assertFalse(squareVacant.canDevelopGrassland());

		// Trying to update the WILDLIFE_SANCTUARY should return false and the status
		// should remain as WILDLIFE_SANCTUARY
		assertFalse(squareVacant.developGrassland());
		assertEquals(status6, squareVacant.getSquareStatus());
	}

}