package druidsAndMana;

/**
 * Class that extends tile and represents a Grassland object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Grassland extends Square {

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
	 * When a Grassland is instantiated the owner is initially declared as an empty
	 * string to indicate that tehre is no owner, the number of forests planted is
	 * set to 0 and the wildlife reserve is set to false.
	 * 
	 * @param realm - the realm the grassland is part of
	 */
	public Grassland(Realm realm) {
		this.setRealm(realm);
		this.setOwner("");
		this.setNumForestsPlanted(0);
		this.setWildlifeReserve(false);
	}

	// Methods

	/**
	 * @return the realm
	 */
	public Realm getRealm() {
		return realm;
	}

	/**
	 * Method to set the realm. This method also sets the array index based on the
	 * realm so the index can be used to access the relevant values in the
	 * constants. Private method as realm cannot be changed after the Grassland is
	 * instantiated.
	 * 
	 * @param realm - the realm to set
	 */
	private void setRealm(Realm realm) {
		this.realm = realm;

		switch (realm) {
		case TROPICAL:
			this.arrayIndex = 0;
			break;
		case SUBTROPICAL:
			this.arrayIndex = 1;
			break;
		case TEMPERATE:
			this.arrayIndex = 2;
			break;
		case BOREAL:
			this.arrayIndex = 3;
			break; // design decision not to include a default case as a realm can only be one of
					// the 4 enum values
		}
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner - the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * This method returns the number of forests planted on a grassland as an int
	 * 
	 * @return the numForestsPlanted
	 */
	public int getNumForestsPlanted() {
		return numForestsPlanted;
	}

	/**
	 * @param numForestsPlanted - the numForestsPlanted to set
	 */
	private void setNumForestsPlanted(int numForestsPlanted) {
		this.numForestsPlanted = numForestsPlanted;
	}

	/**
	 * Will return true if the Grassland has been upgraded to a wildlife reserve
	 * 
	 * @return the isWildlifeReserve
	 */
	public boolean isWildlifeReserve() {
		return isWildlifeReserve;
	}

	/**
	 * @param isWildlifeReserve - setting the status of whether the Grassland
	 *                          contains a Wildlife reserve or not
	 */
	private void setWildlifeReserve(boolean isWildlifeReserve) {
		this.isWildlifeReserve = isWildlifeReserve;
	}

	/**
	 * Method to add a forest to the grassland
	 * 
	 * Validation to prevent planting a forest until a Player owns all Grassland and
	 * to prevent more than 3 forests being planted is done in the class where the
	 * Grassland is instantiated.
	 */
	public void plantForest() {
		// get current number of forests and add 1
		int newNumForestsPlanted = getNumForestsPlanted() + 1;

		// set updated number of forests
		setNumForestsPlanted(newNumForestsPlanted);
	}

	/**
	 * Method to record the major development of upgrading the Grassland to a
	 * Wildlife Reserve
	 * 
	 * Contains validation to ensure the status can only be changed to true if there
	 * are 3 forests planted
	 */
	public void upgradeToWildlifeReserve() {
		if (this.numForestsPlanted == 3) {
			setWildlifeReserve(true);
		} else {
			setWildlifeReserve(false);
		}

	}

	/**
	 * Method to get the Mana price of a vacant Grassland
	 * 
	 * @return - the price to buy the Grassland
	 */
	public int getPriceToBuy() {
		int price;
		price = PRICE_GRASSLAND[this.arrayIndex];
		return price;
	}

	/**
	 * Method to get how much it costs for a Player to plant a forest on their
	 * grassland
	 * 
	 * @return - the price to plant a forest
	 */
	public int getPriceToPlantForest() {
		int price;
		price = PRICE_MINOR_DEV[this.arrayIndex];
		return price;
	}

	/**
	 * Method to get how much it costs for a Player to upgrade to a Wildlife Reserve
	 * 
	 * @return - the price to upgrade to a Wildlife Reserve
	 */
	public int getPriceToUpgradeToWildlifeReserve() {
		int price;
		price = PRICE_MAJOR_DEV[this.arrayIndex];
		return price;
	}

	public int calculateCo2ImpactRating() {
		int impact;
		impact = 0;
		// TODO
		return impact;
	}

	public int calculateCostToLandOn() {
		int cost;
		cost = 0;
		// TODO
		return cost;
	}
}
