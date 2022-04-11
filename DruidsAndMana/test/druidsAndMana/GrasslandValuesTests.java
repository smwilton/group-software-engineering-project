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
class GrasslandValuesTests {
	GrasslandValues grasslandValuesTest;

	int expectedTropicalPriceToBuy, expectedSubtropicalPriceToBuy, expectedTemperatePriceToBuy,
			expectedBorealPriceToBuy, expectedTropicalPriceToPlantForest, expectedSubtropicalPriceToPlantForest,
			expectedTemperatePriceToPlantForest, expectedBorealPriceToPlantForest,
			expectedTropicalPriceForWildlifeSanctuaryUpgrade, expectedSubtropicalPriceForWildlifeSanctuaryUpgrade,
			expectedTemperatePriceForWildlifeSanctuaryUpgrade, expectedBorealPriceForWildlifeSanctuaryUpgrade;

	int[] expectedTropicalCo2ValueSet, expectedSubtropicalCo2ValueSet, expectedTemperateCo2ValueSet,
			expectedBorealCo2ValueSet, expectedTropicalLandOnCostValueSet, expectedSubtropicalLandOnCostValueSet,
			expectedTemperateLandOnCostValueSet, expectedBorealLandOnCostValueSet;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		expectedTropicalPriceToBuy = 60;
		expectedSubtropicalPriceToBuy = 50;
		expectedTemperatePriceToBuy = 40;
		expectedBorealPriceToBuy = 30;

		expectedTropicalPriceToPlantForest = 12;
		expectedSubtropicalPriceToPlantForest = 10;
		expectedTemperatePriceToPlantForest = 8;
		expectedBorealPriceToPlantForest = 3;

		expectedTropicalPriceForWildlifeSanctuaryUpgrade = 60;
		expectedSubtropicalPriceForWildlifeSanctuaryUpgrade = 50;
		expectedTemperatePriceForWildlifeSanctuaryUpgrade = 40;
		expectedBorealPriceForWildlifeSanctuaryUpgrade = 30;

		expectedTropicalCo2ValueSet = new int[] { 60, 6, 20 };
		expectedSubtropicalCo2ValueSet = new int[] { 50, 5, 15 };
		expectedTemperateCo2ValueSet = new int[] { 40, 4, 10 };
		expectedBorealCo2ValueSet = new int[] { 30, 3, 5 };

		expectedTropicalLandOnCostValueSet = new int[] { 10, 4, 8 };
		expectedSubtropicalLandOnCostValueSet = new int[] { 9, 3, 4 };
		expectedTemperateLandOnCostValueSet = new int[] { 8, 2, 6 };
		expectedBorealLandOnCostValueSet = new int[] { 7, 1, 5 };
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.GrasslandValues#GrasslandValues(druidsAndMana.RealmTier)}.
	 * 
	 * Tests that the use of the constructor with each Reealm enum instantiates an
	 * instance of GrasslandValues
	 */
	@Test
	void testGrasslandValuesConstructor() {
		GrasslandValues tropicalValues = new GrasslandValues(RealmTier.TIER_1);
		assertTrue(tropicalValues instanceof GrasslandValues);

		GrasslandValues subtropicalValues = new GrasslandValues(RealmTier.TIER_2);
		assertTrue(tropicalValues instanceof GrasslandValues);

		GrasslandValues temperateValues = new GrasslandValues(RealmTier.TIER_3);
		assertTrue(tropicalValues instanceof GrasslandValues);

		GrasslandValues borealValues = new GrasslandValues(RealmTier.TIER_4);
		assertTrue(tropicalValues instanceof GrasslandValues);
	}

	// Testing of the TIER_1 RealmTier Values

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_1 RealmTier
	 */
	@Test
	void testGetPriceGrasslandTropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertEquals(expectedTropicalPriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_1 RealmTier
	 */
	@Test
	void testGetPriceForestTropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertEquals(expectedTropicalPriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 1 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_1 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertEquals(expectedTropicalPriceForWildlifeSanctuaryUpgrade, grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_1 RealmTier
	 */
	@Test
	void testGetCO2ValueSetTropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertArrayEquals(expectedTropicalCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 1 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_1 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetTropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_1);
		assertArrayEquals(expectedTropicalLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the TIER_2 RealmTier Values

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_2 RealmTier
	 */
	@Test
	void testGetPriceGrasslandSubtropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertEquals(expectedSubtropicalPriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_2 RealmTier
	 */
	@Test
	void testGetPriceForestSubtropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertEquals(expectedSubtropicalPriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 2 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_2 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuarySubtropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertEquals(expectedSubtropicalPriceForWildlifeSanctuaryUpgrade,
				grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_2 RealmTier
	 */
	@Test
	void testGetCO2ValueSetSubtropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertArrayEquals(expectedSubtropicalCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 2 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_2 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetSubtropical() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_2);
		assertArrayEquals(expectedSubtropicalLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the TIER_3 RealmTier Values

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_3 RealmTier
	 */
	@Test
	void testGetPriceGrasslandTemperate() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertEquals(expectedTemperatePriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_3 RealmTier
	 */
	@Test
	void testGetPriceForestTemperate() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertEquals(expectedTemperatePriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 3 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_3 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTemperate() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertEquals(expectedTemperatePriceForWildlifeSanctuaryUpgrade,
				grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_3 RealmTier
	 */
	@Test
	void testGetCO2ValueSetTemperate() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertArrayEquals(expectedTemperateCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 3 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_3 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetTemperate() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_3);
		assertArrayEquals(expectedTemperateLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the TIER_4 RealmTier Values

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the TIER_4 RealmTier
	 */
	@Test
	void testGetPriceGrasslandBoreal() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertEquals(expectedBorealPriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the TIER_4 RealmTier
	 */
	@Test
	void testGetPriceForestBoreal() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertEquals(expectedBorealPriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 4 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the TIER_4 RealmTier
	 */
	@Test
	void testGetPriceWildlifeSanctuaryBoreal() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertEquals(expectedBorealPriceForWildlifeSanctuaryUpgrade,
				grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the TIER_4 RealmTier
	 */
	@Test
	void testGetCO2ValueSetBoreal() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertArrayEquals(expectedBorealCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 4 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the TIER_4 RealmTier
	 */
	@Test
	void testGetCostToLandOnValueSetBoreal() {
		grasslandValuesTest = new GrasslandValues(RealmTier.TIER_4);
		assertArrayEquals(expectedBorealLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	
}
