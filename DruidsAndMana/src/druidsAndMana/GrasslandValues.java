package druidsAndMana;

/**
 * Class that contains all the values relating to the types of Grassland
 * 
 * @author Nicola Stirling 40020701
 *
 */
public class GrasslandValues {

	/**
	 * A 2D Array that contains all the values needed for each realm.
	 * 
	 * The first dimension of the allValues array represents the realm the array of
	 * values is for.
	 * 
	 * Index 0: This is the Tropical Realm Values. It is the most expensive.
	 * 
	 * Index 1: This is the Subtropical Realm Values. It is the second most
	 * expensive.
	 * 
	 * Index 2: This is the Temperate Realm Values. It is the second least
	 * expensive.
	 * 
	 * Index 3: This is the Boreal Realm Values. It is the least expensive.
	 * 
	 *
	 * For the second dimension of the allValues array provides the values for each
	 * realm, each value represents a different value requires as follows:
	 *
	 * Index 0: Price to Buy Grassland - This is the initial Mana price that a
	 * Player will pay to purchase a grassland
	 *
	 * Index 1: Price to plant a forest (i.e. make a minor development)- This is the
	 * Mana price that a Player will pay to plant a forest on a grassland
	 *
	 * Index 2: Price to upgrade to a Wildlife Sanctuary (i.e. make a major
	 * development) - This is the Mana price that a Player will pay to upgrade to a
	 * Wildlife Reserve
	 *
	 * Index 3: CO2 impact base - This is the base CO2 impact rating earned for an
	 * owned Grassland that has no developments
	 * 
	 * Index 4: CO2 minor development premium - This is the additional CO2 impact
	 * rating earned for each minor development on a Grassland, i.e. for each forest
	 * that is planted a Player will earn this in addition to the base CO2 Impact.
	 * 
	 * Index 5: CO2 major development premium - This is the additional CO2 impact
	 * rating earned when a major development is made to a Grassland, This is earned
	 * in addition to 3 x the minor development premium and the base amount
	 * 
	 * Index 6: Base cost to a player landing on a Grassland not owned by them -
	 * This is the Mana charge to a player for landing on the grassland if it is
	 * owned by another player and has no developments made to it
	 * 
	 * Index 7: Minor development premium to a player landing on a Grassland not
	 * owned by them - This is the additional Mana charge per forest planted in
	 * addition to the base cost to a player for landing on the grassland if it is
	 * owned by another player, e.g. if a grassland has 2 forests planted on it the
	 * cost of landing on the grassland is the base cost + 2 x this minor
	 * development premium
	 * 
	 * Index 8: Major development premium to a player landing on a Grassland not
	 * owned by them - This is the additional Mana charge for landing on a grassland
	 * that has been upgraded to a Wildlife Sanctuary if it is owned by another
	 * player. This is added to the base costs and 3 x the Minor development premium
	 * e.g. if a grassland has been upgraded to a Wildlife reserve the cost of
	 * landing on the grassland is the base cost + 3 x this minor development
	 * premium + 1 x the major development premium
	 */
	private static final int[][] ALL_VALUES = { { 60, 12, 60, 60, 6, 20, 10, 4, 8 }, // Realm 1 - Tropical @ index 0
			{ 50, 10, 50, 50, 5, 15, 9, 3, 4 }, // Realm 2 - Subtropical @ index 1
			{ 40, 8, 40, 40, 4, 10, 8, 2, 6 }, // Realm 3 - Temperate @ index 2
			{ 30, 3, 30, 30, 3, 5, 7, 1, 5 } // Realm 4 - Boreal @ index 3
			/*
			 * { Value 1 - Grassland Price @ index 0, Value 2 - Plant Forest Price @ index
			 * 1, Value 3 - Wildlife Sanctuary Price @ index 2, Value 4 - CO2 base @ index
			 * 3, Value 5 - CO2 minor development premium @ index 4, Value 6 - CO2 major
			 * development premium @ index 5, Value 7 - Price to Land on base @ index 6,
			 * Value 8 - Price to Land on minor development premium @ index 7, Value 9 -
			 * Price to Land on major development premium @ index 8 }
			 */
	};
	/*
	 * This considers game growth as additional arrays can be added to the 1st
	 * dimension, or if additional values required these can be added to the 2nd
	 * dimension
	 */

	// Instance Vars
	private int[] valueSet;

	// Constructor
	/**
	 * @param valueSet
	 */
	public GrasslandValues(Realm realm) {
		this.setValueSet(realm);
	}

	// Methods

	private void setValueSet(Realm realm) {
		switch (realm) {
		case Tropical:
			this.valueSet = ALL_VALUES[0];
			break;
		case Subtropical:
			this.valueSet = ALL_VALUES[1];
			break;
		case Temperate:
			this.valueSet = ALL_VALUES[2];
			break;
		case Boreal:
			this.valueSet = ALL_VALUES[3];
			break; // design decision not to include a default case as a realm can only be one of
					// the 4 enum values
		}
	}

	/**
	 * Gets the price to land on the Grassland of the given realm
	 * 
	 * @return - the Mana price to buy the Grassland
	 */
	public int getPriceGrassland() {
		return valueSet[0];
	}

	/**
	 * Gets the price to plant a forest on the Grassland of the given realm
	 * 
	 * @return - the Mana price to plant 1 forest
	 */
	public int getPriceForest() {
		return valueSet[1];
	}

	/**
	 * Gets the price to upgrade to a Wildlife Sanctuary of the given realm
	 * 
	 * @return - the Mana price to upgrade to a Wildlife Sanctuary
	 */
	public int getPriceWildlifeSanctuary() {
		return valueSet[2];
	}

	/**
	 * Gets the 3 CO2 Impact Rating tiers in order to calculate the total CO2 Impact
	 * Rating depending on the SquareStatus of a Grassland
	 * 
	 * @return - an int[] of values where index 0 is the base CO2 impact rating,
	 *         index 1 is the additional impact rating of each forest that is
	 *         planted, and index 2 is the additional impact rating earned for a
	 *         Wildlife Sanctuary
	 * 
	 *         Example usage of this value Set:
	 * 
	 *         Example 1: For a Grassland with no developments use only the value at
	 *         index 0
	 * 
	 *         Example 2: For a Grassland with 2 forests planted take the value at
	 *         index 0 + 2x the value at index 1
	 * 
	 *         Example 3: For a Grassland that has been upgraded to a Wildlife
	 *         Sanctuary take the value at index 0 + 3x the value at index 1 + 1x
	 *         the value at index 2 (this is the maximum CO2 rating that should be
	 *         calculated using this value set)
	 */
	public int[] getCO2ValueSet() {
		int[] values = { valueSet[3], valueSet[4], valueSet[5] };
		return values;
	}

	/**
	 * Gets the 3 Cost tiers of a Player landing on a Grassland that is owned by
	 * another player so the total cost can be calculated depending on the
	 * SquareStatus of a Grassland
	 * 
	 * @return - an int[] of values where index 0 is the base Cost of landing on an
	 *         empty Grassland, index 1 is the additional cost for each forest that
	 *         is planted on that Grassland, and index 2 is the additional cost
	 *         where the Grassland has been upgraded to a Wildlife Sanctuary
	 * 
	 *         Example usage of this value Set:
	 * 
	 *         Example 1: For a Grassland with no developments use only the value at
	 *         index 0
	 * 
	 *         Example 2: For a Grassland with 2 forests planted take the value at
	 *         index 0 + 2x the value at index 1
	 * 
	 *         Example 3: For a Grassland that has been upgraded to a Wildlife
	 *         Sanctuary take the value at index 0 + 3x the value at index 1 + 1x
	 *         the value at index 2 (this is the maximum cost that should be
	 *         calculated using this value set)
	 */
	public int[] getCostToLandOnValueSet() {
		int[] values = { valueSet[6], valueSet[7], valueSet[8] };
		return values;
	}
}
