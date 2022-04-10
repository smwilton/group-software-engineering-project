package druidsAndMana;

/**
 * Abstract class that implements ISquare interface and repesents a
 * GrasslandBase object
 * 
 * NB: An abstract class cannot be instantiated
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
	 * Sets the Owner of the GrasslandBase once it is purchased
	 * 
	 * @param ownerId - the ID of the owner who is purchasing the grassland
	 * @throws IllegalArgumentException if the grassland is already owned
	 */
	public void setOwnerId(String ownerId) {
		if (this.ownerId != null) {
			throw new IllegalArgumentException("Another player already owns this square");
		}
		this.developGrassland();
		this.ownerId = ownerId;
	}

	/**
	 * Method to get the cost of developing the square depending on it's current
	 * status.
	 * 
	 * @return
	 *         <ul>
	 *         <li>If the status is Vacant the price to buy the grassland will be
	 *         returned.
	 *         <li>If the status is GrasslandBase, SeedlingForest or
	 *         IntermediateForest the price to plant a Forest will be returned.
	 *         <li>If the status if EstablishedForest the price to upgrade to a
	 *         WildlifeSanctuary will be returned.
	 *         <li>If the status is anything other than this 0 will be returned as
	 *         there are no development options available
	 *         </ul>
	 */
	public int developmentCost() {
		switch (squareStatus) {
		case Vacant:
			return grasslandValues.getPriceGrassland();
		case Grassland:
		case SeedlingForest:
		case IntermediateForest:
			return grasslandValues.getPriceForest();
		case EstablishedForest:
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
		case Grassland:
			return charges[0];
		case SeedlingForest:
			return (charges[0] + (1 * charges[1]));
		case IntermediateForest:
			return (charges[0] + (2 * charges[1]));
		case EstablishedForest:
			return (charges[0] + (3 * charges[1]));
		case WildlifeSanctuary:
			return (charges[0] + (3 * charges[1]) + (1 * charges[2]));
		default:
			return 0;
		}
	}

	/**
	 * Method to get the positive CO2 impact the GrasslandBase is having on the
	 * environment. The rating varies depending on the SquareStatus
	 * 
	 * @return - the CO2 Impact Rating earned for the GrasslandBase
	 */
	public int getCo2ImpactRating() {
		int[] co2Values = grasslandValues.getCO2ValueSet();
		switch (squareStatus) {
		case Grassland:
			return (co2Values[0]);
		case SeedlingForest:
			return (co2Values[0] + (1 * co2Values[1]));
		case IntermediateForest:
			return (co2Values[0] + (2 * co2Values[1]));
		case EstablishedForest:
			return (co2Values[0] + (3 * co2Values[1]));
		case WildlifeSanctuary:
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
	}

	/**
	 * Method to update the SquareStatus to the next available option when a
	 * development is added to the GrasslandBase square
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
	 * Method to get the status of the grassland. This can either be Vacant,
	 * GrasslandBase, SeedlingForest, IntermediateForest, EstablishedForest, or
	 * WildlifeSanctuary
	 * <ol>
	 * <li>Vacant = unowned
	 * 
	 * <li>GrasslandBase = owned GrasslandBase with no developments
	 * 
	 * <li>SeedlingForest = owned GrasslandBase with 1 minor development (i.e. 1
	 * forest planted)
	 * 
	 * <li>IntermediateForest = owned GrasslandBase with 2 minor developments (i.e.
	 * 2 forests planted)
	 * 
	 * <li>EstablishedForest = owned GrasslandBase with 3 minor developments (i.e. 3
	 * forests planted)
	 * 
	 * <li>Wildlife Sanctuary = owned GrasslandBase with 1 major development (i.e. a
	 * WildLife reserve)
	 * </ol>
	 * <p>
	 * 
	 * @return - the status of the GrasslandBase
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
