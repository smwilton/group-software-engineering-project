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

	// declaring constants
	/**
	 * 
	 */
	private static final int[] GRASSLAND_PRICE = {60,50,40,30};
	
	// constructors
	/**
	 * Default constructor
	 */
	public Grassland() {

	}

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
	 * @param realm the realm to set
	 */
	public void setRealm(Realm realm) {
		this.realm = realm;
	}

	// other methods

}
