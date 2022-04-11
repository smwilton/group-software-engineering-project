/**
 * 
 */
package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing of the GrasslandValues Class
 * 
 * @author Nicola Stirling 40020701
 *
 */
class GrasslandValuesTests {
	GrasslandValues grasslandValuesTest;

	int expectedTier1PriceToBuy, expectedTier2PriceToBuy, expectedTier3PriceToBuy, expectedTier4PriceToBuy,
			expectedTier1PriceToPlantForest, expectedTier2PriceToPlantForest, expectedTier3PriceToPlantForest,
			expectedTier4PriceToPlantForest, expectedTier1PriceForWildlifeSanctuaryUpgrade,
			expectedTier2PriceForWildlifeSanctuaryUpgrade, expectedTier3PriceForWildlifeSanctuaryUpgrade,
			expectedTier4PriceForWildlifeSanctuaryUpgrade;

	int[] expectedTier1Co2ValueSet, expectedTier2Co2ValueSet, expectedTier3Co2ValueSet, expectedTier4Co2ValueSet,
			expectedTier1LandOnCostValueSet, expectedTier2LandOnCostValueSet, expectedTier3LandOnCostValueSet,
			expectedTier4LandOnCostValueSet;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		expectedTier1PriceToBuy = 60;
		expectedTier2PriceToBuy = 50;
		expectedTier3PriceToBuy = 40;
		expectedTier4PriceToBuy = 30;

		expectedTier1PriceToPlantForest = 12;
		expectedTier2PriceToPlantForest = 10;
		expectedTier3PriceToPlantForest = 8;
		expectedTier4PriceToPlantForest = 3;

		expectedTier1PriceForWildlifeSanctuaryUpgrade = 60;
		expectedTier2PriceForWildlifeSanctuaryUpgrade = 50;
		expectedTier3PriceForWildlifeSanctuaryUpgrade = 40;
		expectedTier4PriceForWildlifeSanctuaryUpgrade = 30;

		expectedTier1Co2ValueSet = new int[] { 60, 6, 20 };
		expectedTier2Co2ValueSet = new int[] { 50, 5, 15 };
		expectedTier3Co2ValueSet = new int[] { 40, 4, 10 };
		expectedTier4Co2ValueSet = new int[] { 30, 3, 5 };

		expectedTier1LandOnCostValueSet = new int[] { 10, 4, 8 };
		expectedTier2LandOnCostValueSet = new int[] { 9, 3, 4 };
		expectedTier3LandOnCostValueSet = new int[] { 8, 2, 6 };
		expectedTier4LandOnCostValueSet = new int[] { 7, 1, 5 };
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.GrasslandValues#GrasslandValues(druidsAndMana.RealmTier)}.
	 * 
	 * Tests that the use of the constructor with each RealmTier enum instantiates
	 * an instance of GrasslandValues
	 */
	@Test
	void testGrasslandValuesConstructor() {
		GrasslandValues tier1Values = new GrasslandValues(RealmTier.TIER_1);
		assertTrue(tier1Values instanceof GrasslandValues);

		GrasslandValues tier2Values = new GrasslandValues(RealmTier.TIER_2);
		assertTrue(tier2Values instanceof GrasslandValues);

		GrasslandValues tier3Values = new GrasslandValues(RealmTier.TIER_3);
		assertTrue(tier1Values instanceof GrasslandValues);

		GrasslandValues tier4Values = new GrasslandValues(RealmTier.TIER_4);
		assertTrue(tier4Values instanceof GrasslandValues);
	}

	// Testing of the TIER_1 RealmTier Values

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_1 RealmTier
	 */
	@Test
	void testGetPriceGrasslandTier1() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertEquals(expectedTier1PriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_1 RealmTier
	 */
	@Test
	void testGetPriceForestTier1() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertEquals(expectedTier1PriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 1 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_1 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTier1() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertEquals(expectedTier1PriceForWildlifeSanctuaryUpgrade, grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_1 RealmTier
	 */
	@Test
	void testGetCO2ValueSetTier1() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertArrayEquals(expectedTier1Co2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 1 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_1 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetTier1() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertArrayEquals(expectedTier1LandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the TIER_2 RealmTier Values

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_2 RealmTier
	 */
	@Test
	void testGetPriceGrasslandTier2() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertEquals(expectedTier2PriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_2 RealmTier
	 */
	@Test
	void testGetPriceForestTier2() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertEquals(expectedTier2PriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 2 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_2 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTier2() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertEquals(expectedTier2PriceForWildlifeSanctuaryUpgrade, grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_2 RealmTier
	 */
	@Test
	void testGetCO2ValueSetTier2() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertArrayEquals(expectedTier2Co2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 2 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_2 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetTier2() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertArrayEquals(expectedTier2LandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the TIER_3 RealmTier Values

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_3 RealmTier
	 */
	@Test
	void testGetPriceGrasslandTier3() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertEquals(expectedTier3PriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_3 RealmTier
	 */
	@Test
	void testGetPriceForestTier3() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertEquals(expectedTier3PriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 3 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_3 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTier3() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertEquals(expectedTier3PriceForWildlifeSanctuaryUpgrade, grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_3 RealmTier
	 */
	@Test
	void testGetCO2ValueSetTier3() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertArrayEquals(expectedTier3Co2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 3 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_3 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetTier3() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertArrayEquals(expectedTier3LandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the TIER_4 RealmTier Values

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_4 RealmTier
	 */
	@Test
	void testGetPriceGrasslandTier4() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertEquals(expectedTier4PriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_4 RealmTier
	 */
	@Test
	void testGetPriceForestTier4() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertEquals(expectedTier4PriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 4 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_4 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTier4() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertEquals(expectedTier4PriceForWildlifeSanctuaryUpgrade, grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_4 RealmTier
	 */
	@Test
	void testGetCO2ValueSetTier4() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertArrayEquals(expectedTier4Co2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 4 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_4 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetTier4() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertArrayEquals(expectedTier4LandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

}
