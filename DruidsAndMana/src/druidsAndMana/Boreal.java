package druidsAndMana;
/**
 * Class that extends Grassland and represents a TIER_4 Grassland object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Boreal extends Grassland {

	// Constructor
	public Boreal(RealmTier realm) {
		super(realm);
	}

	// Implementation of abstract grassland methods
	@Override
	public String description() {
		return "Cold and dry, boreal grasslands have long, cool winters and short summers";
	}
	
	@Override
	public String asciiArt() {
		return "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
			+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
