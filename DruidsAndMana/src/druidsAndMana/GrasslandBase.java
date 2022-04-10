package druidsAndMana;

public abstract class GrasslandBase implements ISquare {

	// Fields:
	private GrasslandValues grasslandValues;
	private String ownerId;
	private SquareDevelopmentType squareType;
	
	// Constructor:
	public GrasslandBase(GrasslandValues grasslandValues) {
		this.grasslandValues = grasslandValues;
		this.squareType = SquareDevelopmentType.Vacant;
	}
	
	// Methods:
	public String getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(String ownerId) {
		if (this.ownerId != null) {
			throw new IllegalArgumentException("Another player already owns this square");
		}
		this.upgrade();
		this.ownerId = ownerId;
	}
	
	public int upgradeCost() {
		switch(squareType) {
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
		return squareType.next() != null;
	}
	
	public boolean upgrade() {
		SquareDevelopmentType next;
		if((next = squareType.next()) != null) {
			this.squareType = next;
			return true;
		}
		return false;
	}
	
	public SquareDevelopmentType developmentStatus() {
		return squareType;
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
	 * Override this method to provide a description of what the grassland does:
	 */
	public abstract String description();
	
	
	/**
	 * Ascii art for the square:
	 */
	public abstract String asciiArt();
	
}
