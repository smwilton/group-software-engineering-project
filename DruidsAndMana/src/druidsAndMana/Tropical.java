package druidsAndMana;

/**
 * Class that extends Grassland and represents a Tropical Grassland object
 *
 * @author Nicola Stirling 40020701
 * @author Pete
 *
 */
public class Tropical extends Grassland {

	// Constructor
	/**
	 * Constructor with args
	 * 
	 * @param realmTier - the Tier that determines the GrasslandValues
	 */
	public Tropical(RealmTier realmTier) {
		super(realmTier);
	}

	// Implementation of abstract grassland methods
	/**
	 * Method to obtain the description of the Tropical Grassland
	 * 
	 * @return - the description as a String
	 */
	@Override
	public String description() {
		return "The tropical grassland has a bustling and diverse ecosystem where each player will find harmony with Nature";
	}

	/**
	 * Method to obtain the ascii art for the Tropical Grassland
	 * 
	 * @return - the ascii art as a String
	 */
	@Override
	public String asciiArt() {
		return "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
				+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
				+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
