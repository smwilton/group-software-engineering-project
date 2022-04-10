package druidsAndMana;

/**
 * Class that contains all the values relating to the types of GrasslandBase
 * 
 * 
 * There are 4 tiers of Realms Tier 1 is the most expensive - this is the
 * TROPICAL Realm and is index 0 of each array Tier 2 is the second most
 * expensive - this is the SUBTROPICAL Realm and is index 1 of each array Tier 3
 * is the second least expensive - this is the TEMPERATE Realm and is index 2 of
 * each array Tier 4 is the least expensive - this is the BOREAL Realm and is
 * index 3 of each array
 *
 * Index 0: Price to Buy GrasslandBase - This is the initial Mana price that a
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
 * owned GrasslandBase that has no developments
 * 
 * Index 4: CO2 minor development premium - This is the additional CO2 impact
 * rating earned for each minor development on a GrasslandBase, i.e. for each forest
 * that is planted a Player will earn this in addition to the base CO2 Impact.
 * 
 * Index 5: CO2 major development premium - This is the additional CO2 impact
 * rating earned when a major development is made to a GrasslandBase, This is earned
 * in addition to 3 x the minor development premium and the base amount
 * 
 * Index 6: Base cost to a player landing on a GrasslandBase not owned by them -
 * This is the Mana charge to a player for landing on the grassland if it is
 * owned by another player and has no developments made to it
 * 
 * Index 7: Minor development premium to a player landing on a GrasslandBase not
 * owned by them - This is the additional Mana charge per forest planted in
 * addition to the base cost to a player for landing on the grassland if it is
 * owned by another player, e.g. if a grassland has 2 forests planted on it the
 * cost of landing on the grassland is the base cost + 2 x this minor
 * development premium
 * 
 * Index 8: Major development premium to a player landing on a GrasslandBase not
 * owned by them - This is the additional Mana charge for landing on a grassland
 * that has been upgraded to a Wildlife Sanctuary if it is owned by another
 * player. This is added to the base costs and 3 x the Minor development premium
 * e.g. if a grassland has been upgraded to a Wildlife reserve the cost of
 * landing on the grassland is the base cost + 3 x this minor development
 * premium + 1 x the major development premium
 * 
 * @author Nicola Stirling 40020701
 *
 */
public class GrasslandValues {

	/*
	private static final int[] PRICE_GRASSLAND = { 60, 50, 40, 30 };
	private static final int[] PRICE_MINOR_DEV = { 12, 10, 8, 3 };
	private static final int[] PRICE_MAJOR_DEV = { 60, 50, 40, 30 };
	private static final int[] CO2_IMPACT_BASE = { 60, 50, 40, 30 };
	private static final int[] CO2_IMPACT_MINOR_DEV_PREMIUM = { 6, 5, 4, 3 };
	private static final int[] CO2_IMPACT_MAJOR_DEV_PREMIUM = { 20, 15, 10, 5 };
	private static final int[] LAND_ON_BASE = { 10, 9, 8, 7 };
	private static final int[] LAND_ON_MINOR_DEV_PREMIUM = { 4, 3, 2, 1 };
	private static final int[] LAND_ON_MAJOR_DEV_PREMIUM = { 8, 7, 6, 5 };
	*/
	
	// Instance Vars
	private int valueSet;

	// Constructor
	public GrasslandValues(Realm realm) {
		this.setValueSet(realm);
	}

	
	// Methods
	public int priceGrassland() {
		//TODO
		return 0;
	}

	public int priceForest() {
		//TODO
		return 0;
	}

	public int priceWildlifeSanctuary() {
		//TODO
		return 0;
	}

	private void setValueSet(Realm realm) {
		switch (realm) {
		case Tropical:
			this.valueSet = 0;
			break;
		case Subtropical:
			this.valueSet = 1;
			break;
		case Temperate:
			this.valueSet = 2;
			break;
		case Boreal:
			this.valueSet = 3;
			break; // design decision not to include a default case as a realm can only be one of
					// the 4 enum values
		}
	}

	public int[] getValues(Realm realm) {
		int[] values = new int[5];

		return values;
	}
}
