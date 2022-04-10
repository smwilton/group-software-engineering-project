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
	 * {@link druidsAndMana.GrasslandValues#GrasslandValues(druidsAndMana.Realm)}.
	 * 
	 * Tests that the use of the constructor with each Reealm enum instantiates an
	 * instance of GrasslandValues
	 */
	@Test
	void testGrasslandValuesConstructor() {
		GrasslandValues tropicalValues = new GrasslandValues(Realm.Tropical);
		assertTrue(tropicalValues instanceof GrasslandValues);

		GrasslandValues subtropicalValues = new GrasslandValues(Realm.Subtropical);
		assertTrue(tropicalValues instanceof GrasslandValues);

		GrasslandValues temperateValues = new GrasslandValues(Realm.Temperate);
		assertTrue(tropicalValues instanceof GrasslandValues);

		GrasslandValues borealValues = new GrasslandValues(Realm.Boreal);
		assertTrue(tropicalValues instanceof GrasslandValues);
	}

	// Testing of the Tropical Realm Values

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the Tropical Realm
	 */
	@Test
	void testGetPriceGrasslandTropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Tropical);
		assertEquals(expectedTropicalPriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the Tropical Realm
	 */
	@Test
	void testGetPriceForestTropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Tropical);
		assertEquals(expectedTropicalPriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 1 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the Tropical Realm
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Tropical);
		assertEquals(expectedTropicalPriceForWildlifeSanctuaryUpgrade, grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 1 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the Tropical Realm
	 */
	@Test
	void testGetCO2ValueSetTropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Tropical);
		assertArrayEquals(expectedTropicalCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 1 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the Tropical Realm
	 */
	@Test
	void testGetCostToLandOnValueSetTropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Tropical);
		assertArrayEquals(expectedTropicalLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the Subtropical Realm Values

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the Subtropical Realm
	 */
	@Test
	void testGetPriceGrasslandSubtropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Subtropical);
		assertEquals(expectedSubtropicalPriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the Subtropical Realm
	 */
	@Test
	void testGetPriceForestSubtropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Subtropical);
		assertEquals(expectedSubtropicalPriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 2 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the Subtropical Realm
	 */
	@Test
	void testGetPriceWildlifeSanctuarySubtropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Subtropical);
		assertEquals(expectedSubtropicalPriceForWildlifeSanctuaryUpgrade,
				grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 2 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the Subtropical Realm
	 */
	@Test
	void testGetCO2ValueSetSubtropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Subtropical);
		assertArrayEquals(expectedSubtropicalCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 2 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the Subtropical Realm
	 */
	@Test
	void testGetCostToLandOnValueSetSubtropical() {
		grasslandValuesTest = new GrasslandValues(Realm.Subtropical);
		assertArrayEquals(expectedSubtropicalLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the Temperate Realm Values

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the Temperate Realm
	 */
	@Test
	void testGetPriceGrasslandTemperate() {
		grasslandValuesTest = new GrasslandValues(Realm.Temperate);
		assertEquals(expectedTemperatePriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the Temperate Realm
	 */
	@Test
	void testGetPriceForestTemperate() {
		grasslandValuesTest = new GrasslandValues(Realm.Temperate);
		assertEquals(expectedTemperatePriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 3 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the Temperate Realm
	 */
	@Test
	void testGetPriceWildlifeSanctuaryTemperate() {
		grasslandValuesTest = new GrasslandValues(Realm.Temperate);
		assertEquals(expectedTemperatePriceForWildlifeSanctuaryUpgrade,
				grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 3 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the Temperate Realm
	 */
	@Test
	void testGetCO2ValueSetTemperate() {
		grasslandValuesTest = new GrasslandValues(Realm.Temperate);
		assertArrayEquals(expectedTemperateCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 3 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the Temperate Realm
	 */
	@Test
	void testGetCostToLandOnValueSetTemperate() {
		grasslandValuesTest = new GrasslandValues(Realm.Temperate);
		assertArrayEquals(expectedTemperateLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	// Testing of the Boreal Realm Values

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getPriceGrassland()}.
	 * 
	 * Tests the getPriceGrassland method for the Boreal Realm
	 */
	@Test
	void testGetPriceGrasslandBoreal() {
		grasslandValuesTest = new GrasslandValues(Realm.Boreal);
		assertEquals(expectedBorealPriceToBuy, grasslandValuesTest.getPriceGrassland());
	}

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getPriceForest()}.
	 * 
	 * Tests the getPriceForest method for the Boreal Realm
	 */
	@Test
	void testGetPriceForestBoreal() {
		grasslandValuesTest = new GrasslandValues(Realm.Boreal);
		assertEquals(expectedBorealPriceToPlantForest, grasslandValuesTest.getPriceForest());
	}

	/**
	 * Test method 4 for
	 * {@link druidsAndMana.GrasslandValues#getPriceWildlifeSanctuary()}.
	 * 
	 * Tests the getPriceWildlifeSanctuary method for the Boreal Realm
	 */
	@Test
	void testGetPriceWildlifeSanctuaryBoreal() {
		grasslandValuesTest = new GrasslandValues(Realm.Boreal);
		assertEquals(expectedBorealPriceForWildlifeSanctuaryUpgrade,
				grasslandValuesTest.getPriceWildlifeSanctuary());
	}

	/**
	 * Test method 4 for {@link druidsAndMana.GrasslandValues#getCO2ValueSet()}.
	 * 
	 * Tests the getCO2ValueSet method for the Boreal Realm
	 */
	@Test
	void testGetCO2ValueSetBoreal() {
		grasslandValuesTest = new GrasslandValues(Realm.Boreal);
		assertArrayEquals(expectedBorealCo2ValueSet, grasslandValuesTest.getCO2ValueSet());
	}

	/**
	 * Test method 4 for
	 * {@link druidsAndMana.GrasslandValues#getCostToLandOnValueSet()}.
	 * 
	 * Tests the getCostToLandOnValueSet method for the Boreal Realm
	 */
	@Test
	void testGetCostToLandOnValueSetBoreal() {
		grasslandValuesTest = new GrasslandValues(Realm.Boreal);
		assertArrayEquals(expectedBorealLandOnCostValueSet, grasslandValuesTest.getCostToLandOnValueSet());
	}

	
}
