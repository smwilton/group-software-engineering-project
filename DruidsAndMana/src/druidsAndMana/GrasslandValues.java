package druidsAndMana;

/**
 * Class that contains all the values relating to the types of Grassland
 * 
 * @author Nicola
 *
 */
public class GrasslandValues {

	/**
	 * A 2D Array that contains all the values needed for each RealmTier.
	 * <p>
	 * <p>
	 * The first dimension of the allValues array represents the RealmTier the array
	 * of values is for.
	 * <ul>
	 * <li>Index 0: This is the TIER_1 RealmTier Values. It is the most expensive.
	 * 
	 * <li>Index 1: This is the TIER_2 RealmTier Values. It is the second most
	 * expensive.
	 * 
	 * <li>Index 2: This is the TIER_3 RealmTier Values. It is the second least
	 * expensive.
	 * 
	 * <li>Index 3: This is the TIER_4 RealmTier Values. It is the least expensive.
	 * </ul>
	 * <p>
	 * For the second dimension of the allValues array provides the values for each
	 * realmTier, each value represents a different value requires as follows:
	 * <p>
	 * Index 0: Price to Buy Grassland - This is the initial Mana price that a
	 * Player will pay to purchase a grassland
	 * <ul>
	 * <li>Index 1: Price to plant a forest (i.e. make a minor development)- This is
	 * the Mana price that a Player will pay to plant a forest on a grassland
	 * 
	 * <li>Index 2: Price to upgrade to a Wildlife Sanctuary (i.e. make a major
	 * development) - This is the Mana price that a Player will pay to upgrade to a
	 * Wildlife Reserve
	 * 
	 * <li>Index 3: CO2 reduction rating base - This is the base CO2 reduction rating earned for
	 * an owned Grassland that has no developments
	 * 
	 * <li>Index 4: CO2 minor development premium - This is the additional CO2
	 * reduction rating earned for each minor development on a Grassland, i.e. for each
	 * forest that is planted a Player will earn this in addition to the base CO2
	 * Reduction Rating.
	 * 
	 * <li>Index 5: CO2 major development premium - This is the additional CO2
	 * reduction rating earned when a major development is made to a Grassland, This is
	 * earned in addition to 3 x the minor development premium and the base amount
	 * 
	 * <li>Index 6: Base cost to a player landing on a Grassland not owned by them -
	 * This is the Mana charge to a player for landing on the grassland if it is
	 * owned by another player and has no developments made to it
	 * 
	 * <li>Index 7: Minor development premium to a player landing on a Grassland not
	 * owned by them - This is the additional Mana charge per forest planted in
	 * addition to the base cost to a player for landing on the grassland if it is
	 * owned by another player, e.g. if a grassland has 2 forests planted on it the
	 * cost of landing on the grassland is the base cost + 2 x this minor
	 * development premium
	 * 
	 * <li>Index 8: Major development premium to a player landing on a Grassland not
	 * owned by them - This is the additional Mana charge for landing on a grassland
	 * that has been upgraded to a Wildlife Sanctuary if it is owned by another
	 * player. This is added to the base costs and 3 x the Minor development premium
	 * e.g. if a grassland has been upgraded to a Wildlife reserve the cost of
	 * landing on the grassland is the base cost + 3 x this minor development
	 * premium + 1 x the major development premium
	 * </ul>
	 */
	private static final int[][] ALL_VALUES = { { 300, 150, 300, 25, 200, 400, 25, 150, 400 }, // RealmTier 1 - TIER_1 @ index 0
			{ 220, 110, 220, 20, 150, 300, 20, 110, 330 }, // RealmTier 2 - TIER_2 @ index 1
			{ 140, 70, 140, 15, 100, 200, 10, 70, 240 }, // RealmTier 3 - TIER_3 @ index 2
			{ 60, 30, 60, 10, 50, 100, 5, 30, 120 } // RealmTier 4 - TIER_4 @ index 3
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
	 * Constructor with args
	 * 
	 * @param realmTier - the RealmTier the Grassland should be instantiated for
	 */
	public GrasslandValues(RealmTier realmTier) {
		this.setValueSet(realmTier);
	}

	// Methods
	/**
	 * Private method used within the Class to set the values to be used for the
	 * other methods.
	 * <p>
	 * Only the constructor will use this method when it is declared.
	 * 
	 * @param realmTier - the RealmTier the values should be for
	 */
	private void setValueSet(RealmTier realmTier) {
		switch (realmTier) {
		case TIER_1:
			this.valueSet = ALL_VALUES[0];
			break;
		case TIER_2:
			this.valueSet = ALL_VALUES[1];
			break;
		case TIER_3:
			this.valueSet = ALL_VALUES[2];
			break;
		case TIER_4:
			this.valueSet = ALL_VALUES[3];
			break; // design decision not to include a default case as a RealmTier can only be one
					// of
					// the 4 enum values
		}
	}

	/**
	 * Gets the price to land on the Grassland of the given RealmTier
	 * 
	 * @return - the Mana price to buy the Grassland
	 */
	public int getPriceGrassland() {
		return valueSet[0];
	}

	/**
	 * Gets the price to plant a forest on the Grassland of the given RealmTier
	 * 
	 * @return - the Mana price to plant 1 forest
	 */
	public int getPriceForest() {
		return valueSet[1];
	}

	/**
	 * Gets the price to upgrade to a Wildlife Sanctuary of the given RealmTier
	 * 
	 * @return - the Mana price to upgrade to a Wildlife Sanctuary
	 */
	public int getPriceWildlifeSanctuary() {
		return valueSet[2];
	}

	/**
	 * Gets the 3 CO2 Reduction Rating tiers in order to calculate the total CO2 Reduction
	 * Rating depending on the SquareStatus of a Grassland.
	 * 
	 * @return - an int[] of values where index 0 is the base CO2 reduction rating,
	 *         index 1 is the additional reduction rating of each forest that is
	 *         planted, and index 2 is the additional reduction rating earned for a
	 *         Wildlife Sanctuary.
	 *         <p>
	 *         Example usage of this value Set:
	 *         <ul>
	 *         <li>Example 1: For a Grassland with no developments use only the
	 *         value at index 0.
	 * 
	 *         <li>Example 2: For a Grassland with 2 forests planted take the value
	 *         at index 0 + 2x the value at index 1.
	 * 
	 *         <li>Example 3: For a Grassland that has been upgraded to a Wildlife
	 *         Sanctuary take the value at index 0 + 3x the value at index 1 + 1x
	 *         the value at index 2 (this is the maximum CO2 rating that should be
	 *         calculated using this value set).
	 *         </ul>
	 *         <p>
	 */
	public int[] getCO2ValueSet() {
		int[] values = { valueSet[3], valueSet[4], valueSet[5] };
		return values;
	}

	/**
	 * Gets the 3 Cost tiers of a Player landing on a Grassland that is owned by
	 * another player so the total cost can be calculated depending on the
	 * SquareStatus of a Grassland.
	 * 
	 * @return - an int[] of values where index 0 is the base Cost of landing on an
	 *         empty Grassland, index 1 is the additional cost for each forest that
	 *         is planted on that Grassland, and index 2 is the additional cost
	 *         where the Grassland has been upgraded to a Wildlife Sanctuary.
	 *         <p>
	 *         Example usage of this value Set:
	 *         <ul>
	 *         <li>Example 1: For a Grassland with no developments use only the
	 *         value at index 0.
	 * 
	 *         <li>Example 2: For a Grassland with 2 forests planted take the value
	 *         at index 0 + 2x the value at index 1.
	 * 
	 *         <li>Example 3: For a Grassland that has been upgraded to a Wildlife
	 *         Sanctuary take the value at index 0 + 3x the value at index 1 + 1x
	 *         the value at index 2 (this is the maximum cost that should be
	 *         calculated using this value set).
	 *         </ul>
	 *         <p>
	 */
	public int[] getCostToLandOnValueSet() {
		int[] values = { valueSet[6], valueSet[7], valueSet[8] };
		return values;
	}
}
