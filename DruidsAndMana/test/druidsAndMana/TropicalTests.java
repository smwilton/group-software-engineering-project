/**
 * 
 */
package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Nicola
 *
 */
class TropicalTests {

	Tropical squareTropicalInstance, squareVacant, squareGrassland, squareSeedlingForest, squareIntermediateForest,
			squareEstablishedForest, squareWildlifeSanctuary;
	Grassland squareGrasslandInstance;
	ISquare squareISquareInstance;
	Realm realm;
	String expectedAsciiArt, expectedDescription;
	SquareStatus status1, status2, status3, status4, status5, status6;
	boolean isTrue, isFalse;
	int expectedPriceToBuy, expectedPriceToPlantForest, expectedPriceForWildlifeSanctuaryUpgrade,
			expectedCO2ImpactVacant, expectedCO2ImpactGrassland, expectedCO2ImpactSeedling,
			expectedCO2ImpactIntermediate, expectedCO2ImpactEstablished, expectedCO2ImpactWildlifeSanctuary,
			expectedLandOnCostVacant, expectedLandOnCostGrassland, expectedLandOnCostSeedling,
			expectedLandOnCostIntermediate, expectedLandOnCostEstablished, expectedLandOnCostWildlifeSanctuary;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		realm = Realm.Tropical;
		squareTropicalInstance = new Tropical(realm);
		squareGrasslandInstance = new Tropical(realm);
		squareISquareInstance = new Tropical(realm);
		expectedAsciiArt = "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
				+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
		expectedDescription = "The tropical grassland has a bustling and diverse ecosystem where each player will find harmony with Nature";
		status1 = SquareStatus.Vacant;
		status2 = SquareStatus.Grassland;
		status3 = SquareStatus.SeedlingForest;
		status4 = SquareStatus.IntermediateForest;
		status5 = SquareStatus.EstablishedForest;
		status6 = SquareStatus.WildlifeSanctuary;
		isTrue = true;
		isFalse = false;

		squareVacant = new Tropical(realm);
		squareGrassland = new Tropical(realm);
		squareGrassland.developGrassland(); // developing the square once to convert to a Grassland
		squareSeedlingForest = new Tropical(realm);
		squareSeedlingForest.developGrassland();
		squareSeedlingForest.developGrassland(); // developing the square twice to convert to a SeedlingForest (1 minor
													// development)
		squareIntermediateForest = new Tropical(realm);
		squareIntermediateForest.developGrassland();
		squareIntermediateForest.developGrassland();
		squareIntermediateForest.developGrassland();// developing the square three times to convert to a
													// IntermediateForest (2 minor developments)
		squareEstablishedForest = new Tropical(realm);
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland();
		squareEstablishedForest.developGrassland(); // developing the square four times to convert to a
													// EstablishedForest (3 minor developments)
		squareWildlifeSanctuary = new Tropical(realm);
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland();
		squareWildlifeSanctuary.developGrassland(); // developing the square five times to convert to a
													// EstablishedForest (1 major development)

		expectedPriceToBuy = 60;
		expectedPriceToPlantForest = 12;
		expectedPriceForWildlifeSanctuaryUpgrade = 60;
		expectedCO2ImpactVacant = 0;
		expectedCO2ImpactGrassland = 60;
		expectedCO2ImpactSeedling = 66;
		expectedCO2ImpactIntermediate = 72;
		expectedCO2ImpactEstablished = 78;
		expectedCO2ImpactWildlifeSanctuary = 98;
		expectedLandOnCostVacant = 0;
		expectedLandOnCostGrassland = 10;
		expectedLandOnCostSeedling = 14;
		expectedLandOnCostIntermediate = 18;
		expectedLandOnCostEstablished = 22;
		expectedLandOnCostWildlifeSanctuary = 30;
	}

	/**
	 * Test method for {@link druidsAndMana.Tropical#Tropical(druidsAndMana.Realm)}.
	 */
	@Test
	void testConstructor() {
		assertTrue(squareTropicalInstance instanceof ISquare);
		assertTrue(squareTropicalInstance instanceof Grassland);
		assertTrue(squareTropicalInstance instanceof Tropical);

		assertTrue(squareGrasslandInstance instanceof ISquare);
		assertTrue(squareGrasslandInstance instanceof Grassland);
		assertTrue(squareGrasslandInstance instanceof Tropical);

		assertTrue(squareISquareInstance instanceof ISquare);
		assertTrue(squareISquareInstance instanceof Grassland);
		assertTrue(squareISquareInstance instanceof Tropical);
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#developmentCost()}.
	 * <p>
	 * Tests the developmentCost method returns the expected value for each stage in
	 * the squares development
	 */
	@Test
	void testDevelopmentCost() {
		// Vacant square should return the price to buy
		assertEquals(expectedPriceToBuy, squareVacant.developmentCost());

		// Grassland, SeedlingForest, and IntermediateForest should return the price to
		// plant a forest
		assertEquals(expectedPriceToPlantForest, squareGrassland.developmentCost());
		assertEquals(expectedPriceToPlantForest, squareSeedlingForest.developmentCost());
		assertEquals(expectedPriceToPlantForest, squareIntermediateForest.developmentCost());

		// EstablishedForest should return the price to upgrade to a WildlifeSanctuary
		assertEquals(expectedPriceForWildlifeSanctuaryUpgrade, squareEstablishedForest.developmentCost());

		// WildlifeSanctuary should return 0 as development option have been fully
		// exhausted
		assertEquals(0, squareWildlifeSanctuary.developmentCost());
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
		assertEquals(expectedLandOnCostVacant, squareVacant.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostGrassland, squareGrassland.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostSeedling, squareSeedlingForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostIntermediate, squareIntermediateForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostEstablished, squareEstablishedForest.getChargeForLandingOnSquare());
		assertEquals(expectedLandOnCostWildlifeSanctuary, squareWildlifeSanctuary.getChargeForLandingOnSquare());
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getCo2ImpactRating()}.
	 * <p>
	 * Tests the getCo2ImpactRating method returns the expected value for each stage
	 * in the squares development
	 */
	@Test
	void testGetCo2ImpactRating() {
		assertEquals(expectedCO2ImpactVacant, squareVacant.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactGrassland, squareGrassland.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactSeedling, squareSeedlingForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactIntermediate, squareIntermediateForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactEstablished, squareEstablishedForest.getCo2ImpactRating());
		assertEquals(expectedCO2ImpactWildlifeSanctuary, squareWildlifeSanctuary.getCo2ImpactRating());
	}

	/**
	 * Test method for {@link druidsAndMana.Grassland#getSquareStatus()} and
	 * {@link druidsAndMana.Grassland#canDevelopGrassland()} and
	 * {@link druidsAndMana.Grassland#developGrassland()}.
	 * <p>
	 * Tests that the getSquareStatus, canDevelopGrassland and DevelopGrassland
	 * methods behaves as expected as even stage throughout the squares development.
	 * <p>
	 * This test has been performed for each square instance to ensure the methods
	 * behave as expected regardless of how it has been declared (i.e. using
	 * ISquare, Grassland or Tropical).
	 */
	@Test
	void testGetSquareStatusAndCanDevelopGrasslandAndDevelopGrassland() {
		// when a square instance is declared the status is set to Vacant
		assertEquals(status1, squareTropicalInstance.getSquareStatus());
		assertEquals(status1, squareGrasslandInstance.getSquareStatus());
		assertEquals(status1, ((Grassland) squareISquareInstance).getSquareStatus());
		assertEquals(isTrue, squareTropicalInstance.canDevelopGrassland());
		assertEquals(isTrue, squareGrasslandInstance.canDevelopGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).canDevelopGrassland());

		/*
		 * When a square is developed it should update the status to the next one and
		 * the developGrassland() method returns true. The canDevelopGrassland() method
		 * should return true for all status's except for when the status is set to
		 * WildLifeReserve
		 */

		// Updating from Vacant to Grassland
		assertEquals(isTrue, squareTropicalInstance.developGrassland());
		assertEquals(isTrue, squareGrasslandInstance.developGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status2, squareTropicalInstance.getSquareStatus());
		assertEquals(status2, squareGrasslandInstance.getSquareStatus());
		assertEquals(status2, ((Grassland) squareISquareInstance).getSquareStatus());
		assertEquals(isTrue, squareTropicalInstance.canDevelopGrassland());
		assertEquals(isTrue, squareGrasslandInstance.canDevelopGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from Grassland to SeedlingForest
		assertEquals(isTrue, squareTropicalInstance.developGrassland());
		assertEquals(isTrue, squareGrasslandInstance.developGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status3, squareTropicalInstance.getSquareStatus());
		assertEquals(status3, squareGrasslandInstance.getSquareStatus());
		assertEquals(status3, ((Grassland) squareISquareInstance).getSquareStatus());
		assertEquals(isTrue, squareTropicalInstance.canDevelopGrassland());
		assertEquals(isTrue, squareGrasslandInstance.canDevelopGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from SeedlingForest to IntermediateForest
		assertEquals(isTrue, squareTropicalInstance.developGrassland());
		assertEquals(isTrue, squareGrasslandInstance.developGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status4, squareTropicalInstance.getSquareStatus());
		assertEquals(status4, squareGrasslandInstance.getSquareStatus());
		assertEquals(status4, ((Grassland) squareISquareInstance).getSquareStatus());
		assertEquals(isTrue, squareTropicalInstance.canDevelopGrassland());
		assertEquals(isTrue, squareGrasslandInstance.canDevelopGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from IntermediateForest to EstablisedForest
		assertEquals(isTrue, squareTropicalInstance.developGrassland());
		assertEquals(isTrue, squareGrasslandInstance.developGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status5, squareTropicalInstance.getSquareStatus());
		assertEquals(status5, squareGrasslandInstance.getSquareStatus());
		assertEquals(status5, ((Grassland) squareISquareInstance).getSquareStatus());
		assertEquals(isTrue, squareTropicalInstance.canDevelopGrassland());
		assertEquals(isTrue, squareGrasslandInstance.canDevelopGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).canDevelopGrassland());

		// Updating from EstablishedForest to WildlifeReserve
		assertEquals(isTrue, squareTropicalInstance.developGrassland());
		assertEquals(isTrue, squareGrasslandInstance.developGrassland());
		assertEquals(isTrue, ((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status6, squareTropicalInstance.getSquareStatus());
		assertEquals(status6, squareGrasslandInstance.getSquareStatus());
		assertEquals(status6, ((Grassland) squareISquareInstance).getSquareStatus());
		assertEquals(isFalse, squareTropicalInstance.canDevelopGrassland());
		assertEquals(isFalse, squareGrasslandInstance.canDevelopGrassland());
		assertEquals(isFalse, ((Grassland) squareISquareInstance).canDevelopGrassland());

		// Trying to update the WildlifeSanctuary should return false and the status
		// should remain as WildlifeSanctuary
		assertEquals(isFalse, squareTropicalInstance.developGrassland());
		assertEquals(isFalse, squareGrasslandInstance.developGrassland());
		assertEquals(isFalse, ((Grassland) squareISquareInstance).developGrassland());
		assertEquals(status6, squareTropicalInstance.getSquareStatus());
		assertEquals(status6, squareGrasslandInstance.getSquareStatus());
		assertEquals(status6, ((Grassland) squareISquareInstance).getSquareStatus());
	}

	/**
	 * Test method for {@link druidsAndMana.Tropical#description()}.
	 * <p>
	 * Tests that the description for each square instance is as expected regardless
	 * of how it has been declared (i.e. using ISquare, Grassland or Tropical.
	 * It has also been performed for a square at each stage of the development
	 * cycle to ensure it behaves as expected regardless of how many developments
	 * have been applied
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
	 * of how it has been declared (i.e. using ISquare, Grassland or Tropical).
	 * It has also been performed for a square at each stage of the development
	 * cycle to ensure it behaves as expected regardless of how many developments
	 * have been applied
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
	 * {@link druidsAndMana.Grassland#setOwnerId(java.lang.String)} and
	 * {@link druidsAndMana.Grassland#getOwnerId()}.
	 */
	@Test
	void testSetAndGetOwnerId() {
		// TODO
		fail("Not yet implemented");
	}

}
