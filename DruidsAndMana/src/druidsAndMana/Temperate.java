package druidsAndMana;

/**
 * Class that extends Grassland and represents a Temperate Grassland object
 *
 * @author Nicola Stirling 40020701
 * @author pete
 */
public class Temperate extends Grassland {

	// Constructor
	/**
	 * Constructor with args
	 * 
	 * @param realmTier - the Tier that determines the GrasslandValues
	 */
	public Temperate(RealmTier realmTier) {
		super(realmTier);
	}

	// Implementation of abstract grassland methods
	/**
	 * Method to obtain the description of the Temperate Grassland
	 * 
	 * @return - the description as a String
	 */
	@Override
	public String description() {
		return "Temperate grasslands experience heavy rainfall but also periods of drought, giving a highly diverse ecosystem";
	}

	/**
	 * Method to obtain the ascii art for the Temperate Grassland
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
