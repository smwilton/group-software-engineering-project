package druidsAndMana;

/**
 * Abstract class that implements ISquare interface and repesents a Grassland
 * object
 * 
 * NB: An abstract class cannot be instantiated
 *
 * @author Nicola
 *
 */
public abstract class Grassland implements ISquare {

	// Instance Vars
	private GrasslandValues grasslandValues;
	private int ownerId; // String var type used to allow the use of null to indicate that a grassland
							// square is not owned
	private SquareStatus squareStatus;

	// Constructor
	public Grassland(RealmTier realm) {
		this.setGrasslandValues(realm);
		this.squareStatus = SquareStatus.VACANT;
	}

	// Methods
	/**
	 * Sets the grassland values based on the RealmTier that has been defined in the
	 * constructor
	 * 
	 * @param realmTier - the realmTier to get the GrasslandValues for
	 */
	private void setGrasslandValues(RealmTier realmTier) {
		this.grasslandValues = new GrasslandValues(realmTier);
	}

	/**
	 * Gets the player number of the player who owns the grassland (i.e. the
	 * ownerId)
	 * 
	 * @return - the owner id if the grassland is owned or 0 if it is still vacant
	 *         and eligible to be bought by a player
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the Initial Owner of the Square once it is purchased and updates the
	 * status of the Square from Vacant to Grassland
	 * 
	 * @param ownerId - the player number of the Player who is purchasing the
	 *                grassland
	 * @throws IllegalArgumentException if the grassland is already owned
	 */
	public void setInitialOwnerId(int ownerId) throws IllegalArgumentException {
		if (this.ownerId != 0) {
			throw new IllegalArgumentException("Another player already owns this square");
		}
		this.developGrassland();
		this.ownerId = ownerId;
	}

	/**
	 * Trasnfers the ownership of a square from one player to another
	 * 
	 * @param ownerId - the ID of the Player who the ownership is transferring to
	 * @throws IlledgalArgumentException if the grassland is not already owned
	 */
	public void transferOwnership(int ownerId) throws IllegalArgumentException {
		if (this.ownerId == 0) {
			throw new IllegalArgumentException(
					"A player must currently own this square to transfer the ownership to another Player");
		}
		this.ownerId = ownerId;
	}

	/**
	 * Method to get the cost of developing the square depending on it's current
	 * status.
	 * 
	 * @return
	 *         <ul>
	 *         <li>If the status is VACANT the price to buy the grassland will be
	 *         returned.
	 *         <li>If the status is GRASSLAND, SEEDLING_FOREST or
	 *         INTERMEDIATE_FOREST the price to plant a Forest will be returned.
	 *         <li>If the status if ESTABLISHED_FOREST the price to upgrade to a
	 *         WILDLIFE_SANCTUARY will be returned.
	 *         <li>If the status is anything other than this 0 will be returned as
	 *         there are no development options available
	 *         </ul>
	 */
	public int getDevelopmentCost() {
		switch (squareStatus) {
		case VACANT:
			return grasslandValues.getPriceGrassland();
		case GRASSLAND:
		case SEEDLING_FOREST:
		case INTERMEDIATE_FOREST:
			return grasslandValues.getPriceForest();
		case ESTABLISHED_FOREST:
			return grasslandValues.getPriceWildlifeSanctuary();
		default:
			return 0;
		}
	}

	/**
	 * Method to get the cost to another Player for landing on this grassland if it
	 * is owned by another player. The charge varies depending on the SquareStatus
	 * 
	 * @return - the Mana charge to a Player for landing on this square if it is
	 *         owned by another player
	 */
	public int getChargeForLandingOnSquare() {
		int[] charges = grasslandValues.getCostToLandOnValueSet();
		switch (squareStatus) {
		case GRASSLAND:
			return charges[0];
		case SEEDLING_FOREST:
			return (charges[0] + (1 * charges[1]));
		case INTERMEDIATE_FOREST:
			return (charges[0] + (2 * charges[1]));
		case ESTABLISHED_FOREST:
			return (charges[0] + (3 * charges[1]));
		case WILDLIFE_SANCTUARY:
			return (charges[0] + (3 * charges[1]) + (1 * charges[2]));
		default:
			return 0;
		}
	}

	/**
	 * Method to get the positive CO2 impact the Grassland is having on the
	 * environment. The rating varies depending on the SquareStatus
	 * 
	 * @return - the CO2 Impact Rating earned for the Grassland
	 */
	public int getCo2ImpactRating() {
		int[] co2Values = grasslandValues.getCO2ValueSet();
		switch (squareStatus) {
		case GRASSLAND:
			return (co2Values[0]);
		case SEEDLING_FOREST:
			return (co2Values[0] + (1 * co2Values[1]));
		case INTERMEDIATE_FOREST:
			return (co2Values[0] + (2 * co2Values[1]));
		case ESTABLISHED_FOREST:
			return (co2Values[0] + (3 * co2Values[1]));
		case WILDLIFE_SANCTUARY:
			return (co2Values[0] + (3 * co2Values[1]) + (1 * co2Values[2]));
		default:
			return 0;
		}
	}

	/**
	 * Method to check if further developments are available on the square
	 * 
	 * @return true if development options are available and false if no further
	 *         options are available
	 */
	public boolean canDevelopGrassland() {
		return squareStatus.next() != null;
		/*
		 * Design decision not to include any additional checks to ensure ownerId is set
		 * before developments beyond vacant are made as this is handled in the
		 * GameBoard
		 */
	}

	/**
	 * Method to update the SquareStatus to the next available option when a
	 * development is added to the Grassland square
	 * 
	 * @return - true if the status has been successfully updated and false if the
	 *         status of the square is null and can not be developed further
	 */
	public boolean developGrassland() {
		SquareStatus next;
		if ((next = squareStatus.next()) != null) {
			this.squareStatus = next;
			return true;
		}
		return false;
	}

	/**
	 * Method to get the status of the grassland. This can either be VACANT,
	 * GRASSLAND, SEEDLING_FOREST, INTERMEDIATE_FOREST, ESTABLISHED_FOREST, or
	 * WILDLIFE_SANCTUARY
	 * <ol>
	 * <li>VACANT = unowned
	 * 
	 * <li>GRASSLAND = owned Grassland with no developments
	 * 
	 * <li>SEEDLING_FOREST = owned Grassland with 1 minor development (i.e. 1 forest
	 * planted)
	 * 
	 * <li>INTERMEDIATE_FOREST = owned Grassland with 2 minor developments (i.e. 2
	 * forests planted)
	 * 
	 * <li>ESTABLISHED_FOREST = owned Grassland with 3 minor developments (i.e. 3
	 * forests planted)
	 * 
	 * <li>Wildlife Sanctuary = owned Grassland with 1 major development (i.e. a
	 * WildLife reserve)
	 * </ol>
	 * <p>
	 * 
	 * @return - the status of the Grassland
	 */
	public SquareStatus getSquareStatus() {
		return squareStatus;
	}

	// Abstract methods
	/**
	 * Method to describe the grassland
	 */
	public abstract String description();

	/**
	 * Ascii art for the grassland
	 */
	public abstract String asciiArt();

}
