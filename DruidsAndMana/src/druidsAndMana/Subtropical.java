package druidsAndMana;
/**
 * Class that extends GRASSLAND and represents a TIER_2 GRASSLAND object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Subtropical extends Grassland {
	public Subtropical(RealmTier realm) {
		super(realm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String description() {
		return "The sub-tropical grasslands have a warm and humid climate, with cooler winters";
	}

	@Override
	public String asciiArt() {
		return "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
			+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
