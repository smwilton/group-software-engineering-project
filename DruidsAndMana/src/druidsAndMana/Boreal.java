package druidsAndMana;

/**
 * Class that extends Grassland and represents a Boreal Grassland object
 *
 * @author Nicola
 * @author pete
 *
 */
public class Boreal extends Grassland {

	// Constructor
	/**
	 * Constructor with args
	 * 
	 * @param realmTier - the Tier that determines the GrasslandValues
	 */
	public Boreal(RealmTier realmTier) {
		super(realmTier);
	}

	// Implementation of abstract grassland methods
	/**
	 * Method to obtain the description of the Boreal Grassland
	 * 
	 * @return - the description as a String
	 */
	@Override
	public String description() {
		return "Cold and dry, boreal grasslands have long, cool winters and short summers";
	}

	/**
	 * Method to obtain the ascii art for the Boreal Grassland
	 * 
	 * @return - the ascii art as a String
	 */
	@Override
	public String asciiArt() {
		return " ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\r\n"
				+ "/|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
