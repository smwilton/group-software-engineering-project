package druidsAndMana;
/**
 * Class that contains all the values relating to the types of Grassland
 *
 * @author Nicola Stirling 40020701
 *
 */
public class GrasslandValues {

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
	
	private int arrayIndex;
	private Realm realm;
	
	public GrasslandValues(Realm realm) {
		this.setRealm(realm);
	}
	
	public int priceGrassland() {
		return PRICE_GRASSLAND[arrayIndex];
	}
	
	public int priceForest() {
		return PRICE_MINOR_DEV[arrayIndex];
	}
	
	public int priceWildlifeSanctuary() {
		return PRICE_MAJOR_DEV[arrayIndex];
	}
	
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
	
	public int[] getValues (Realm realm) {
		int[] values = new int[5];
		
		
		return values;
	}
}
