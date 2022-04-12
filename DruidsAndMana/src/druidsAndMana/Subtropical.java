package druidsAndMana;

/**
 * Class that extends Grassland and represents a Subtropical Grassland object
 *
 * @author Nicola Stirling 40020701
 * @author pete
 */
public class Subtropical extends Grassland {

	// Constructor
	/**
	 * Constructor with args
	 * 
	 * @param realmTier - the Tier that determines the GrasslandValues
	 */
	public Subtropical(RealmTier realmTier) {
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
		return "The sub-tropical grasslands have a warm and humid climate, with cooler winters";
	}

	/**
	 * Method to obtain the ascii art for the Subtropical Grassland
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
