package druidsAndMana;

/**
 * Class that extends tile and represents a Grassland object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Grassland extends ForestSquare {

	// instance vars
	private Realm realm;
	private int arrayIndex;
	private String owner;
	private int numForestsPlanted; // This is the minor upgrade
	private boolean isWildlifeReserve; // This is the major upgrade

	// declaring constants

	/*
	 * There are 4 tiers of Realms Tier 1 is the most expensive - this is the
	 * TROPICAL Realm and is index 0 of each array Tier 2 is the second most
	 * expensive - this is the SUBTROPICAL Realm and is index 1 of each array Tier 3
	 * is the second least expensive - this is the TEMPERATE Realm and is index 2 of
	 * each array Tier 4 is the least expensive - this is the BOREAL Realm and is
	 * index 3 of each array
	 */
	/**
	 * This is the initial Mana price that a Player will pay to purchase a grassland
	 */
	private static final int[] PRICE_GRASSLAND = { 60, 50, 40, 30 };

	/**
	 * this is the Mana price that a Player will pay to plan a forest on a grassland
	 */
	private static final int[] PRICE_MINOR_DEV = { 12, 10, 8, 3 };

	/**
	 * This is the Mana price that a Player will pay to upgrade to a Wildlife
	 * Reserve
	 */
	private static final int[] PRICE_MAJOR_DEV = { 60, 50, 40, 30 };

	/**
	 * This is the base CO2 impact rating earned for an owned Grassland that has no
	 * developments
	 */
	private static final int[] CO2_IMPACT_BASE = { 60, 50, 40, 30 };

	/**
	 * This is the additional CO2 impact rating earned for each minor development on
	 * a Grassland, i.e. for each forest that is planted a Player will earn this in
	 * addition to the base CO2 Impact
	 */
	private static final int[] CO2_IMPACT_MINOR_DEV_PREMIUM = { 6, 5, 4, 3 };

	/**
	 * This is the additional CO2 impact rating earned when a major development is
	 * made to a Grassland, This is earned in addition to 3 x the minor development
	 * premium and the base amount
	 */
	private static final int[] CO2_IMPACT_MAJOR_DEV_PREMIUM = { 20, 15, 10, 5 };

	/**
	 * This is the initial Mana price that a Player will pay to purchase a grassland
	 */
	private static final int[] LAND_ON_BASE = { 10, 9, 8, 7 };

	/**
	 * this is the Mana price that a Player will pay to plan a forest on a grassland
	 */
	private static final int[] LAND_ON_MINOR_DEV_PREMIUM = { 4, 3, 2, 1 };

	/**
	 * This is the Mana price that a Player will pay to upgrade to a Wildlife
	 * Reserve
	 */
	private static final int[] LAND_ON_MAJOR_DEV_PREMIUM = { 8, 7, 6, 5 };

	// constructors
	/**
	 * Constructor with Realm arg
	 * 
	 * @param realm - the realm the grassland is part of
	 */
	public Grassland(Realm realm) {
		this.setRealm(realm);
	}

	// getters and setters

	/**
	 * @return the realm
	 */
	public Realm getRealm() {
		return realm;
	}

	/**
	 * Method to set the realm. 
	 * This method also identifies the tier of the realm and therefore the prices and CO2 impact rating
	 * @param realm the realm to set
	 */
	public void setRealm(Realm realm) {
		this.realm = realm;
		
		switch(realm) {
		case TROPICAL:
			this.arrayIndex = 0;
			break;
		case SUBTROPICAL:
			this.arrayIndex = 1;
			break;
		case TEMPERATE :
			this.arrayIndex = 2;
			break;
		case BOREAL:
			this.arrayIndex = 3;
			break; // design decision not to include a default case as a realm can only be one of the 4 enum values
		}
	}

	// other methods
	public void plantForest() {
		//TODO
	}

	public void upgradeToWildlifeReserve() {
		//TODO
	}
	
	public int calculatePrice () {
		int price;
		price = 0;
		//TODO
		return price;
	}
	
	public int calculateCo2ImpactRating() {
		int impact;
		impact = 0;
		//TODO
		return impact;
	}
	
	public int calculateCostToLandOn() {
		int cost;
		cost = 0;
		//TODO
		return cost;
	}
}
