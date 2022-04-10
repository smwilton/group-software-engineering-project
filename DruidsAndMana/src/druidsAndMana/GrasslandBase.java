package druidsAndMana;

/**
 * Abstract class that implements ISquare interface and repesents a Grassland
 * object NB: An abstract class cannot be instantiated
 *
 * @author Nicola Stirling 40020701
 *
 */
public abstract class GrasslandBase implements ISquare {

	// Instance Vars
	private GrasslandValues grasslandValues;
	private String ownerId; // String var type used to allow the use of null to indicate that a grassland
							// square is not owned
	private SquareStatus squareStatus;

	// Constructor
	public GrasslandBase(Realm realm) {
		this.setGrasslandValues(realm);
		this.squareStatus = SquareStatus.Vacant;
	}

	// Methods
	/**
	 * Sets the grassland values based on the Realm that has been defined in the
	 * constructor
	 * 
	 * @param realm - the realm to get the GrasslandValues for
	 */
	private void setGrasslandValues(Realm realm) {
		this.grasslandValues = new GrasslandValues(realm);
	}

	/**
	 * Gets the owner id
	 * 
	 * @return - the owner id if the grassland is owned or null if it is still
	 *         vacant and eligible to be bought by a player
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the Owner of the Grassland once it is purchased
	 * 
	 * @param ownerId - the ID of the owner who is purchasing the grassland
	 * @throws IllegalArgumentException if the grassland is already owned
	 */
	public void setOwnerId(String ownerId) {
		if (this.ownerId != null) {
			throw new IllegalArgumentException("Another player already owns this square");
		}
		this.upgrade();
		this.ownerId = ownerId;
	}

	/**
	 * Method to get the cost of developing the square depending on it's current
	 * status.
	 * 
	 * @return - If the status is Vacant the price to buy the grassland will be
	 *         returned, if the status is Grassland, SeedlingForest or
	 *         IntermediateForest the price to plant a Forest will be returned, and
	 *         if the status if EstablishedForest the price to upgrade to a
	 *         WildlifeSanctuary will be returned. If the status is anything other
	 *         than this 0 will be returned as there are no development options
	 *         available
	 */
	public int developmentCost() {
		switch (squareStatus) {
		case Vacant:
			return grasslandValues.priceGrassland();
		case Grassland:
		case SeedlingForest:
		case IntermediateForest:
			return grasslandValues.priceForest();
		case EstablishedForest:
			return grasslandValues.priceWildlifeSanctuary();
		default:
			return 0;
		}
	}


	public boolean canUpgrade() {
		return squareStatus.next() != null;
	}

	public boolean upgrade() {
		SquareStatus next;
		if ((next = squareStatus.next()) != null) {
			this.squareStatus = next;
			return true;
		}
		return false;
	}

	/**
	 * Method to get the status of the grassland. This can either be Vacant,
	 * Grassland, SeedlingForest, IntermediateForest, EstablishedForest, or
	 * WildlifeSanctuary
	 * 
	 * 1. Vacant = unowned
	 * 
	 * 2. Grassland = owned Grassland with no developments
	 * 
	 * 3. SeedlingForest = owned Grassland with 1 minor development (i.e. 1 forest
	 * planted)
	 * 
	 * 4. IntermediateForest = owned Grassland with 2 minor developments (i.e. 2
	 * forests planted)
	 * 
	 * 5. EstablishedForest = owned Grassland with 3 minor developments (i.e. 3
	 * forests planted)
	 * 
	 * 6. Wildlife Sanctuary = owned Grassland with 1 major development (i.e. a
	 * WildLife reserve)
	 * 
	 * @return - the status of the Grassland
	 */
	public SquareStatus getSquareStatus() {
		return squareStatus;
	}

	public int manaCharge() {
		// TODO: Implement
		return 0;
	}

	public int co2Consumption() {
		// TODO: Implement
		return 0;
	}

	/**
	 * Method to describe the grassland
	 */
	public abstract String description();

	/**
	 * Ascii art for the grassland
	 */
	public abstract String asciiArt();

}
