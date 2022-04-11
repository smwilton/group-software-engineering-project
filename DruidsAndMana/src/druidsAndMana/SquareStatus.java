package druidsAndMana;

/**
 * Enum of the different Status' that a Grassland Square can have
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
 * Contains a method to increment the status as a Player buys and develops a
 * square. It also contains a method to prevent the status exceeding Wildlife
 * Santuary
 * 
 * @author Peter McCullough 40055438
 *
 */
public enum SquareStatus {

	VACANT(1), GRASSLAND(2), SEEDLING_FOREST(3), INTERMEDIATE_FOREST(4), ESTABLISHED_FOREST(5), WILDLIFE_SANCTUARY(6) {
		@Override
		public SquareStatus next() {
			return null;
		};
	};

	/**
	 * The value of the enum
	 */
	private int value;

	/**
	 * Sets the value
	 * 
	 * @param value
	 */
	SquareStatus(int value) {
		this.value = value;
	}

	/**
	 * Gets the value
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Method to increment the square status to the next available one
	 * 
	 * @return The next available Enum
	 */
	public SquareStatus next() {
		return values()[ordinal() + 1];
	}
}
